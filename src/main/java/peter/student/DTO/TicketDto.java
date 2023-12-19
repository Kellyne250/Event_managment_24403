package peter.student.DTO;

import java.time.LocalDateTime;

public class TicketDto {
    private int ticketId;
    private String ticketCategory;
    private String pricing;
    private LocalDateTime created_on;
    private LocalDateTime update_on;

    public TicketDto() {
    }

    public TicketDto(int ticketId, String ticketCategory, String pricing, LocalDateTime created_on, LocalDateTime update_on) {
        this.ticketId = ticketId;
        this.ticketCategory = ticketCategory;
        this.pricing = pricing;
        this.created_on = created_on;
        this.update_on = update_on;
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
}
