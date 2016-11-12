package pl.labelingRooms.service.mappers;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.dbo.Event;

/**
 * Created by Kamil on 2016-10-26.
 */
@Component
public class EventMapper extends AbstractMapper<Event,Event> {
    @Override
    public Event convertToDBO(Event event) {
        return event;
    }

    @Override
    public Event convertToDTO(Event event) {
        return event;
    }
}
