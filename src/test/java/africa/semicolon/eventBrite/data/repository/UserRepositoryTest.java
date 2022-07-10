package africa.semicolon.eventBrite.data.repository;

import africa.semicolon.eventBrite.data.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void savedTest(){
        User user = new User();
        userRepository.save(user);
        assertEquals(1,userRepository.count());
    }
}