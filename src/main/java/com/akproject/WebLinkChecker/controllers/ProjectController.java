package com.akproject.WebLinkChecker.controllers;

import com.akproject.WebLinkChecker.model.Project;
import com.akproject.WebLinkChecker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public @ResponseBody ModelAndView getListProjects() {
        ModelMap model = new ModelMap();
        Iterable<Project> projects = projectService.findAll();
        model.addAttribute("projectList", projects);

        ModelAndView view = new ModelAndView("projectList", model);

        return view;
    }

}
