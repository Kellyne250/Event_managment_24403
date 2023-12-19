package peter.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Builder

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ticketId;
    @Column(name = "Ticket_Category")
    private String ticketCategory;
    private String pricing;
    @CreationTimestamp
    private LocalDateTime created_on;
    @UpdateTimestamp
    private LocalDateTime update_on;

    @ManyToOne
    @JoinColumn(name="event",nullable = false)
    private Event event;



    public Ticket() {
    }

    public Ticket(int ticketId, String ticketCategory, String pricing, LocalDateTime created_on, LocalDateTime update_on, Event event) {
        this.ticketId = ticketId;
        this.ticketCategory = ticketCategory;
        this.pricing = pricing;
        this.created_on = created_on;
        this.update_on = update_on;
        this.event = event;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    public LocalDateTime getUpdate_on() {
        return update_on;
    }

    public void setUpdate_on(LocalDateTime update_on) {
        this.update_on = update_on;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
