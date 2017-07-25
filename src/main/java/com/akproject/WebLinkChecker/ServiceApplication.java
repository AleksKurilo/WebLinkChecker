package com.akproject.WebLinkChecker;

import com.akproject.WebLinkChecker.model.Project;
import com.akproject.WebLinkChecker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ServiceApplication {

	@Autowired
	private ProjectService projectService;

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {

			//test work ProjectService
			Iterable<Project> itarableProject = projectService.findAll();

			System.out.println("Project found with findAll():");
			System.out.println("-------------------------------");
			for (Project project : itarableProject) {
				System.out.println(project);
			}
			System.out.println();
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
