package pl.labelingRooms.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.labelingRooms.model.WeekDay;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.service.RoomService;

/**
 * Created by Kamil on 2016-10-26.
 */
@Component
public class EventMapper extends AbstractMapper<Event, EventDto> {

    @Autowired
    RoomService roomService;

    @Override
    public Event convertToDBO(EventDto eventDto) {
        Event event = new Event();
        event.setDuration(eventDto.getDuration());
        event.setStartHour(eventDto.getStartHour());
        event.setStartMinute(eventDto.getStartMinute());
        event.setTitle(eventDto.getTitle());
        event.setWeekDay(WeekDay.getValue(eventDto.getWeekDayIndex()));
        event.setRoom(roomService.findOneDBO((long) eventDto.getRoomId()));
        return event;
    }

    @Override
    public EventDto convertToDTO(Event event) {
        if (event == null)
            return null;
        EventDto eventDto = new EventDto();
        eventDto.setDuration(event.getDuration());
        eventDto.setStartHour(event.getStartHour());
        eventDto.setStartMinute(event.getStartMinute());
        eventDto.setTitle(event.getTitle());
        eventDto.setWeekDayIndex(event.getWeekDay().getIndex());
        eventDto.setRoomId(event.getRoom().getNumber());
        return eventDto;
    }
}
