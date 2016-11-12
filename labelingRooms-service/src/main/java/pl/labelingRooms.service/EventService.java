package pl.labelingRooms.service;

import org.springframework.stereotype.Service;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.repo.EventRepository;
import pl.labelingRooms.service.mappers.EventMapper;

/**
 * Created by Kamil on 2016-10-26.
 */
@Service
public class EventService extends AbstractService<Event,Event,EventRepository,EventMapper> {
}
