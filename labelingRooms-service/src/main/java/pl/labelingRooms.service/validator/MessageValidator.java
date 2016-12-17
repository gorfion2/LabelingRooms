package pl.labelingRooms.service.validator;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dto.MessageDto;

/**
 * Created by Kamil on 2016-12-13.
 */
@Component
public class MessageValidator extends AbstractValidator<MessageDto> {
    @Override
    public void validate(MessageDto messageDto) throws InvalidDataException {

    }
}
