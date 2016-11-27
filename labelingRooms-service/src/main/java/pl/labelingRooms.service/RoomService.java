package pl.labelingRooms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.dbo.Room;
import pl.labelingRooms.model.dto.RoomDto;
import pl.labelingRooms.repo.RoomRepository;
import pl.labelingRooms.service.mapper.RoomMapper;
import pl.labelingRooms.service.validator.RoomValidator;

/**
 * Created by Kamil on 2016-11-12.
 */
@Service
public class RoomService extends AbstractService<Room, RoomDto, RoomRepository, RoomMapper> {

    @Autowired
    private RoomValidator roomValidator;

    @Override
    public void delete(RoomDto modelToDelete) throws InvalidDataException {
        roomValidator.validate(modelToDelete);
        super.delete(modelToDelete);
    }

    @Override
    public void save(RoomDto modelToSave) throws InvalidDataException {
        roomValidator.validate(modelToSave);
        if (repo.exists(modelToSave.getNumber())) {
            throw new InvalidDataException("Pokój już istnieje");
        }
        super.save(modelToSave);
    }

    public void edit(RoomDto modelToEdit) throws InvalidDataException {
        roomValidator.validate(modelToEdit);
        if (!repo.exists(modelToEdit.getNumber())) {
            throw new InvalidDataException("Pokój nie istnieje");
        }
        super.save(modelToEdit);
    }
}
