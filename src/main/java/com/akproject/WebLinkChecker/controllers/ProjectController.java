package com.akproject.WebLinkChecker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.akproject.WebLinkChecker.model.Project;
import com.akproject.WebLinkChecker.service.ProjectService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public @ResponseBody Iterable<Project> getAllUsers() {
        // This returns a JSON or XML with the project
        return projectService.findAll();
    }

}
