package pl.labelingRooms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.labelingRooms.model.dbo.Room;

/**
 * Created by Kamil on 2016-11-12.
 */
@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {
}
