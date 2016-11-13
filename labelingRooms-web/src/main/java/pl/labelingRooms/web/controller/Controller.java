package pl.labelingRooms.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Kamil S on 2016-03-03.
 */
@RestController
public class Controller {


    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/schedule/room/{roomId}")
    public ModelAndView schedule() {
        return new ModelAndView("schedule");
    }

}
