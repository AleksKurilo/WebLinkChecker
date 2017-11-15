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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import static com.web.link.checker.project.controllers.ProjectBinding.*;


@Controller
@RequestMapping(path = BASE_PATH)
@RequiredArgsConstructor
public class ProjectController {

    @NonNull
    private final ProjectFacade projectFacade;

    private static final int PAGE_SIZE = 5;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView projects(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
        Pageable pageable =  new PageRequest (currentPage - 1, PAGE_SIZE);
        Page<ProjectProjection> projectProjectionPage = projectFacade.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("projectProjectionPage", projectProjectionPage);
        modelAndView.addObject("currentPage", currentPage);
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
        return "redirect:" + BASE_PATH;
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
        return "redirect:" + BASE_PATH;
    }

    @RequestMapping(path = DELETE, method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String uuid){
        projectFacade.delete(uuid);
    }
}
