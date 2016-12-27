package pl.labelingRooms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.TeacherDto;
import pl.labelingRooms.model.dto.UserDto;
import pl.labelingRooms.repo.TeacherRepository;
import pl.labelingRooms.service.mapper.TeacherMapper;
import pl.labelingRooms.service.validator.UserValidator;

/**
 * Created by Kamil on 2016-11-12.
 */
@Service
public class TeacherService extends AbstractService<Teacher, TeacherDto, TeacherRepository, TeacherMapper> {

    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

    @Transactional
    public void save(UserDto modelToSave) throws Exception {
        userValidator.validate(modelToSave);
        userService.save(modelToSave);
        repo.save(mapper.convertToDBO(modelToSave));
    }

    public Teacher getLoggedTeacher() throws InvalidDataException {
        Teacher teacher = repo.findByUsername(userService.getLoggedUsername());
        if (teacher == null)
            throw new InvalidDataException("Nie masz uprawnień");
        return teacher;
    }

}
