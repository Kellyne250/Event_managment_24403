package peter.student.services;

import peter.student.DTO.TicketDto;
import peter.student.model.Event;
import peter.student.model.Ticket;

import java.util.List;

public interface TicketService {

    void createEvent(String EventId, TicketDto ticketDto);
    public Ticket updateTicket(Ticket ticket);
    public Ticket findTicket(Integer id);
    public List<Ticket> getAllTicket();
    public void deleteTicket(Integer id);
}
