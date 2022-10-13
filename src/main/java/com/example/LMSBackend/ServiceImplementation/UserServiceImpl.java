package com.example.LMSBackend.ServiceImplementation;

import com.example.LMSBackend.Dto.SignInDto;
import com.example.LMSBackend.Dto.SigninDetailsDto;
import com.example.LMSBackend.Dto.UserDto;
import com.example.LMSBackend.Model.User;
import com.example.LMSBackend.Repository.UserRepository;
import com.example.LMSBackend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userrepo;

    @Override
    public boolean registerUser(UserDto newuser) {
        boolean response = false;
        try {
            User user = new User(newuser.getName(), newuser.getEmail(), newuser.getMobileNumebr(), newuser.getAddress(), newuser.getPassword(), newuser.getBirthday(), newuser.getGender(), newuser.getRole());
            userrepo.save(user);
            response = true;
        }catch (Exception e){
            System.out.println("Exception in user service layer");
        }
        return response;
    }

    @Override
    public SigninDetailsDto signIn(SignInDto signindto) {
        SigninDetailsDto signin = null;
        try {
            User foundedUser = userrepo.findUser(signindto.getEmail(), signindto.getPassword());
            signin = new SigninDetailsDto(true, foundedUser.getRole());
        }catch (Exception e){
            System.out.println("Exception in Signing method in service layer");
            signin = new SigninDetailsDto(false, null);
        }

        return signin;
    }

}

