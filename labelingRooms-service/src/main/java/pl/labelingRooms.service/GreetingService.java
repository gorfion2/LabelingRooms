package pl.labelingRooms.service;

import org.springframework.stereotype.Service;
import pl.labelingRooms.model.dbo.Greeting;
import pl.labelingRooms.repo.GreetingRepo;
import pl.labelingRooms.service.mappers.GreetingMapper;

/**
 * Created by Kamil S on 2016-03-17.
 */
@Service
public class GreetingService extends AbstractService<Greeting,Greeting,GreetingRepo, GreetingMapper> {
}
