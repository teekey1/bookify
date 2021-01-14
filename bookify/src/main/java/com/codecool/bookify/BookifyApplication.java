package com.codecool.bookify;

import com.codecool.bookify.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class BookifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookifyApplication.class, args);
	}

}
