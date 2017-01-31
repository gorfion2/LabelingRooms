package pl.labelingRooms.web.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.labelingRooms.model.dto.EventDto;

/**
 * Created by Kamil S on 2016-03-03.
 */
@org.springframework.stereotype.Controller
public class Controller {


    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/plan")
    public ModelAndView schedule() {
        return new ModelAndView("schedule");
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        EventDto eventDto = new EventDto();
        eventDto.setTitle("title");
        eventDto.setId(123L);
        model.addAttribute("event", eventDto);
        return "greeting";
    }

    @RequestMapping("/test")
    public String greetingSubmit(@ModelAttribute EventDto greeting, Model model) {
        return "greeting";
    }

}
