package pl.labelingRooms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.labelingRooms.model.DataWrapper;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dbo.Teacher;
import pl.labelingRooms.model.dto.EventDto;
import pl.labelingRooms.repo.EventRepository;
import pl.labelingRooms.service.mapper.EventMapper;
import pl.labelingRooms.service.validator.EventValidator;

import java.util.List;

/**
 * Created by Kamil on 2016-10-26.
 */
@Service
public class EventService extends AbstractService<Event, EventDto, EventRepository, EventMapper> {

    @Autowired
    private EventValidator eventValidator;

    public List<EventDto> getEventsByRoom(Room room) {
        if (room == null)
            return null;
        return mapper.convertToDTO(repo.findAllByRoom(room));
    }

    public DataWrapper<List<EventDto>> getEventsDataByTeacher(Teacher teacher) {
        return new DataWrapper<>(null, mapper.convertToDTO((repo.findByTeacher(teacher))));
    }

    @Override
    public void delete(EventDto modelToDelete) throws InvalidDataException {
        eventValidator.validate(modelToDelete);
        super.delete(modelToDelete);
    }

    @Override
    public void save(EventDto modelToSave) throws InvalidDataException {
        eventValidator.validate(modelToSave);
        super.save(modelToSave);
    }
}
