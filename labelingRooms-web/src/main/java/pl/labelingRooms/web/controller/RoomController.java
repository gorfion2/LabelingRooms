package pl.labelingRooms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.labelingRooms.model.DataWrapper;
import pl.labelingRooms.model.EventWrapper;
import pl.labelingRooms.model.Status;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dto.MessageDto;
import pl.labelingRooms.model.dto.RoomDto;
import pl.labelingRooms.service.EventService;
import pl.labelingRooms.service.MessageService;
import pl.labelingRooms.service.RoomService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil on 2016-11-12.
 */
@RestController
@RequestMapping("/room")
public class RoomController extends AbstractController<Room, RoomDto, RoomService> {
    @Autowired
    EventService eventService;

    @Autowired
    MessageService messageService;

    @Override
    @RequestMapping("/{id}/public")
    public RoomDto findOne(@PathVariable int id) {
        return super.findOne(id);
    }

    @RequestMapping("/{roomId}/messages")
    public List<MessageDto> getMessageByRoom(@PathVariable Long roomId) {
        Room room = service.findOneDBO(roomId);
        if (room == null)
            return new ArrayList<>();
        if (!room.getTeacherRoom()) {
            return messageService.getMessagesByRoom(room);
        } else {
            return messageService.getMessagesByTeachers(room.getTeacherList());
        }
    }

    @RequestMapping("/{roomId}/events")
    public List<EventWrapper> getEventByRoom(@PathVariable Long roomId) {
        Room room = service.findOneDBO(roomId);
        if (room == null)
            return new ArrayList<>();
        if (!room.getTeacherRoom()) {
            return eventService.getEventsByRoom(room);
        } else {
            return eventService.getEventsDataByTeachers(room.getTeacherList());
        }
    }

    @RequestMapping("/all")
    public DataWrapper<List<RoomDto>> getAllRooms() {
        try {
            return new DataWrapper<List<RoomDto>>(null, service.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new DataWrapper<List<RoomDto>>(e.getMessage(), null);
        }

    }

    @RequestMapping("/edit")
    public Status edit(@RequestBody RoomDto modelToEdit) {
        try {
            service.edit(modelToEdit);
            return new Status("", true);
        } catch (Exception e) {
            return handleException(e);
        }
    }

    @RequestMapping("/{roomId}/assign")
    public Status assignRoom(@PathVariable Long roomId) {
        try {
            service.assignRoom(roomId);
            return new Status("", true);
        } catch (Exception e) {
            return handleException(e);
        }
    }

    @RequestMapping("/{roomId}/exit")
    public Status exitRoom(@PathVariable Long roomId) {
        try {
            service.exitRoom(roomId);
            return new Status("", true);
        } catch (Exception e) {
            return handleException(e);
        }
    }
}
