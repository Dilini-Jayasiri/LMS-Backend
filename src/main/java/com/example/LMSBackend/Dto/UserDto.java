package com.example.LMSBackend.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private String name;
    private String email;
    private String mobileNumebr;
    private String address;
    private String password;
    private Date birthday;
    private String gender;
    private String role;
}
