package com.web.link.checker.link.controller;

import com.web.link.checker.link.facade.LinkFacade;
import com.web.link.checker.link.model.LinkInsert;
import com.web.link.checker.link.model.LinkProjection;
import com.web.link.checker.link.model.LinkUpdate;
import com.web.link.checker.project.facade.ProjectFacade;
import com.web.link.checker.project.model.ProjectProjection;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import static com.web.link.checker.link.controller.LinkBinding.*;


@Controller
@RequestMapping(path = BASE_PATH)
@RequiredArgsConstructor
public class LinkController {

    private static final String PROJECT_PROJECTION = "projectProjection";
    private static final String LINK = "link";
    private static final String LINK_PROJECTION = "linkProjection";

    @NonNull
    private final LinkFacade linkFacade;

    @NonNull
    private final ProjectFacade projectFacade;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView projectLinksView(@PathVariable String projectUuid) {
        ProjectProjection projectProjection = projectFacade.findByUuid(projectUuid, ProjectProjection.class);
        ModelAndView modelAndView = new ModelAndView(LINKS_VIEW);
        modelAndView.addObject(PROJECT_PROJECTION, projectProjection);
        return modelAndView;
    }

    @RequestMapping(path = SAVE_PATH, method = RequestMethod.GET)
    public String insertView(@PathVariable String projectUuid, Model model) {
        ProjectProjection projectProjection = projectFacade.findByUuid(projectUuid, ProjectProjection.class);
        model.addAttribute(PROJECT_PROJECTION, projectProjection);
        if (!model.containsAttribute(LINK)) {
            model.addAttribute(LINK, new LinkProjection());
        }
        return SAVE_VIEW;
    }

    @RequestMapping(path = SAVE_PATH, method = RequestMethod.POST)
    public String insert(@PathVariable String projectUuid,
                         @ModelAttribute("link") @Valid LinkInsert insert,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttr) {
        if (bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + LINK, bindingResult);
            redirectAttr.addFlashAttribute(LINK, insert);
            return REDIRECT_TO_SAVE_PATH;
        }
        linkFacade.insert(projectUuid, insert);
        return REDIRECT_TO_LINKS_PATH;
    }

    @RequestMapping(path = UPDATE_PATH, method = RequestMethod.GET)
    public String updateView(@PathVariable String projectUuid,
                             @PathVariable String uuid,
                             Model model) {
        ProjectProjection projectProjection = projectFacade.findByUuid(projectUuid, ProjectProjection.class);
        LinkProjection linkProjection = linkFacade.findByUuid(uuid);
        model.addAttribute(PROJECT_PROJECTION, projectProjection);
        model.addAttribute(LINK_PROJECTION, linkProjection);
        if (!model.containsAttribute(LINK)) {
            model.addAttribute(LINK, linkProjection);
        }
        return UPDATE_VIEW;
    }

    @RequestMapping(path = UPDATE_PATH, method = RequestMethod.POST)
    public String update(@PathVariable String projectUuid,
                         @PathVariable String uuid,
                         @ModelAttribute("link") @Valid LinkUpdate update,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttr) {
        if (bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + LINK, bindingResult);
            redirectAttr.addFlashAttribute(LINK, update);
            return REDIRECT_TO_UPDATE_PATH;
        }
        linkFacade.update(projectUuid, uuid, update);
        return REDIRECT_TO_LINKS_PATH;
    }

    @RequestMapping(path = DELETE_PATH, method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String uuid) {
        linkFacade.delete(uuid);
    }
}
