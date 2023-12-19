package peter.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peter.student.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
