package pl.labelingRooms.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.Status;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.TeacherDto;
import pl.labelingRooms.model.dto.UserDto;
import pl.labelingRooms.service.TeacherService;

/**
 * Created by Kamil on 2016-12-01.
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController extends AbstractController<Teacher,TeacherDto, TeacherService>  {

    @Override
    public Status save(@RequestBody TeacherDto modelToSave) {
        //nothing to do
        return null;
    }

    @RequestMapping("/register")
    public Status save(@RequestBody UserDto modelToSave) {
        try {
            service.save(modelToSave);
            return new Status("", true);
        } catch (Exception e) {
            return handleException(e);
        }
    }


}
