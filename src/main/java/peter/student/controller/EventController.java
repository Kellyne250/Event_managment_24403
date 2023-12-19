package peter.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import peter.student.model.Event;
import peter.student.services.EventService;

import java.text.ParseException;

@Controller
public class EventController {

    @Autowired
    EventService eventService;


    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("home", eventService.getAllEvent());
        return "home-page";
    }

    @GetMapping ("/search-page")
    public String searchMethod(Model model){
        Event event =new Event();
       model.addAttribute("search",event);
        return "index";
    }

    @PostMapping("/search_one")
    public String getEvent(@ModelAttribute("search") Event event,Model model){
        model.addAttribute("search",eventService.findEvent(event.getEventid()));
        return "searching";
    }

    @GetMapping("/register")
    public String registerStudentPage(Model model){
        Event eve = new Event();
        model.addAttribute("event", eve);
        return "register-event";
    }

    @PostMapping("/registeration")
    public String registerStudentInDb(@ModelAttribute("student") Event theEvent) throws ParseException {

        Event savedEvent = eventService.saveEvent(theEvent);
        if(savedEvent != null){
            return "redirect:/home";
        }
        return "/registeration";
    }

    @GetMapping("/home/edit/{eventid}")
    public String editStudent(@PathVariable String eventid, Model model){
        Event ev=new Event();
     model.addAttribute("event",eventService.findEvent(eventid));
     return "edit-event";
    }

    @PostMapping("/home/{eventid}")
    public String updateStudent(@PathVariable String eventid,@ModelAttribute("event") Event event,Model model){
        Event exitingEvent=eventService.findEvent(event.getEventid());
        exitingEvent.setEventid(event.getEventid());
        exitingEvent.setEventname(event.getEventname());
        exitingEvent.setEventDate(event.getEventDate());
        exitingEvent.setEventlocation(event.getEventlocation());
        eventService.updateEvent(exitingEvent);
        return "redirect:/home";
    }
    @GetMapping ("/home/{eventid}")
    public String deleteStudent(@PathVariable String eventid ){
   eventService.deleteEvent(eventid);
   return "redirect:/home";
    }

}
