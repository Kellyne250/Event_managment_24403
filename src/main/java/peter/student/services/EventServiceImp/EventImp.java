package peter.student.services.EventServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peter.student.model.Event;
import peter.student.repository.EventRepository;
import peter.student.services.EventService;

import java.util.List;

@Service
public class EventImp implements EventService {
    @Autowired
    EventRepository eventRepository;
    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
      return eventRepository.save(event);
    }

    @Override
    public Event findEvent(String id) {

        return eventRepository.findById(id).get();
    }

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public void deleteEvent(String event) {
        eventRepository.deleteById(event);
    }
}
