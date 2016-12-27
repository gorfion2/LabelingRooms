package pl.labelingRooms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.RoomDto;
import pl.labelingRooms.repo.EventRepository;
import pl.labelingRooms.repo.MessageRepository;
import pl.labelingRooms.repo.RoomRepository;
import pl.labelingRooms.service.mapper.RoomMapper;
import pl.labelingRooms.service.validator.RoomValidator;

import java.util.ArrayList;

/**
 * Created by Kamil on 2016-11-12.
 */
@Service
public class RoomService extends AbstractService<Room, RoomDto, RoomRepository, RoomMapper> {

    @Autowired
    private RoomValidator roomValidator;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    @Transactional
    public void delete(RoomDto modelToDelete) throws InvalidDataException {
        roomValidator.validate(modelToDelete);
        Room roomToDelete = mapper.convertToDBO(modelToDelete);
        roomToDelete.setTeacherList(new ArrayList<>());
        repo.save(roomToDelete);
        messageRepository.deleteAllByRoom(roomToDelete);
        eventRepository.deleteAllByRoom(roomToDelete);
        repo.delete(roomToDelete);
    }

    @Override
    public void save(RoomDto modelToSave) throws InvalidDataException {
        roomValidator.validate(modelToSave);
        if (repo.exists(modelToSave.getNumber())) {
            throw new InvalidDataException("Pokój już istnieje");
        }
        super.save(modelToSave);
    }

    public void edit(RoomDto modelToEdit) throws InvalidDataException {
        roomValidator.validate(modelToEdit);
        roomValidator.validateModelToEdit(modelToEdit);
        super.save(modelToEdit);
    }

    @Transactional
    public void assignRoom(Long roomId) throws InvalidDataException {
        roomValidator.validateRoomId(roomId);
        Teacher loggedTeacher = teacherService.getLoggedTeacher();

        Room room = repo.findOne(roomId);
        if (!room.getTeacherList().contains(loggedTeacher)) {
            room.getTeacherList().add(loggedTeacher);
            repo.save(room);
        }
    }

    @Transactional
    public void exitRoom(Long roomId) throws InvalidDataException {
        roomValidator.validateRoomId(roomId);
        Teacher loggedTeacher = teacherService.getLoggedTeacher();

        Room room = repo.findOne(roomId);
        if (room.getTeacherList().contains(loggedTeacher)) {
            room.getTeacherList().remove(loggedTeacher);
            repo.save(room);
        }
    }
}
