package com.akproject.WebLinkChecker;

import com.akproject.WebLinkChecker.model.Project;
import com.akproject.WebLinkChecker.model.ProjectRepository;
import com.akproject.WebLinkChecker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class ServiceApplication {

	@Autowired
	private ProjectService projectService;

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			//Project project = new Project("test2");
			//projectService.addProject(project);

			Iterable<Project> list = projectService.findAll();

		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
