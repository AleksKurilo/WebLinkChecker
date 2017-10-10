package com.web.link.checker.project.controllers;

import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectProjection;
import com.web.link.checker.project.model.ProjectUpdate;
import com.web.link.checker.project.service.ProjectFacade;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.web.link.checker.project.controllers.ProjectBinding.*;


@Controller
@RequestMapping(path = BASE_PATH)
@RequiredArgsConstructor
public class ProjectController {

    @NonNull
    private final ProjectFacade projectFacade;

    public static final int PAGE_SIZE = 5;


    @RequestMapping(path = "/page/", method = RequestMethod.GET)
    public ModelAndView projects(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
        int pageDatabase = (currentPage-1); //coordination of page numbers
        Pageable pageable =  new PageRequest (pageDatabase, PAGE_SIZE);
        PageImpl<ProjectProjection> projectProjectionPage = projectFacade.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("projectProjectionPage", projectProjectionPage.getContent());
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("totalPages", projectProjectionPage.getTotalPages());
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
        return "redirect:" + BASE_PATH + "page/";
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
        return "redirect:" + BASE_PATH + "page/";
    }

    @RequestMapping(path = DELETE, method = RequestMethod.GET)
    public String delete(@PathVariable String uuid) {
        projectFacade.delete(uuid);
        return "redirect:" + BASE_PATH + "page/";
    }

}
