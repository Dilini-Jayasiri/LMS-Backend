package com.example.LMSBackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SigninDetailsDto {
    private boolean status;
    private String role;
}
