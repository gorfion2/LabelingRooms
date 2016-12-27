package pl.labelingRooms.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.WeekDay;
import pl.labelingRooms.model.WeekType;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.repo.EventRepository;
import pl.labelingRooms.repo.RoomRepository;

import java.util.List;

/**
 * Created by Kamil on 2016-11-22.
 */
@Component
public class EventValidator extends AbstractValidator<EventDto> {

    @Autowired
    RoomValidator roomValidator;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void validate(EventDto eventDto) throws InvalidDataException {
        validateNotNull(eventDto);
        validateAllFieldNotNull(eventDto, "id", "teacherName");
        validateTextLength(eventDto.getTitle(), 50, 1);
        validateNumber(eventDto.getEndHour(), 23, 0);
        validateNumber(eventDto.getStartHour(), 23, 0);
        validateNumber(eventDto.getEndMinute(), 59, 0);
        validateNumber(eventDto.getStartMinute(), 59, 0);
        roomValidator.validateRoomId((long) eventDto.getRoomId());
        List<Event> allByRoomAndWeekDay = eventRepository.findAllByRoomAndWeekDay(roomRepository.findOne((long) eventDto.getRoomId()), WeekDay.getValue(eventDto.getWeekDay()));

        int start = eventDto.getStartHour() * 60 + eventDto.getStartMinute();
        int end = eventDto.getEndHour() * 60 + eventDto.getEndMinute();
        for (Event event : allByRoomAndWeekDay) {
            if (event.getWeekType().equals(WeekType.getValue(eventDto.getWeek())) ||
                    event.getWeekType().equals(WeekType.getValue(eventDto.getWeek()))) {
                int eventStart = event.getStartHour() * 60 + event.getStartMinute();
                int eventEnd = eventStart + event.getDuration();
                if (eventStart > start && eventStart < end ||
                        eventEnd > start && eventEnd < end ||
                        start > eventStart && start < eventEnd ||
                        end > eventStart && end < eventEnd ||
                        end == eventEnd || start == eventStart) {
                    throw new InvalidDataException("Wydarzenie " + event.getTitle() + " odbywa się w tym czasie");
                }
            }
        }
    }
}
