package com.web.link.checker.project.controllers;

import com.web.link.checker.project.fasade.ProjectFacade;
import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectWithoutLinksProjection;
import com.web.link.checker.project.model.ProjectUpdate;
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
@RequestMapping(path = ProjectBinding.BASE_PATH)
@RequiredArgsConstructor
public class ProjectController {

    private static final int PAGE_SIZE = 5;
    private static final String PROJECT = "project";

    @NonNull
    private final ProjectFacade projectFacade;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView projects(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
        Pageable pageable = new PageRequest(currentPage - 1, PAGE_SIZE);
        Page<ProjectWithoutLinksProjection> projectProjectionPage = projectFacade.findAllWithoutLinks(pageable);
        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("projectProjectionPage", projectProjectionPage);
        modelAndView.addObject("currentPage", currentPage);
        return modelAndView;
    }

    @RequestMapping(path = ProjectBinding.SAVE, method = RequestMethod.GET)
    public String insertView(Model model) {
        if (!model.containsAttribute(PROJECT)) {
            model.addAttribute(PROJECT, new ProjectInsert());
        }
        return "save";
    }

    @RequestMapping(path = ProjectBinding.SAVE, method = RequestMethod.POST)
    public String insert(@ModelAttribute("project") @Valid ProjectInsert projectInsert, BindingResult bindingResult, RedirectAttributes redirectAttr) {
        if (bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + PROJECT, bindingResult);
            redirectAttr.addFlashAttribute(PROJECT, projectInsert);
            return ProjectBinding.REDIRECT_TO_SAVE;
        }
        projectFacade.insert(projectInsert);
        return ProjectBinding.REDIRECT_PROJECT;
    }

    @RequestMapping(path = ProjectBinding.UPDATE, method = RequestMethod.GET)
    public String updateView(Model model) {
        if (!model.containsAttribute(PROJECT)) {
            model.addAttribute(PROJECT, new ProjectUpdate());
        }
        return "update";
    }

    @RequestMapping(path = ProjectBinding.UPDATE, method = RequestMethod.POST)
    public String update(@PathVariable String uuid,
                         @ModelAttribute("project") @Valid ProjectUpdate projectUpdate,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + PROJECT, bindingResult);
            redirectAttributes.addFlashAttribute(PROJECT, projectUpdate);
            return ProjectBinding.REDIRECT_TO_UPDATE;
        }
        projectFacade.update(uuid, projectUpdate);
        return ProjectBinding.REDIRECT_PROJECT;
    }

    @RequestMapping(path = ProjectBinding.DELETE, method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String uuid) {
        projectFacade.delete(uuid);
    }
}
