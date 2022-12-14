package com.example.LMSBackend.Controller;

import com.example.LMSBackend.Model.EmailMessage;
import com.example.LMSBackend.Service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

@RestController

@CrossOrigin
@RequestMapping("/teacher")

public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }
//send announcement using mail
    @PostMapping("/send-email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage){
        this.emailSenderService.sendEmail(emailMessage.getToEmail(),emailMessage.getSubject(),emailMessage.getBody());
        return ResponseEntity.ok("Success");
    }

}
