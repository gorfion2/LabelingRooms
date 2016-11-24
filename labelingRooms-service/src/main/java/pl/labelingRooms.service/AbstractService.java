package pl.labelingRooms.service;

import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.service.mapper.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Kamil S on 2016-03-16.
 */
//<Klasa DBO, Klasa DTO, Repository>
abstract public class AbstractService<DBO, DTO, R extends CrudRepository<DBO, Long>, M extends AbstractMapper<DBO, DTO>> {

    @Autowired
    R repo;

    @Autowired
    M mapper;

    public DTO findOne(Long id) {
        return mapper.convertToDTO(repo.findOne(id));
    }

    public DBO findOneDBO(Long id) {
        return repo.findOne(id);
    }

    public List<DTO> findAll() {
        return mapper.convertToDTO((List<DBO>) repo.findAll());
    }

    public void save(DTO modelToSave) throws InvalidDataException {
        repo.save(mapper.convertToDBO(modelToSave));
    }

    public void save(Iterable<DTO> modelsToSave) {
        repo.save(mapper.convertToDBO((List<DTO>) modelsToSave));
    }

    public void delete(DTO modelToDelete) throws InvalidDataException {
        repo.delete(mapper.convertToDBO(modelToDelete));
    }

    public void delete(Iterable<DTO> modelsToDelete) {
        repo.delete(mapper.convertToDBO((List<DTO>) modelsToDelete));
    }
}
