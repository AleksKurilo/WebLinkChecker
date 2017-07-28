package com.akproject.WebLinkChecker;

import com.akproject.WebLinkChecker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


@SpringBootApplication
public class ServiceApplication {

	@Autowired
	private ProjectService projectService;

	@Bean
	public FreeMarkerConfigurer freeMarkerConfig(){
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPath("/webapp/project.ftl");
		return freeMarkerConfigurer;
	}
/*
	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {

		};
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
