package pl.labelingRooms.service.validator;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dto.UserDto;

/**
 * Created by Kamil on 2016-12-01.
 */
@Component
public class UserValidator extends AbstractValidator<UserDto> {
    @Override
    public void validate(UserDto userDto) throws InvalidDataException {
        validateNotNull(userDto);
        validateAllFieldNotNull(userDto, "id");
    }
}
