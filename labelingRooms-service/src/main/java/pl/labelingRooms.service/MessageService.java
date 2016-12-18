package pl.labelingRooms.service;

import org.springframework.stereotype.Service;
import pl.labelingRooms.model.DataWrapper;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dbo.Message;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.MessageDto;
import pl.labelingRooms.repo.MessageRepository;
import pl.labelingRooms.service.mapper.MessageMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil on 2016-12-13.
 */
@Service
public class MessageService extends AbstractService<Message, MessageDto, MessageRepository, MessageMapper> {

    @Override
    public void save(MessageDto modelToSave) throws InvalidDataException {
        super.save(modelToSave);
    }

    @Override
    public void delete(MessageDto modelToDelete) throws InvalidDataException {
        super.delete(modelToDelete);
    }

    public List<MessageDto> getMessagesByRoom(Room room) {
        if (room == null)
            return null;
        return mapper.convertToDTO(repo.findAllByRoom(room));
    }

    public DataWrapper<List<MessageDto>> getMessagesByTeacher(Teacher loggedTeacher) {
        return new DataWrapper<>(null, mapper.convertToDTO((repo.findByTeacher(loggedTeacher))));
    }

    public List<MessageDto> getMessagesByTeachers(List<Teacher> teacherList) {
        ArrayList<MessageDto> messageDtos = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            messageDtos.addAll(mapper.convertToDTO((repo.findByTeacher(teacher))));
        }
        return messageDtos;
    }
}
