package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.data.repository.UserRepository;
import africa.semicolon.eventBrite.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.expections.DuplicateEmailException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Test
    public void registerUserTest(){
        registerFunmi();
        assertEquals(1,userRepository.count());
    }

    @Test
    public void duplicateEmailThrowsExceptionTest(){
        registerFunmi();
        assertThrows(DuplicateEmailException.class, this::registerFunmi);
        try{
            registerFunmi();
        } catch ( DuplicateEmailException ex){
            assertEquals("funmi@gmail.com already exists", ex.getMessage());
        }
    }

    private void registerFunmi() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("funmi@gmail.com");
        registerUserRequest.setFirstName("Funmi");
        registerUserRequest.setLastName("Omiande");
        registerUserRequest.setPassword("IloveJesus101");
        userService.registerUser(registerUserRequest);
    }

}