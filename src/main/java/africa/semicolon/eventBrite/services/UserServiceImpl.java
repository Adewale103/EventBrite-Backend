package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.data.model.Event;
import africa.semicolon.eventBrite.data.model.User;
import africa.semicolon.eventBrite.data.repository.UserRepository;
import africa.semicolon.eventBrite.dtos.requests.CreateEventRequest;
import africa.semicolon.eventBrite.dtos.requests.LoginUserRequest;
import africa.semicolon.eventBrite.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.dtos.responses.CreateEventResponse;
import africa.semicolon.eventBrite.dtos.responses.LoginUserResponse;
import africa.semicolon.eventBrite.dtos.responses.RegisterUserResponse;
import africa.semicolon.eventBrite.expections.DuplicateEmailException;
import africa.semicolon.eventBrite.expections.userNotFoundException;
import africa.semicolon.eventBrite.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private EventService eventService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EventService eventService){
        this.userRepository = userRepository;
        this.eventService = eventService;
    }
    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) throw new DuplicateEmailException(request.getEmail()+" already exists");
        User user = new User();
        Mapper.map(request, user);
        User savedUser = userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        Mapper.map(savedUser, response);

        return response;
    }

    @Override
    public CreateEventResponse addEvent(CreateEventRequest request) {
        Optional<User> optionalUser = userRepository.findUserByEmail(request.getEmail());
        if(optionalUser.isEmpty()) throw new userNotFoundException(request.getEmail() + "does not exist");
        User foundUser = optionalUser.get();
        Event event = new Event();
        event.setLocation(request.getEventLocation());
        event.setTheme(request.getEventName());

        Event savedEvent = eventService.saveEvent(event);
        foundUser.getEvents().add(savedEvent);
        userRepository.save(foundUser);

        CreateEventResponse response = new CreateEventResponse();
        response.setLocation(savedEvent.getLocation());
        response.setCreatedBy(foundUser.getFirstName());
        response.setPartyName(savedEvent.getTheme());
        return response;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest request) {
         LoginUserResponse response= new LoginUserResponse();
         User user = userRepository.findUserByEmail(request.getEmail()).orElseThrow(()->
          new userNotFoundException("ops! user not found! kindly register."));
         if(Objects.equals(user.getPassword(), request.getPassword())){
            String reply = String.format("Welcome %s",request.getEmail());
            response.setMessage(reply);
      }
        else{
            response.setMessage("Incorrect details, kindly check again!");
        }
        return response;
    }
}
