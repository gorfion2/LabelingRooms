package pl.labelingRooms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.labelingRooms.model.dbo.Teacher;

/**
 * Created by Kamil on 2016-11-12.
 */
@Repository
public interface TeacherRepository extends CrudRepository<Teacher,Long> {
}
