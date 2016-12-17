package pl.labelingRooms.repo;

import org.springframework.data.repository.CrudRepository;
import pl.labelingRooms.model.dbo.Message;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dbo.Teacher;

import java.util.List;

/**
 * Created by Kamil on 2016-12-13.
 */
public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findAllByRoom(Room room);

    List<Message> findByTeacher(Teacher loggedTeacher);
}
