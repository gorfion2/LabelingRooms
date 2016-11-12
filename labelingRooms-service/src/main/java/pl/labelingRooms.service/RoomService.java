package pl.labelingRooms.service;

import org.springframework.stereotype.Service;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dto.RoomDto;
import pl.labelingRooms.repo.RoomRepository;
import pl.labelingRooms.service.mappers.RoomMapper;

/**
 * Created by Kamil on 2016-11-12.
 */
@Service
public class RoomService extends AbstractService<Room,RoomDto,RoomRepository,RoomMapper> {
}
