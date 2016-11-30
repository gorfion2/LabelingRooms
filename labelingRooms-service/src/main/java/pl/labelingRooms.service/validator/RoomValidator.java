package pl.labelingRooms.service.validator;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dto.RoomDto;

/**
 * Created by Kamil on 2016-11-27.
 */
@Component
public class RoomValidator extends AbstractValidator<RoomDto> {


    @Override
    public void validate(RoomDto roomDto) throws InvalidDataException {
        validateNotNull(roomDto);
        validateAllFieldNotNull(roomDto);
    }
}
