package com.example.LMSBackend.ServiceImplementation;

import com.example.LMSBackend.Service.EmailSenderService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    // connecting the JavaMailSender Interface
    private final JavaMailSender mailSender;

    //Constructor Parameter
    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String[] toEmail, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("randunirodrigo@gmail.com");
        msg.setTo(toEmail);
        msg.setSubject(subject);
        msg.setText(body);

        for(String to: toEmail){
            msg.setTo(to);
            System.out.println(to);
            this.mailSender.send(msg);
        }


        System.out.println("Mail Sent Successfully!");
    }
}
