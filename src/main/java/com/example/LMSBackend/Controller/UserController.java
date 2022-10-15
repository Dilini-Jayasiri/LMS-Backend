package com.example.LMSBackend.Controller;

import com.example.LMSBackend.Dto.SignInDto;
import com.example.LMSBackend.Dto.SigninDetailsDto;
import com.example.LMSBackend.Dto.UserDto;
import com.example.LMSBackend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins ="http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userservice;


    @PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public boolean RegisterUser(@RequestBody UserDto newUser){
        return userservice.registerUser(newUser);
    }

    @GetMapping(value = "/sign-in", produces =APPLICATION_JSON_VALUE )
    public SigninDetailsDto Sign_in(@RequestBody SignInDto signindto){
        return userservice.signIn(signindto);
    }
}
