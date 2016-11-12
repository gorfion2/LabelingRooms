package pl.labelingRooms.service;

import org.springframework.stereotype.Service;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.TeacherDto;
import pl.labelingRooms.repo.TeacherRepository;
import pl.labelingRooms.service.mappers.TeacherMapper;

/**
 * Created by Kamil on 2016-11-12.
 */
@Service
public class TeacherService extends AbstractService<Teacher,TeacherDto,TeacherRepository,TeacherMapper> {
}
