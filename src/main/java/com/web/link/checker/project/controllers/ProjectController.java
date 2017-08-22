package com.web.link.checker.project.controllers;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.service.ProjectService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import static com.web.link.checker.project.controllers.ProjectBinding.*;


@Controller
@RequestMapping(path = BASE_PATH)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProjectController {

    @NonNull
    private final ProjectService projectService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView projects() {
        List<Project> projects = projectService.findAll();
        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

    @RequestMapping(path = SAVE, method = RequestMethod.GET)
    public String saveView(Model model){
        if(!model.containsAttribute("project")) {
            model.addAttribute("project", new ProjectInsert());
        }
        return "save";
    }

    @RequestMapping(path = SAVE, method = RequestMethod.POST)
    public String save(@ModelAttribute("project") @Valid ProjectInsert projectInsert, BindingResult bindingResult, RedirectAttributes redirectAttr){
        if(bindingResult.hasErrors()){
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "project", bindingResult);
            redirectAttr.addFlashAttribute("project", projectInsert);
           return "redirect:" + BASE_PATH + SAVE;
        }
        projectService.save(projectInsert);
        return "redirect:" + BASE_PATH;
    }
//===================================================DO NOT CHANGE YET===================================================================================
    @RequestMapping(path = UPDATE, method = RequestMethod.GET)
    public String updateView(Model model){
        if(!model.containsAttribute("project")){
            model.addAttribute("project", new Project());
        }
        return "update";
    }

    @RequestMapping(path = UPDATE, method = RequestMethod.POST)
    public String update(@PathVariable long id, @ModelAttribute("project") @Valid Project project, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
           redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "project", bindingResult);
           redirectAttributes.addFlashAttribute("project", project);
           return "redirect:" + BASE_PATH + UPDATE;
        }
        projectService.update(id, project);
        return "redirect:" + BASE_PATH;
    }
//======================================================= END ===========================================================================
    @RequestMapping(path = DELETE, method = RequestMethod.GET)
    public String delete(@PathVariable long id){
        projectService.delete(id);
        return "redirect:" + BASE_PATH;
    }

}
