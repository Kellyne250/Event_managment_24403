package peter.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import peter.student.DTO.TicketDto;
import peter.student.model.Event;
import peter.student.model.Ticket;
import peter.student.services.TicketService;

@Controller
public class TicketController {

    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping("/tickets/new/{eventid}")
    public String createTicketForm(@PathVariable("eventid") String eventid, Model model){
        Ticket ticket = new Ticket();
        model.addAttribute("eventid",eventid);
        model.addAttribute("ticket",ticket);
        return "ticket-page";
    }
    @PostMapping("/tickets/{eventid}")
    public  String createTicket(@PathVariable("eventid")String eventid, @ModelAttribute("ticket") TicketDto ticketDto, Model model)
    {
        ticketService.createEvent(eventid,ticketDto);
        return "redirect:/ticket";
    }
    @GetMapping("/ticket")
    public String homePage(Model model){
        model.addAttribute("ticket", ticketService.getAllTicket());
        return "ticket-list";
    }
    @GetMapping("/thome/edit/{ticketId}")
    public String editTicket(@PathVariable Integer ticketId, Model model){
        Ticket tick=new Ticket();
        model.addAttribute("ticket",ticketService.findTicket(ticketId));
        return "edit_ticket";
    }
    @PostMapping("/thome/{ticketId}")
    public String updateTicket(@PathVariable Integer ticketId,@ModelAttribute("ticket") Ticket ticket,Model model){
        Ticket newTicket=ticketService.findTicket(ticket.getTicketId());
        newTicket.setTicketId(ticket.getTicketId());
        newTicket.setEvent(ticket.getEvent());
        newTicket.setTicketCategory(ticket.getTicketCategory());
        newTicket.setPricing(ticket.getPricing());
        ticketService.updateTicket(newTicket);
        return "redirect:/ticket";
    }
    @GetMapping ("/thome/{ticketId}")
    public String deleteTicket(@PathVariable Integer ticketId ){
        ticketService.deleteTicket(ticketId);
        return "redirect:/ticket";
    }

}
