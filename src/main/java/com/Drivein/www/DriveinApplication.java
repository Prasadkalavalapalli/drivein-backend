package com.Drivein.www;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DriveinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriveinApplication.class, args);
	}
	
	@Bean
	public ModelMapper ModelMapper()
	{
		return new ModelMapper();
	}
}
