package pl.labelingRooms.service;

import org.springframework.stereotype.Service;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.repo.EventRepository;
import pl.labelingRooms.service.mappers.EventMapper;

/**
 * Created by Kamil on 2016-10-26.
 */
@Service
public class EventService extends AbstractService<Event,EventDto,EventRepository,EventMapper> {
}
