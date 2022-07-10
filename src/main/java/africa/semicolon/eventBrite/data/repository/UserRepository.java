package africa.semicolon.eventBrite.data.repository;

import africa.semicolon.eventBrite.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
  Optional <User> findUserByEmail(String email);
  boolean existsByEmail(String email);
}
