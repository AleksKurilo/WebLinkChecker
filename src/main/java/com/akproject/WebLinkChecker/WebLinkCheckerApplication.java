package com.akproject.WebLinkChecker;

import com.akproject.WebLinkChecker.model.User;
import com.akproject.WebLinkChecker.model.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


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


		 //	SpringApplication.run(WebLinkCheckerApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(WebLinkCheckerApplication.class);
		UserRepository repository = context.getBean(UserRepository.class);

		repository.save(new User("alga"));
	}
}
