package pl.labelingRooms.model;

import pl.labelingRooms.model.dto.EventDto;

import java.util.List;

/**
 * Created by Kamil on 2016-12-18.
 */
public class EventWrapper {
    public List<EventDto> eventDtos;
    public List<String> dayNames;

    public EventWrapper(List<EventDto> eventDtos, List<String> dayNames) {
        this.eventDtos = eventDtos;
        this.dayNames = dayNames;
    }
}
