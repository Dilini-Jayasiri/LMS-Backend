package com.example.LMSBackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String mobileNumebr;
    private String address;
    private String password;
    private Date birthday;
    private String gender;
    private String role;

    public User(String name, String email, String mobileNumebr, String address, String password, Date birthday, String gender, String role) {
        this.name = name;
        this.email = email;
        this.mobileNumebr = mobileNumebr;
        this.address = address;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
        this.role = role;
    }
}
