package pl.labelingRooms.repo;

import org.springframework.data.repository.CrudRepository;
import pl.labelingRooms.model.dbo.Event;

/**
 * Created by Kamil on 2016-10-26.
 */
public interface EventRepository extends CrudRepository<Event,Long> {
}
