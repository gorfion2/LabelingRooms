package pl.labelingRooms.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.RoomDto;
import pl.labelingRooms.repo.RoomRepository;
import pl.labelingRooms.service.TeacherService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kamil on 2016-11-12.
 */
@Component
public class RoomMapper extends AbstractMapper<Room, RoomDto> {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room convertToDBO(RoomDto roomDto) {
        Room room = roomRepository.findOne(roomDto.getNumber());
        if (room == null)
            room = new Room();
        room.setNumber(roomDto.getNumber());
        room.setBackgroundColor(roomDto.getBackgroundColor());
        room.setBorderColor(roomDto.getBorderColor());
        room.setLabColor(roomDto.getLabColor());
        room.setLabelColor(roomDto.getLabelColor());
        return room;
    }

    @Override
    public RoomDto convertToDTO(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setNumber(room.getNumber());
        roomDto.setBackgroundColor(room.getBackgroundColor());
        roomDto.setBorderColor(room.getBorderColor());
        roomDto.setLabColor(room.getLabColor());
        roomDto.setLabelColor(room.getLabelColor());
        roomDto.setTeacherNameList(generateTeacherNameList(room.getTeacherList()));
        try {
            roomDto.setYourRoom(room.getTeacherList().contains(teacherService.getLoggedTeacher()));
        } catch (InvalidDataException e) {
        }
        return roomDto;
    }

    private List<String> generateTeacherNameList(List<Teacher> teacherList) {
        return teacherList.stream().map(teacher -> {
            return new StringBuilder(teacher.getName()).append(" ").append(teacher.getSurname()).toString();
        }).collect(Collectors.toList());
    }

}
