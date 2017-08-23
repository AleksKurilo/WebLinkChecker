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
@RequestMapping(path = ProjectBinding.BASE_PATH)
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

    @RequestMapping(path = ProjectBinding.SAVE, method = RequestMethod.GET)
    public String saveView(Model model) {
        if(!model.containsAttribute("project")) {
            model.addAttribute("project", new ProjectInsert());
        }
        return "save";
    }

    @RequestMapping(path = ProjectBinding.SAVE, method = RequestMethod.POST)
    public String save(@ModelAttribute("project") @Valid ProjectInsert projectInsert, BindingResult bindingResult, RedirectAttributes redirectAttr) {
        if(bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "project", bindingResult);
            redirectAttr.addFlashAttribute("project", projectInsert);
            return "redirect:" + ProjectBinding.BASE_PATH + ProjectBinding.SAVE;
        }
        projectService.save(projectInsert);
        return "redirect:" + ProjectBinding.BASE_PATH;
    }

    @RequestMapping(path = ProjectBinding.UPDATE, method = RequestMethod.GET)
    public String updateView(Model model) {
        if(!model.containsAttribute("project")) {
            model.addAttribute("project", new ProjectUpdate());
        }
        return "update";
    }

    @RequestMapping(path = ProjectBinding.UPDATE, method = RequestMethod.POST)
    public String update(@PathVariable long id, @ModelAttribute("project") @Valid ProjectUpdate projectUpdate, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "project", bindingResult);
            redirectAttributes.addFlashAttribute("project", projectUpdate);
            return "redirect:" + ProjectBinding.BASE_PATH + ProjectBinding.UPDATE;
        }
        projectService.update(id, projectUpdate);
        return "redirect:" + ProjectBinding.BASE_PATH;
    }

    @RequestMapping(path = ProjectBinding.DELETE, method = RequestMethod.GET)
    public String delete(@PathVariable long id) {
        projectService.delete(id);
        return "redirect:" + ProjectBinding.BASE_PATH;
    }

}
