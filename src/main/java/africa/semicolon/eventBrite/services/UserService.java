package africa.semicolon.eventBrite.services;

import africa.semicolon.eventBrite.dtos.requests.CreateEventRequest;
import africa.semicolon.eventBrite.dtos.requests.LoginUserRequest;
import africa.semicolon.eventBrite.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.dtos.responses.CreateEventResponse;
import africa.semicolon.eventBrite.dtos.responses.LoginUserResponse;
import africa.semicolon.eventBrite.dtos.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);
    CreateEventResponse addEvent(CreateEventRequest request);
    LoginUserResponse loginUser(LoginUserRequest request);
}
