package com.example.LMSBackend.Service;

public interface EmailSenderService {
         void sendEmail(String[] to, String subject, String message) ;
}
