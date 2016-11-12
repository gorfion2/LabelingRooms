package pl.labelingRooms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.labelingRooms.model.dbo.User;

/**
 * Created by Kamil S on 2016-03-05.
 */
@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    public User findByusername(String name);
}
