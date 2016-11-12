package pl.labelingRooms.repo;


import org.springframework.data.repository.CrudRepository;
import pl.labelingRooms.model.dbo.Greeting;

/**
 * Created by Kamil S on 2016-03-03.
 */
public interface GreetingRepo extends CrudRepository<Greeting,Long > {

}
