package com.web.link.checker.project.controllers;

import com.web.link.checker.project.model.LinkProjection;
import com.web.link.checker.project.service.LinkFasade;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/link")
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
}
