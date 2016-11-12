package pl.labelingRooms.repo;

import org.springframework.data.repository.CrudRepository;
import pl.labelingRooms.model.dbo.UserRole;

/**
 * Created by Kamil S on 2016-03-05.
 */
public interface UserRoleRepo extends CrudRepository<UserRole,Long> {
}
