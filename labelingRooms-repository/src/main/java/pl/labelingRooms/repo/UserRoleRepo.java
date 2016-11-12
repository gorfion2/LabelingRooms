package pl.labelingRooms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.labelingRooms.model.dbo.UserRole;

/**
 * Created by Kamil S on 2016-03-05.
 */
@Repository
public interface UserRoleRepo extends CrudRepository<UserRole,Long> {
}
