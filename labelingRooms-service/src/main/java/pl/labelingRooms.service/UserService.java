package pl.labelingRooms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dbo.User;
import pl.labelingRooms.model.dbo.UserRole;
import pl.labelingRooms.model.dto.UserDto;
import pl.labelingRooms.repo.UserRepo;
import pl.labelingRooms.repo.UserRoleRepo;
import pl.labelingRooms.service.mapper.UserMapper;

/**
 * Created by Kamil on 2016-12-01.
 */
@Service
public class UserService extends AbstractService<User, UserDto, UserRepo, UserMapper> {


    @Autowired
    UserRoleRepo userRoleRepo;

    @Override
    @Transactional
    public void save(UserDto modelToSave) throws InvalidDataException {
        User user = mapper.convertToDBO(modelToSave);
        repo.save(user);
        userRoleRepo.save(new UserRole(user, "ROLE_TEACHER"));
    }

    public User getLoggedUser() {
        return repo.findByusername(getLoggedUsername());
    }

    public String getLoggedUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
