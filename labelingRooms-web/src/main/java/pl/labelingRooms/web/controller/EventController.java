package pl.labelingRooms.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.labelingRooms.model.DataWrapper;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.service.EventService;

import java.util.List;

/**
 * Created by Kamil on 2016-10-26.
 */
@RestController
@RequestMapping("/event")
public class EventController extends AbstractController<Event,EventDto,EventService> {


    @RequestMapping("/my")
    public DataWrapper<List<EventDto>> getMyEvents(){

        return service.getEventsDataByTeacher(new Teacher());
    }
}
