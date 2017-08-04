package com.akproject.WebLinkChecker.controllers;

import com.akproject.WebLinkChecker.model.Project;
import com.akproject.WebLinkChecker.service.ProjectService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    @NonNull
    private final ProjectService projectService;

    @RequestMapping(path = "/projects", method = RequestMethod.GET)
    public ModelAndView projects() {
        List<Project> projects = projectService.findAll();

        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

    @RequestMapping(path ="/projects/save", method = RequestMethod.GET)
    public ModelAndView saveView(){
        return new ModelAndView("save");
    }

    @RequestMapping(path = "/projects/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("project") Project project){
        projectService.save(project);
        return "redirect:/projects";
    }

    @RequestMapping(path = " /projects/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable long id){
        projectService.deleteProject(id);
        return "redirect:/projects";
    }


}
