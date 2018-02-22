package com.web.link.checker.project.controllers;

import com.web.link.checker.project.fasade.LinkFasade;
import com.web.link.checker.project.model.LinkProjection;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/links")
@RequiredArgsConstructor
public class LinkController {

    @NonNull
    private final LinkFasade linkFasade;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView links() {
        List<LinkProjection> linkProjections = linkFasade.findAll();
        ModelAndView modelAndView = new ModelAndView("links");
        modelAndView.addObject("linkProjections", linkProjections);
        return modelAndView;
    }

    @RequestMapping(path = "/save", method = RequestMethod.GET)
    public String insertView(Model model) {
        if (!model.containsAttribute("link")) {
            model.addAttribute("link", new LinkProjection());
        }
        return "LinkSave";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String insert(@ModelAttribute("link") @Valid LinkProjection linkProjection, BindingResult bindingResult, RedirectAttributes redirectAttr) {
        if (bindingResult.hasErrors()) {
            redirectAttr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "link", bindingResult);
            redirectAttr.addFlashAttribute("link", linkProjection);

            return "redirect:" + "/links" + "/save";
        }
        if (linkProjection.getDofollow() == null) {
            linkProjection.setDofollow(false);
        }
        linkFasade.insert(linkProjection);
        return "redirect:" + "/links";
    }
}
