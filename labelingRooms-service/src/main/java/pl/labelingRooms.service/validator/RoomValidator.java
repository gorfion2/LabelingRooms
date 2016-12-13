package pl.labelingRooms.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.RoomDto;
import pl.labelingRooms.repo.RoomRepository;

/**
 * Created by Kamil on 2016-11-27.
 */
@Component
public class RoomValidator extends AbstractValidator<RoomDto> {

    @Autowired
    RoomRepository repo;

    @Override
    public void validate(RoomDto roomDto) throws InvalidDataException {
        validateNotNull(roomDto);
        validateAllFieldNotNull(roomDto, "teacherNameList");
    }

    public void validateRoomId(Long roomId) throws InvalidDataException {
        if (roomId == null || !repo.exists(roomId))
            throw new InvalidDataException("Pokój nie istnieje");

    }
}
