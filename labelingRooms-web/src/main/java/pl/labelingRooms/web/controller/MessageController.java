package pl.labelingRooms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.labelingRooms.model.DataWrapper;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dbo.Message;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.model.dto.MessageDto;
import pl.labelingRooms.service.MessageService;
import pl.labelingRooms.service.TeacherService;

import java.util.List;

/**
 * Created by Kamil on 2016-12-13.
 */
@RestController
@RequestMapping("/message")
public class MessageController extends AbstractController<Message, MessageDto, MessageService> {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/my")
    public DataWrapper<List<MessageDto>> getMyMessages() {
        try {
            return service.getMessagesByTeacher(teacherService.getLoggedTeacher());
        } catch (InvalidDataException e) {
            return handleDataException(e);
        }
    }
}
