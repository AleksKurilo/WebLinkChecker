package com.web.link.checker.project.controllers;

import com.web.link.checker.project.fasade.LinkFasade;
import com.web.link.checker.project.fasade.ProjectFacade;
import com.web.link.checker.project.model.LinkProjection;
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
@RequestMapping(path = LINK_BASE_PATH)
@RequiredArgsConstructor
public class LinkController {

    @NonNull
    private final LinkFasade linkFasade;

    @NonNull
    private final ProjectFacade projectFacade;

    //http://localhost:8080/projects/

    @RequestMapping(path = GET_PROJECT_LINKS, method = RequestMethod.GET)
    public ModelAndView linksProject(@PathVariable("projectUuid") String projectUuid) {
        ProjectProjection projectProjection = projectFacade.getByUuid(projectUuid);
        ModelAndView modelAndView = new ModelAndView("links");
        modelAndView.addObject("projectProjection", projectProjection);
        return modelAndView;
    }


    @RequestMapping(path = LINK_SAVE, method = RequestMethod.GET)
    public String insertView(@PathVariable("projectUuid") String projectUuid, Model model) {
        ProjectProjection projectProjection = new ProjectProjection();
        projectProjection.setUuid(projectUuid);
        model.addAttribute("projectProjection", projectProjection);
        if (!model.containsAttribute("link")) {
            model.addAttribute("link", new LinkProjection());
         }
        return "linkSave";
    }

    @RequestMapping(path = LINK_SAVE, method = RequestMethod.POST)
    public String insert(@PathVariable("projectUuid") String projectUuid,
                         @ModelAttribute("link") @Valid LinkProjection linkProjection,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttr) {
        if (bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "link", bindingResult);
            redirectAttr.addFlashAttribute("link", linkProjection);

            return "redirect:" + "/links/project/" + projectUuid + "/save";
        }
        if (linkProjection.getDofollow() == null) {
            linkProjection.setDofollow(false);
        }
        linkFasade.insert(projectUuid, linkProjection);
        return "redirect:" + "/links/project/" + projectUuid;
    }

    @RequestMapping(path = LINK_UPDATE, method = RequestMethod.GET)
    public String updateView(@PathVariable("projectUuid") String projectUuid,
                             @PathVariable("linkId") Long linkId,
                             Model model) {
        ProjectProjection projectProjection = new ProjectProjection();
        projectProjection.setUuid(projectUuid);
        model.addAttribute("projectProjection", projectProjection);
        if (!model.containsAttribute("link")) {
            LinkProjection linkProjection = new LinkProjection();
            linkProjection.setId(linkId);
            model.addAttribute("link", linkProjection);
            model.addAttribute("projectProjection", projectProjection);
        }
        return "linkUpdate";
    }

    @RequestMapping(path = LINK_UPDATE, method = RequestMethod.POST)
    public String update(@PathVariable("projectUuid") String projectUuid,
                         @PathVariable("linkId") Long linkId,
                         @ModelAttribute("link") @Valid LinkProjection linkProjection,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttr) {
        linkProjection.setId(linkId);
        if (bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "link", bindingResult);
            redirectAttr.addFlashAttribute("link", linkProjection);

            return "redirect:" + "/links/project/" + projectUuid + "/link/" + linkId;
        }
        if (linkProjection.getDofollow() == null) {
            linkProjection.setDofollow(false);
        }
        linkProjection.setId(linkId);
        linkFasade.update(projectUuid, linkProjection);
        return "redirect:" + "/links/project/" + projectUuid;
    }

    @RequestMapping(path = LINK_DELETE, method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long linkId) {
        linkFasade.delete(linkId);
    }
}
