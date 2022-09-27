package com.example.LMSBackend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LmsBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(LmsBackendApplication.class, args);
		System.out.println("LMS is Up & Running !!! ");
	}
	@Bean

	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
