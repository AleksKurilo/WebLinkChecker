package com.akproject.WebLinkChecker.controllers;

import com.akproject.WebLinkChecker.model.Project;
import com.akproject.WebLinkChecker.service.ProjectService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping(path = "/weblinkcheker")
@RequiredArgsConstructor
public class ProjectController {

    @NonNull
    private ProjectService projectService;

    /**
     * Shows all progect in the database
     * Показывает все проекта в базе данных
     */
    @RequestMapping(path = "/projects", method = RequestMethod.GET)
    public ModelAndView projects() {
        List<Project> projects = projectService.findAll();

        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

    /**
     * Retrieves the add page
     * Возвращает страницу Добавления
     */
    @RequestMapping(path ="/projects/save", method = RequestMethod.GET)
    public ModelAndView saveView(){
        ModelAndView modelAndView = new ModelAndView("save");
        return modelAndView;
    }

    /**
     * Adds a new project by delegation the process to ProjectServisw
     * Добавляет новый project используя ProjectServisw
     */

    @RequestMapping(path = "/projects/save", method = RequestMethod.POST)
    public String saveProject(@ModelAttribute("project") Project project){
        projectService.saveProject(project);
        return "redirect:/projects";
    }

    /**
     * Retrieves the delete page
     */
    @RequestMapping(path ="/projects/delete", method = RequestMethod.GET)
    public ModelAndView deleteView(){
        ModelAndView modelAndView = new ModelAndView("delete");
        return modelAndView;
    }

    /**
     * Deletes an existing project by delegating the processing to PersonService.
     */
    @RequestMapping(path = "/projects/delete", method = RequestMethod.POST)
    public String deleteProject(@RequestParam Long id){
        projectService.deleteProject(id);
        return "redirect:/projects";
    }


}
