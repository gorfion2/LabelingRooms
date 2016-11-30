package pl.labelingRooms.service.mapper;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dto.RoomDto;

/**
 * Created by Kamil on 2016-11-12.
 */
@Component
public class RoomMapper extends AbstractMapper<Room, RoomDto> {

    @Override
    public Room convertToDBO(RoomDto roomDto) {
        Room room = new Room();
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
        return roomDto;
    }
}
