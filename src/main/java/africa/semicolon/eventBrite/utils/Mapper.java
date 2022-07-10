package africa.semicolon.eventBrite.utils;

import africa.semicolon.eventBrite.data.model.User;
import africa.semicolon.eventBrite.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.dtos.responses.RegisterUserResponse;

import java.time.format.DateTimeFormatter;


public class Mapper {

    public static void map(RegisterUserRequest request, User user){
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
    }


    public static void map(User savedUser, RegisterUserResponse response) {
        response.setEmail(savedUser.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm, a")
                .format(savedUser.getDateRegistered()));
    }
}
