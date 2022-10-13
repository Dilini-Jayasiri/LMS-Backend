package com.example.LMSBackend.Service;

import com.example.LMSBackend.Dto.SignInDto;
import com.example.LMSBackend.Dto.SigninDetailsDto;
import com.example.LMSBackend.Dto.UserDto;

public interface UserService {
    boolean registerUser(UserDto newuser);
    SigninDetailsDto signIn(SignInDto signindto);
}
