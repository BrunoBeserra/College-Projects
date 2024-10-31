package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.City;
import com.example.demo.model.CityRepository;

@SpringBootApplication
public class MidtermSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MidtermSampleApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(CityRepository cityRepo) {
		return args -> {
			cityRepo.save(new City("Vancouver", 300));
			cityRepo.save(new City("Toronto", 400));
			cityRepo.save(new City("Quebec", 250));
			
			cityRepo.findAll().forEach(System.out::println);
		};
	}

}
