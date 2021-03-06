package pl.labelingRooms.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.WeekDay;
import pl.labelingRooms.model.WeekType;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.service.RoomService;
import pl.labelingRooms.service.TeacherService;

/**
 * Created by Kamil on 2016-10-26.
 */
@Component
public class EventMapper extends AbstractMapper<Event, EventDto> {

    @Autowired
    RoomService roomService;

    @Autowired
    private TeacherService teacherService;

    private int endHour;
    private int endMinute;
    private int duration;

    @Override
    public Event convertToDBO(EventDto eventDto) {
        Event event = new Event();
        if (eventDto.getId() != null)
            event.setId(eventDto.getId());
        prepereDuration(eventDto.getStartHour(), eventDto.getStartMinute(), eventDto.getEndHour(), eventDto.getEndMinute());
        event.setDuration(duration);
        event.setStartHour(eventDto.getStartHour());
        event.setStartMinute(eventDto.getStartMinute());
        event.setTitle(eventDto.getTitle());
        event.setWeekDay(WeekDay.getValue(eventDto.getWeekDay()));
        event.setWeekType(WeekType.getValue(eventDto.getWeek()));
        event.setRoom(roomService.findOneDBO((long) eventDto.getRoomId()));
        try {
            event.setTeacher(teacherService.getLoggedTeacher());
        } catch (InvalidDataException e) {
        }
        return event;
    }

    private void prepereDuration(int startHour, int startMinute, int endHour, int endMinute) {
        if (startMinute > endMinute) {
            endMinute += 60;
            endHour--;
        }
        duration = endMinute - startMinute + (endHour - startHour) * 60;
    }

    @Override
    public EventDto convertToDTO(Event event) {
        if (event == null)
            return null;
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setStartHour(event.getStartHour());
        eventDto.setStartMinute(event.getStartMinute());
        prepareEndHour(event.getStartHour(), event.getStartMinute(), event.getDuration());
        eventDto.setEndHour(endHour);
        eventDto.setEndMinute(endMinute);
        eventDto.setTitle(event.getTitle());
        eventDto.setWeekDay(event.getWeekDay().getName());
        eventDto.setWeek(event.getWeekType().getName());
        eventDto.setRoomId(event.getRoom().getNumber().intValue());
        eventDto.setTeacherName(generateTeacherName(event));
        return eventDto;
    }

    private String generateTeacherName(Event event) {
        return new StringBuilder(event.getTeacher().getName().substring(0, 2)).append(" ").append(event.getTeacher().getSurname().substring(0, 2)).toString();
    }

    private void prepareEndHour(int startHour, int startMinute, int duration) {
        endHour = startHour;
        startMinute += duration;
        while (startMinute - 60 >= 0) {
            startMinute -= 60;
            endHour++;
        }
        endMinute = startMinute;
    }
}
