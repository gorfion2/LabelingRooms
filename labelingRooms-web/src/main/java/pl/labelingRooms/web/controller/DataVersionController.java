package pl.labelingRooms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.labelingRooms.model.DataWrapper;
import pl.labelingRooms.service.DataVersionService;

/**
 * Created by Kamil on 2016-12-20.
 */
@RestController
@RequestMapping("/data")
public class DataVersionController {

    @Autowired
    private DataVersionService dataVersionService;

    @RequestMapping("/version")
    public DataWrapper<Long> getDataVersionId() {
        return new DataWrapper<Long>(null, dataVersionService.getDataVersionId());
    }
}
