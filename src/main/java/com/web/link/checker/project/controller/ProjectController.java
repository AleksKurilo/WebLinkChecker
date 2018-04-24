package com.web.link.checker.project.controller;

import com.web.link.checker.project.exception.DomainObjectNotFoundException;
import com.web.link.checker.project.facade.ProjectFacade;
import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectProjection;
import com.web.link.checker.project.model.ProjectUpdate;
import com.web.link.checker.project.model.ProjectWithoutLinksProjection;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import static com.web.link.checker.project.controller.ProjectBinding.*;

@Controller
@RequestMapping(path = BASE_PATH)
@RequiredArgsConstructor
public class ProjectController {

    private static final String PROJECT = "project";
    private static final String PROJECT_PROJECTION = "projectProjection";
    private static final String PROJECT_PROJECTION_PAGE = "projectProjectionPage";

    @NonNull
    private final ProjectFacade projectFacade;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView projectsView(@PageableDefault(sort = {"name"}) final Pageable pageable) {
        Page<ProjectWithoutLinksProjection> projectProjectionPage = projectFacade.findAll(ProjectWithoutLinksProjection.class, pageable);
        ModelAndView modelAndView = new ModelAndView(PROJECTS_VIEW);
        modelAndView.addObject(PROJECT_PROJECTION_PAGE, projectProjectionPage);
        return modelAndView;
    }

    @RequestMapping(path = SAVE_PATH, method = RequestMethod.GET)
    public String insertView(Model model) {
        if (!model.containsAttribute(PROJECT)) {
            model.addAttribute(PROJECT, new ProjectInsert());
        }
        return SAVE_VIEW;
    }

    @RequestMapping(path = SAVE_PATH, method = RequestMethod.POST)
    public String insert(@ModelAttribute("project") @Valid ProjectInsert insert,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttr) {
        if (bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + PROJECT, bindingResult);
            redirectAttr.addFlashAttribute(PROJECT, insert);
            return REDIRECT_TO_SAVE_PATH;
        }
        projectFacade.insert(insert);
        return REDIRECT_PROJECT_PATH;
    }

    @RequestMapping(path = UPDATE_PATH, method = RequestMethod.GET)
    public String updateView(@PathVariable("uuid") String projectUuid,
                             Model model) {
        ProjectProjection projectProjection = projectFacade.findByUuid(projectUuid, ProjectProjection.class);
        model.addAttribute(PROJECT_PROJECTION, projectProjection);
        if (!model.containsAttribute(PROJECT)) {
            model.addAttribute(PROJECT, projectProjection);
        }
        return UPDATE_VIEW;
    }

    @RequestMapping(path = UPDATE_PATH, method = RequestMethod.POST)
    public String update(@PathVariable String uuid,
                         @ModelAttribute("project") @Valid ProjectUpdate update,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) throws DomainObjectNotFoundException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + PROJECT, bindingResult);
            redirectAttributes.addFlashAttribute(PROJECT, update);
            return REDIRECT_TO_UPDATE_PATH;
        }
        projectFacade.update(uuid, update);
        return REDIRECT_PROJECT_PATH;
    }

    @RequestMapping(path = DELETE_PATH, method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String uuid) {
        projectFacade.delete(uuid);
    }
}
