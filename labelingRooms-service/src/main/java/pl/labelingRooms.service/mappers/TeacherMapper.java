package pl.labelingRooms.service.mappers;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.TeacherDto;

/**
 * Created by Kamil on 2016-11-12.
 */
@Component
public class TeacherMapper extends AbstractMapper<Teacher,TeacherDto> {
    
    @Override
    public Teacher convertToDBO(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        return teacher;
    }

    @Override
    public TeacherDto convertToDTO(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        return teacherDto;
    }
}
