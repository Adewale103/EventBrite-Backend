package africa.semicolon.eventBrite.data.repository;

import africa.semicolon.eventBrite.data.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
}
