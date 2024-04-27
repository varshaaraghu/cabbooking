package com.booking.cab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com")// Enable @restcontroller, @service, @repository 
@EntityScan(basePackages = "com.booking.entity")
@EnableJpaRepositories(basePackages = "com.booking.repository")
public class CabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabApplication.class, args);
	}

}
