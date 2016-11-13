package pl.labelingRooms.service;

import org.springframework.stereotype.Service;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.repo.EventRepository;
import pl.labelingRooms.service.mappers.EventMapper;

import java.util.List;

/**
 * Created by Kamil on 2016-10-26.
 */
@Service
public class EventService extends AbstractService<Event, EventDto, EventRepository, EventMapper> {

    public List<EventDto> getEventsByRoom(Room room) {
        if (room == null)
            return null;
        return mapper.convertToDTO(repo.findAllByRoom(room));
    }
}
