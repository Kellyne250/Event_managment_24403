package peter.student.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Events")
public class Event {

    @Id
    @Column(name = "Event_Id")
    private String eventid;
    @Column(name = "Event_Name")
    private String eventname;
    @Column(name = "Event_Location")
    private String eventlocation;
    @Column(name = "Event_Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;

    @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
    private Set<Ticket> tickets =new HashSet<>();


    public Event() {
    }

    public Event(String eventid, String eventname, String eventlocation, Date eventDate) {
        this.eventid = eventid;
        this.eventname = eventname;
        this.eventlocation = eventlocation;
        this.eventDate = eventDate;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
