package pl.labelingRooms.service.mappers;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.model.dto.EventDto;

/**
 * Created by Kamil on 2016-10-26.
 */
@Component
public class EventMapper extends AbstractMapper<Event,EventDto> {

    @Override
    public Event convertToDBO(EventDto eventDto) {
        Event event = new Event();
        return event;
    }

    @Override
    public EventDto convertToDTO(Event event) {
        EventDto eventDto = new EventDto();
        return eventDto;
    }
}
