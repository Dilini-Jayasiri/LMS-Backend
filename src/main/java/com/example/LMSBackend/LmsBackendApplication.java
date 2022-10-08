package com.example.LMSBackend;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class LmsBackendApplication {
//	@Autowired
//	private EmailSenderService senderService;

	public static void main(String[] args) {

		SpringApplication.run(LmsBackendApplication.class, args);
		System.out.println("LMS is Up & Running !!! ");
	}
	@Bean

	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendEmail(){
//		senderService.sendEmail("sajee.thamanga@gmail.com","This is subject","This is body");
//	}


}
