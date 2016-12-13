package pl.labelingRooms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.labelingRooms.model.DataWrapper;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.service.EventService;
import pl.labelingRooms.service.TeacherService;

import java.util.List;

/**
 * Created by Kamil on 2016-10-26.
 */
@RestController
@RequestMapping("/event")
public class EventController extends AbstractController<Event, EventDto, EventService> {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/my")
    public DataWrapper<List<EventDto>> getMyEvents() {
        try {
            return service.getEventsDataByTeacher(teacherService.getLoggedTeacher());
        } catch (InvalidDataException e) {
            return handleDataException(e);
        }
    }
}
