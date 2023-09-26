package com.adviseme.RESTful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EntityScan("com.adviseme.RESTful.model")
@EnableJpaAuditing

public class RestFulApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFulApplication.class, args);
	}

}
