package pl.labelingRooms.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dto.MessageDto;
import pl.labelingRooms.repo.RoomRepository;
import pl.labelingRooms.service.TeacherService;

/**
 * Created by Kamil on 2016-12-13.
 */
@Component
public class MessageValidator extends AbstractValidator<MessageDto> {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private TeacherService teacherService;

    @Override
    public void validate(MessageDto messageDto) throws InvalidDataException {
        validateNotNull(messageDto);
        validateAllFieldNotNull(messageDto, "teacherName", "date");
        validateTextLength(messageDto.getMessageText(), 128, 1);
        if (roomRepository.findOneByNumber(messageDto.getRoomNumber()) == null) {
            throw new InvalidDataException("Pokój o podanym numerze nie istnieje");
        }
        teacherService.getLoggedTeacher();
    }

}
