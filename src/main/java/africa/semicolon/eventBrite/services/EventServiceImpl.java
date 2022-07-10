package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.data.model.Event;
import africa.semicolon.eventBrite.data.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
}
