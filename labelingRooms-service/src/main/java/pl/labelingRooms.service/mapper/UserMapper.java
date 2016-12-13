package pl.labelingRooms.service.mapper;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.dbo.User;
import pl.labelingRooms.model.dbo.UserRole;
import pl.labelingRooms.model.dto.UserDto;

import java.util.LinkedHashSet;

/**
 * Created by Kamil on 2016-12-01.
 */
@Component
public class UserMapper extends AbstractMapper<User,UserDto> {
    @Override
    public User convertToDBO(UserDto userDto) {
        User user = new User();
        user.setEnabled(true);
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }

    @Override
    public UserDto convertToDTO(User user) {
        //TO DO
        return null;
    }
}
