package com.akproject.WebLinkChecker.controllers;

import com.akproject.WebLinkChecker.model.Project;
import com.akproject.WebLinkChecker.service.ProjectService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    @NonNull
    private ProjectService projectService;

    @RequestMapping(path = "/projects", method = RequestMethod.GET)
    public ModelAndView projects() {
        List<Project> projects = projectService.findAll();

        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

}
