package pl.labelingRooms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.model.dto.RoomDto;
import pl.labelingRooms.service.EventService;
import pl.labelingRooms.service.RoomService;

import java.util.List;

/**
 * Created by Kamil on 2016-11-12.
 */
@RestController
@RequestMapping("/room")
public class RoomController extends AbstractController<Room, RoomDto, RoomService> {
    @Autowired
    EventService eventService;

    @RequestMapping("/{roomId}/events")
    public List<EventDto> getEventByRoom(@PathVariable Long roomId) {
        return eventService.getEventsByRoom(service.findOneDBO(roomId));
    }
}
