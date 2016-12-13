package pl.labelingRooms.service.mapper;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.TeacherDto;
import pl.labelingRooms.model.dto.UserDto;

import java.util.ArrayList;

/**
 * Created by Kamil on 2016-11-12.
 */
@Component
public class TeacherMapper extends AbstractMapper<Teacher, TeacherDto> {

    @Override
    public Teacher convertToDBO(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        return teacher;
    }

    public Teacher convertToDBO(UserDto userDto) {
        Teacher teacher = new Teacher();
        if (userDto.getId() != null)
            teacher.setId(userDto.getId());
        teacher.setName(userDto.getName());
        teacher.setSurname(userDto.getSurname());
        teacher.setRoomList(new ArrayList<>());
        teacher.setUsername(userDto.getUsername());
        return teacher;
    }

    @Override
    public TeacherDto convertToDTO(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        return teacherDto;
    }
}
