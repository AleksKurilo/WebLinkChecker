package com.web.link.checker.project.controllers;

import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectProjection;
import com.web.link.checker.project.model.ProjectUpdate;
import com.web.link.checker.project.service.ProjectFacade;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.web.link.checker.project.controllers.ProjectBinding.*;


@Controller
@RequestMapping(path = BASE_PATH)
@RequiredArgsConstructor
public class ProjectController {

    @NonNull
    private final ProjectFacade projectFacade;


    @RequestMapping(path = "/page={currentPage}",method = RequestMethod.GET)
    public ModelAndView projects(@PathVariable("currentPage") int page) {
        ModelAndView modelAndView = new ModelAndView("projects");
        int pageDatabase = (page-1); //coordination of page numbers
        Pageable pageable =  new PageRequest (pageDatabase, 5);
        Page<Project> projectPage = projectFacade.findAll(pageable);
        modelAndView.addObject("projectPage", projectPage.getContent());
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", projectPage.getTotalPages());
        return modelAndView;
    }

    @RequestMapping(path = SAVE, method = RequestMethod.GET)
    public String insertView(Model model) {
        if(!model.containsAttribute("project")) {
            model.addAttribute("project", new ProjectInsert());
        }
        return "save";
    }

    @RequestMapping(path = SAVE, method = RequestMethod.POST)
    public String insert(@ModelAttribute("project") @Valid ProjectInsert projectInsert, BindingResult bindingResult, RedirectAttributes redirectAttr) {
        if(bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "project", bindingResult);
            redirectAttr.addFlashAttribute("project", projectInsert);
            return "redirect:" + BASE_PATH + SAVE;
        }
        projectFacade.insert(projectInsert);
        return "redirect:" + BASE_PATH + "/page=1";
    }

    @RequestMapping(path = UPDATE, method = RequestMethod.GET)
    public String updateView(Model model) {
        if(!model.containsAttribute("project")) {
            model.addAttribute("project", new ProjectUpdate());
        }
        return "update";
    }

    @RequestMapping(path = UPDATE, method = RequestMethod.POST)
    public String update(@PathVariable String uuid, @ModelAttribute("project") @Valid ProjectUpdate projectUpdate, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "project", bindingResult);
            redirectAttributes.addFlashAttribute("project", projectUpdate);
            return "redirect:" + BASE_PATH + UPDATE;
        }
        projectFacade.update(uuid, projectUpdate);
        return "redirect:" + BASE_PATH + "/page=1";
    }

    @RequestMapping(path = DELETE, method = RequestMethod.GET)
    public String delete(@PathVariable String uuid) {
        projectFacade.delete(uuid);
        return "redirect:" + BASE_PATH + "/page=1";
    }

}
