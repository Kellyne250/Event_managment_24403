package peter.student.services;

import peter.student.model.Event;


import java.util.List;

public interface EventService {
    public Event saveEvent(Event event);
    public Event updateEvent(Event event);
    public Event findEvent(String id);
    public List<Event> getAllEvent();
    public void deleteEvent(String id);
}
