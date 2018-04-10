package com.web.link.checker.project.controllers;

import com.web.link.checker.project.fasade.LinkFacade;
import com.web.link.checker.project.fasade.ProjectFacade;
import com.web.link.checker.project.model.LinkInsert;
import com.web.link.checker.project.model.LinkProjection;
import com.web.link.checker.project.model.LinkUpdate;
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

import static com.web.link.checker.project.controllers.LinkBinding.*;


@Controller
@RequestMapping(path = LinkBinding.BASE_PATH)
@RequiredArgsConstructor
public class LinkController {

    private static final String PROJECT_PROJECTION = "projectProjection";
    private static final String LINK = "link";

    @NonNull
    private final LinkFacade linkFacade;

    @NonNull
    private final ProjectFacade projectFacade;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findByProjectUuid(@PathVariable("projectUuid") String projectUuid) {
        ProjectProjection projectProjection = projectFacade.getByUuid(projectUuid);
        ModelAndView modelAndView = new ModelAndView("links");
        modelAndView.addObject(PROJECT_PROJECTION, projectProjection);
        return modelAndView;
    }

    @RequestMapping(path = LinkBinding.SAVE, method = RequestMethod.GET)
    public String insertView(@PathVariable("projectUuid") String projectUuid, Model model) {
        ProjectProjection projectProjection = projectFacade.getByUuid(projectUuid);
        model.addAttribute(PROJECT_PROJECTION, projectProjection);
        if (!model.containsAttribute(LINK)) {
            model.addAttribute(LINK, new LinkProjection());
        }
        return "linkSave";
    }

    @RequestMapping(path = LinkBinding.SAVE, method = RequestMethod.POST)
    public String insert(@PathVariable("projectUuid") String projectUuid,
                         @ModelAttribute("link") @Valid LinkInsert linkInsert,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttr) {
        if (bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "link", bindingResult);
            redirectAttr.addFlashAttribute(LINK, linkInsert);
            return LinkBinding.REDIRECT_TO_SAVE;
        }
        linkFacade.insert(projectUuid, linkInsert);
        return LinkBinding.REDIRECT_TO_LINKS;
    }

    @RequestMapping(path = LinkBinding.UPDATE, method = RequestMethod.GET)
    public String updateView(@PathVariable("projectUuid") String projectUuid,
                             @PathVariable("linkUuid") String linkUuid,
                             Model model) {
        ProjectProjection projectProjection = projectFacade.getByUuid(projectUuid);
        model.addAttribute(PROJECT_PROJECTION, projectProjection);
        if (!model.containsAttribute(LINK)) {
            LinkUpdate linkUpdate = new LinkUpdate();
            linkUpdate.setUuid(linkUuid);
            model.addAttribute(LINK, linkUpdate);
            model.addAttribute(PROJECT_PROJECTION, projectProjection);
        }
        return "linkUpdate";
    }

    @RequestMapping(path = LinkBinding.UPDATE, method = RequestMethod.POST)
    public String update(@PathVariable("projectUuid") String projectUuid,
                         @PathVariable("linkUuid") String linkUuid,
                         @ModelAttribute("link") @Valid LinkUpdate linkUpdate,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttr) {
        linkUpdate.setUuid(linkUuid);
        if (bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "link", bindingResult);
            redirectAttr.addFlashAttribute(LINK, linkUpdate);
            return LinkBinding.REDIRECT_TO_UPDATE;
        }
        linkFacade.update(projectUuid, linkUuid, linkUpdate);
        return LinkBinding.REDIRECT_TO_LINKS;
    }

    @RequestMapping(path = LinkBinding.DELETE, method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String linkUuid) {
        linkFacade.delete(linkUuid);
    }
}
