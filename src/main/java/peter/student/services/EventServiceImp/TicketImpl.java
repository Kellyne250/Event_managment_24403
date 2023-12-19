package peter.student.services.EventServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peter.student.DTO.TicketDto;
import peter.student.model.Event;
import peter.student.model.Ticket;
import peter.student.repository.EventRepository;
import peter.student.repository.TicketRepository;
import peter.student.services.TicketService;

import java.util.List;

@Service
public class TicketImpl implements TicketService {

    private EventRepository eventRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketImpl(EventRepository eventRepository, TicketRepository ticketRepository) {
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void createEvent(String eventid, TicketDto ticketDto) {
         Event event =eventRepository.findById(eventid).get();
         Ticket ticket =mapToTicket(ticketDto);
         ticket.setEvent(event);
         ticketRepository.save(ticket);

    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket findTicket(Integer id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    @Override
    public void deleteTicket(Integer id) {
       ticketRepository.deleteById(id);
    }

    private Ticket mapToTicket(TicketDto ticketDto){
        return Ticket.builder()
                .ticketId(ticketDto.getTicketId())
                .ticketCategory(ticketDto.getTicketCategory())
                .created_on(ticketDto.getCreated_on())
                .pricing(ticketDto.getPricing())
                .update_on(ticketDto.getUpdate_on())
                .build();

    }
}
