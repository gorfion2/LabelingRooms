package pl.labelingRooms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.service.EventService;

import java.util.List;

/**
 * Created by Kamil on 2016-11-12.
 */
@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    EventService eventService;

    @RequestMapping("/{roomId}/events")
    public List<EventDto> getEventByRoom(@PathVariable Long roomId) {
        return eventService.findAll();
    }
}
