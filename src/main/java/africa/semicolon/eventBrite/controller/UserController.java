package africa.semicolon.eventBrite.controller;

import africa.semicolon.eventBrite.dtos.requests.CreateEventRequest;
import africa.semicolon.eventBrite.dtos.requests.LoginUserRequest;
import africa.semicolon.eventBrite.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventBrite.dtos.responses.ApiResponse;
import africa.semicolon.eventBrite.dtos.responses.LoginUserResponse;
import africa.semicolon.eventBrite.dtos.responses.RegisterUserResponse;
import africa.semicolon.eventBrite.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest) {
        try {
            var serviceResponse  = userService.registerUser(registerUserRequest);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>( response,HttpStatus.CREATED);
        }
        catch (Exception ex){
            ApiResponse response = new ApiResponse(false, ex.getMessage());
            return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user/login")
    public LoginUserResponse login(@RequestBody LoginUserRequest loginUserRequest){
        return userService.loginUser(loginUserRequest);
    }

    @PostMapping("/party")
    public ResponseEntity<?> createEvent(@RequestBody CreateEventRequest request){
        try{
            var serviceResponse = userService.addEvent(request);
            ApiResponse response = new ApiResponse(true,serviceResponse);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } catch(Exception ex){
            ApiResponse response = new ApiResponse(false,ex.getMessage());
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }


}
