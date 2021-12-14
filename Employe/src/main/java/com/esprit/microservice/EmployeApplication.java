package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
public class EmployeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeApplication.class, args);
	}

	@Bean
    ApplicationRunner init(EmployeRepository repository) {
        return args -> {
            Stream.of("Mariem", "Sarra", "Mohamed").forEach(nom -> {
                repository.save(new Employe(nom));
            });
            repository.findAll().forEach(System.out::println);
        };
    }

}
