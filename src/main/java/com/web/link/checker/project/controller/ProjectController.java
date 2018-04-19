package com.web.link.checker.project.controller;

import com.web.link.checker.project.fasade.ProjectFacade;
import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectWithLinksProjection;
import com.web.link.checker.project.model.ProjectWithoutLinksProjection;
import com.web.link.checker.project.model.ProjectUpdate;
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

import static com.web.link.checker.project.Binding.ProjectBinding.*;
import static com.web.link.checker.project.Binding.ViewBinding.*;


@Controller
@RequestMapping(path = BASE_PATH)
@RequiredArgsConstructor
public class ProjectController {

    private static final int PAGE_SIZE = 5;
    private static final String PROJECT = "project";
    private static final String PROJECT_PROJECTION = "projectProjection";
    private static final String PROJECT_PROJECTION_PAGE = "projectProjectionPage";
    private static final String CURRENT_PAGE = "currentPage";

    @NonNull
    private final ProjectFacade projectFacade;

    @RequestMapping(method = RequestMethod.GET)

    public ModelAndView projects(@PageableDefault(sort = {"name"}, value = PAGE_SIZE) final Pageable pageable) {
        int currentPage = pageable.getOffset();
        Page<ProjectWithoutLinksProjection> projectProjectionPage = projectFacade.findAllLinks(pageable, ProjectWithoutLinksProjection.class);
        ModelAndView modelAndView = new ModelAndView(PROJECTS_VIEW);
        modelAndView.addObject(PROJECT_PROJECTION_PAGE, projectProjectionPage);
        modelAndView.addObject(CURRENT_PAGE, currentPage);
        return modelAndView;
    }

    @RequestMapping(path = SAVE, method = RequestMethod.GET)
    public String insertView(Model model) {
        if (!model.containsAttribute(PROJECT)) {
            model.addAttribute(PROJECT, new ProjectInsert());
        }
        return PROJECT_SAVE_VIEW;
    }

    @RequestMapping(path = SAVE, method = RequestMethod.POST)
    public String insert(@ModelAttribute("project") @Valid ProjectInsert insert,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttr) {
        if (bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + PROJECT, bindingResult);
            redirectAttr.addFlashAttribute(PROJECT, insert);
            return REDIRECT_TO_SAVE;
        }
        projectFacade.insert(insert);
        return REDIRECT_PROJECT;
    }

    @RequestMapping(path = UPDATE, method = RequestMethod.GET)
    public String updateView(@PathVariable("uuid") String projectUuid,
                             Model model) {
        ProjectWithLinksProjection projectProjection = projectFacade.findByUuid(projectUuid, ProjectWithLinksProjection.class);
        model.addAttribute(PROJECT_PROJECTION, projectProjection);
        if (!model.containsAttribute(PROJECT)) {
            model.addAttribute(PROJECT, new ProjectUpdate());
        }
        return PROJECT_UPDATE_VIEW;
    }

    @RequestMapping(path = UPDATE, method = RequestMethod.POST)
    public String update(@PathVariable String uuid,
                         @ModelAttribute("project") @Valid ProjectUpdate update,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + PROJECT, bindingResult);
            redirectAttributes.addFlashAttribute(PROJECT, update);
            return REDIRECT_TO_UPDATE;
        }
        projectFacade.update(uuid, update);
        return REDIRECT_PROJECT;
    }

    @RequestMapping(path = DELETE, method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String uuid) {
        projectFacade.delete(uuid);
    }
}
