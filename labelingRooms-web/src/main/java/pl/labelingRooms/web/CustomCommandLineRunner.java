package pl.labelingRooms.web;

import org.springframework.boot.CommandLineRunner;
import pl.labelingRooms.model.dto.UserDto;
import pl.labelingRooms.service.TeacherService;

/**
 * Created by Kamil on 2016-12-17.
 */
public class CustomCommandLineRunner implements CommandLineRunner {

    private TeacherService teacherService;

    public CustomCommandLineRunner(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public void run(String... args) throws Exception {
        int numberOfTeacher = teacherService.findAll().size();
        if (numberOfTeacher == 0) {
            teacherService.save(new UserDto(1L, "admin", "admin1", "admin", "admin"));
        }
    }
}
