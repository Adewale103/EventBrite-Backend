package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.data.model.Event;
import africa.semicolon.eventBrite.data.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventServiceImplTest {
    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void addNewPartyTest(){
        Event event = new Event();
        Event savedParty = eventService.saveEvent(event);
        assertEquals(1, eventRepository.count());
    }



}