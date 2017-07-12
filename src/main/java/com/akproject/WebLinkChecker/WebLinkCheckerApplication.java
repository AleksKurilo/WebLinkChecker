package com.akproject.WebLinkChecker;

import models.User;
import models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebLinkCheckerApplication {
/*
	@Autowired
	private UserRepository userRepository;

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			User user = new User("ss");
			userRepository.save(user);
		};
	}
*/
	public static void main(String[] args) {

	//
		// 	SpringApplication.run(WebLinkCheckerApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(WebLinkCheckerApplication.class);
		UserRepository repository = context.getBean(UserRepository.class);

		repository.save(new User("aleks"));
	}
}
