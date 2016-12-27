package pl.labelingRooms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.labelingRooms.model.*;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.repo.EventRepository;
import pl.labelingRooms.service.mapper.EventMapper;
import pl.labelingRooms.service.validator.EventValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kamil on 2016-10-26.
 */
@Service
public class EventService extends AbstractService<Event, EventDto, EventRepository, EventMapper> {

    @Autowired
    private EventValidator eventValidator;

    public DataWrapper<List<EventDto>> getEventsDataByTeacher(Teacher teacher) {
        return new DataWrapper<>(null, mapper.convertToDTO((repo.findByTeacher(teacher))));
    }

    @Override
    public void delete(EventDto modelToDelete) throws InvalidDataException {
        eventValidator.validate(modelToDelete);
        super.delete(modelToDelete);
    }

    @Override
    public void save(EventDto modelToSave) throws InvalidDataException {
        eventValidator.validate(modelToSave);
        super.save(modelToSave);
    }

    public List<EventWrapper> getEventsDataByTeachers(List<Teacher> teacherList) {

        List<EventWrapper> eventWrappers = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            List<Event> allByTeacher = repo.findByTeacher(teacher);
            EventWrapper eventEvents = createEventWrapper(allByTeacher, WeekType.EVEN);
            eventEvents.title = teacher.getName() + " " + teacher.getSurname() + " tydzień parzysty";
            eventWrappers.add(eventEvents);
            EventWrapper oddEvents = createEventWrapper(allByTeacher, WeekType.ODD);
            oddEvents.title = teacher.getName() + " " + teacher.getSurname() + " tydzień nieparzysty";
            eventWrappers.add(oddEvents);
        }
        return eventWrappers;
    }

    public List<EventWrapper> getEventsByRoom(Room room) {
        if (room == null)
            return null;
        List<Event> allByRoom = repo.findAllByRoom(room);
        List<EventWrapper> eventWrappers = new ArrayList<>();
        EventWrapper evenEvents = createEventWrapper(allByRoom, WeekType.EVEN);
        evenEvents.title = "Pokój " + room.getNumber() + " tydzień parzysty";
        eventWrappers.add(evenEvents);
        EventWrapper oddEvents = createEventWrapper(allByRoom, WeekType.ODD);
        oddEvents.title = "Pokój " + room.getNumber() + " tydzień nieparzysty";
        eventWrappers.add(oddEvents);

        return eventWrappers;
    }

    private EventWrapper createEventWrapper(List<Event> allEvent, WeekType weekType) {
        boolean oddWeek = weekType.equals(WeekType.ODD);
        EventWrapper eventWrapper = new EventWrapper(mapper.convertToDTO(
                allEvent.stream().filter(event -> event.getWeekType().equals(weekType)
                        || event.getWeekType().equals(WeekType.ALL)).collect(Collectors.toList())),
                WeekDay.getDayNames(oddWeek));
        if (oddWeek) {
            eventWrapper.eventDtos.stream().forEach(eventDto -> eventDto.setWeekDay(eventDto.getWeekDay() + " np"));
        }
        return eventWrapper;
    }
}
