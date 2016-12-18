package pl.labelingRooms.service.validator;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dto.EventDto;

/**
 * Created by Kamil on 2016-11-22.
 */
@Component
public class EventValidator extends AbstractValidator<EventDto> {
    @Override
    public void validate(EventDto eventDto) throws InvalidDataException {
        validateNotNull(eventDto);
        validateAllFieldNotNull(eventDto, "id", "week", "teacherName");
    }
}
