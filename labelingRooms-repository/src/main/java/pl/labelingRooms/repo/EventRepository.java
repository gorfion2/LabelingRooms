package pl.labelingRooms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dbo.Teacher;

import java.util.List;

/**
 * Created by Kamil on 2016-10-26.
 */
@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAllByRoom(Room room);

    List<Event> findByTeacher(Teacher teacher);
}
