package pl.labelingRooms.service.mapper;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dto.RoomDto;

/**
 * Created by Kamil on 2016-11-12.
 */
@Component
public class RoomMapper extends AbstractMapper<Room,RoomDto> {

    @Override
    public Room convertToDBO(RoomDto roomDto) {
        Room room = new Room();
        return room;
    }

    @Override
    public RoomDto convertToDTO(Room room) {
        RoomDto roomDto = new RoomDto();
        return roomDto;
    }
}
