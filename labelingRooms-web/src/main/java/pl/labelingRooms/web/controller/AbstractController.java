package pl.labelingRooms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.labelingRooms.model.InvalidDataException;
import pl.labelingRooms.model.Status;
import pl.labelingRooms.service.AbstractService;
import pl.labelingRooms.service.mapper.AbstractMapper;

/**
 * Created by Kamil S on 2016-03-16.
 */
//<Klasa DBO, Klasa DTO, Service>
abstract public class AbstractController<DBO, DTO, S extends AbstractService<DBO, DTO, ? extends CrudRepository<DBO, Long>, ? extends AbstractMapper<DBO, DTO>>> {

    @Autowired
    S service;

    @RequestMapping("/{id}")
    public DTO findOne(@PathVariable int id) {
        return service.findOne(new Long(id));
    }

//    @RequestMapping("/all")
//    public Iterable<DTO> findAll() {
//        return service.findAll();
//    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Status save(@RequestBody DTO modelToSave) {
        try {
            service.save(modelToSave);
            return new Status("", true);
        } catch (Exception e) {
            return handleException(e);
        }
    }

//    @RequestMapping(value = "/save/all", method = RequestMethod.POST)
//    public void save(@RequestBody Iterable<DTO> modelsToSave) {
//        service.save(modelsToSave);
//    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public Status delete(@RequestBody DTO modelToDelete) {
        try {
            service.delete(modelToDelete);
            return new Status("", true);
        } catch (Exception e) {
            return handleException(e);
        }
    }

//    @RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
//    public void delete(@RequestBody Iterable<DTO> modelsToDelete) {
//        service.delete(modelsToDelete);
//    }

    protected Status handleException(Exception e) {
        if (e instanceof InvalidDataException) {
            return new Status(((InvalidDataException) e).getReason(), false);
        }
        return new Status("Wystąpił problem", false);

    }
}
