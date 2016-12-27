package pl.labelingRooms.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
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
        validateAllFieldNotNull(roomDto, "teacherNameList", "title");
        validateNumber(roomDto.getEventFontSize(), 500, 10);
        validateNumber(roomDto.getMessageFontSize(), 500, 10);
        validateTextLength(roomDto.getBackgroundColor(), 7, 6);
        validateTextLength(roomDto.getBorderColor(), 7, 6);
        validateTextLength(roomDto.getLabelColor(), 7, 6);
        validateTextLength(roomDto.getLabColor(), 7, 6);
    }

    public void validateRoomId(Long roomId) throws InvalidDataException {
        if (roomId == null || !repo.exists(roomId))
            throw new InvalidDataException("Pokój nie istnieje");

    }

    public void validateModelToEdit(RoomDto modelToEdit) throws InvalidDataException {
        validateRoomId(modelToEdit.getNumber());
        if (modelToEdit.isTeacherRoom()) {
            if (!repo.findOne(modelToEdit.getNumber()).getEventList().isEmpty())
                throw new InvalidDataException("Pokój nie może zostać pokojem do konsultacji, ponieważ odbywają się w nim zajęcia");
        } else {
            if (!repo.findOne(modelToEdit.getNumber()).getTeacherList().isEmpty())
                throw new InvalidDataException("Pokój nie może zostać loboratorium, ponieważ ma przypisanych nauczycieli");

        }
    }
}
