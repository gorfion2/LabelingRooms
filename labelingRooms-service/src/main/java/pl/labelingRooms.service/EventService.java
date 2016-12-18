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

    public List<EventWrapper> getEventsByRoom(Room room) {
        if (room == null)
            return null;
        List<Event> allByRoom = repo.findAllByRoom(room);
        List<EventWrapper> eventWrappers = new ArrayList<>();
        eventWrappers.add(new EventWrapper(mapper.convertToDTO(
                allByRoom.stream().filter(event -> event.getWeekType().equals(WeekType.EVEN)
                        || event.getWeekType().equals(WeekType.ALL)).collect(Collectors.toList())),
                WeekDay.getDayNames(false)));

        EventWrapper odEvents = new EventWrapper(mapper.convertToDTO(
                allByRoom.stream().filter(event -> event.getWeekType().equals(WeekType.ODD)
                        || event.getWeekType().equals(WeekType.ALL)).collect(Collectors.toList())),
                WeekDay.getDayNames(true));
        odEvents.eventDtos.stream().forEach(eventDto -> eventDto.setWeekDay(eventDto.getWeekDay() + " np"));
        eventWrappers.add(odEvents);

        return eventWrappers;
    }

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

    public List<EventDto> getEventsDataByTeachers(List<Teacher> teacherList) {
        ArrayList<EventDto> eventDtos = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            eventDtos.addAll(mapper.convertToDTO((repo.findByTeacher(teacher))));
        }
        return eventDtos;
    }
}
