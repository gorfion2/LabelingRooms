package pl.labelingRooms.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.labelingRooms.model.dbo.Event;
import pl.labelingRooms.service.EventService;

/**
 * Created by Kamil on 2016-10-26.
 */
@RestController
@RequestMapping("/event")
public class EventController extends AbstractController<Event,Event,EventService> {
}
