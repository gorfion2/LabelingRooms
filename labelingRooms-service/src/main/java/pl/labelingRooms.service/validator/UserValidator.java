package pl.labelingRooms.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dto.UserDto;
import pl.labelingRooms.repo.TeacherRepository;

/**
 * Created by Kamil on 2016-12-01.
 */
@Component
public class UserValidator extends AbstractValidator<UserDto> {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void validate(UserDto userDto) throws InvalidDataException {
        validateNotNull(userDto);
        validateAllFieldNotNull(userDto, "id");
        validateTextLength(userDto.getUsername(), 20, 5);
        validateTextLength(userDto.getPassword(), 20, 5);
        validateTextLength(userDto.getSurname(), 50, 3);
        validateTextLength(userDto.getName(), 50, 3);
        if (teacherRepository.findByUsername(userDto.getUsername()) != null) {
            throw new InvalidDataException("Nazwa użytkownika jest już zajęta");
        }
    }
}
