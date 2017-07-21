package com.akproject.WebLinkChecker;

import com.akproject.WebLinkChecker.model.Project;
import com.akproject.WebLinkChecker.model.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ServiceApplication {

	@Autowired
	private ProjectRepository projectRepository;

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			Project project = new Project("aleks");
			projectRepository.save(project);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
