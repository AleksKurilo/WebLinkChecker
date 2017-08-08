package com.web.link.checker.project.controllers;

import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.service.ProjectService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping(path = "/projects")
@RequiredArgsConstructor
public class ProjectController {

    @NonNull
    private final ProjectService projectService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView projects() {
        List<Project> projects = projectService.findAll();

        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

    @RequestMapping(path ="/save", method = RequestMethod.GET)
    public ModelAndView saveView(){
        return new ModelAndView("save");
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("project") Project project){
        projectService.save(project);
        return "redirect:/projects";
    }

    @RequestMapping(path = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable long id){
        projectService.delete(id);
        return "redirect:/projects";
    }


}
