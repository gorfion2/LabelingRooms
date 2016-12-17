package pl.labelingRooms.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dbo.Message;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.MessageDto;
import pl.labelingRooms.service.RoomService;
import pl.labelingRooms.service.TeacherService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kamil on 2016-12-13.
 */
@Component
public class MessageMapper extends AbstractMapper<Message, MessageDto> {

    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Autowired
    RoomService roomService;

    @Autowired
    TeacherService teacherService;

    @Override
    public Message convertToDBO(MessageDto messageDto) {
        Message message = new Message();
        message.setId(messageDto.getId());
        message.setMessageText(messageDto.getMessageText());
        message.setRoom(roomService.findOneDBO(messageDto.getRoomNumber()));
        message.setDate(new Date());
        try {
            message.setTeacher(teacherService.getLoggedTeacher());
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public MessageDto convertToDTO(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setMessageText(message.getMessageText());
        messageDto.setRoomNumber(message.getRoom().getNumber());
        Teacher teacher = message.getTeacher();
        messageDto.setTeacherName(teacher.getName() + " " + teacher.getSurname());
        messageDto.setDate(df.format(message.getDate()));
        return messageDto;
    }
}
