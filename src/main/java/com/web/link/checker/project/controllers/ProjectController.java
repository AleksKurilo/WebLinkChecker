package com.web.link.checker.project.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.service.ProjectService;
import static com.web.link.checker.project.controllers.ProjectBinding.*;


@Controller
@RequestMapping(path = BASE_PATH)
@RequiredArgsConstructor
public class ProjectController {

    @NonNull
    private final ProjectService projectService;

    BindingResult bindingResult;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView projects() {
        List<Project> projects = projectService.findAll();
        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

    @RequestMapping(path =SAVE, method = RequestMethod.GET)
    public ModelAndView saveView(){
        return new ModelAndView("save");
    }

    //Test method
    @RequestMapping(path =SAVE_ERROR, method = RequestMethod.GET)
    public ModelAndView saveViewError(){
        ModelAndView modelAndViewError = new ModelAndView("saveError");
        String messageError = bindingResult.toString();
        modelAndViewError.addObject("messageError", messageError);
        return modelAndViewError;
    }


    @RequestMapping(path = SAVE, method = RequestMethod.POST)
    public String save(@ModelAttribute("project") @Valid Project project, BindingResult bindingResult){
        this.bindingResult = bindingResult;
        if(bindingResult.hasErrors()){
            return "redirect:"+BASE_PATH+SAVE_ERROR;
        }
        projectService.save(project);
        return "redirect:"+BASE_PATH+"/";
    }



    @RequestMapping(path = DELETE, method = RequestMethod.GET)
    public String delete(@PathVariable long id){
        projectService.delete(id);
        return "redirect:"+BASE_PATH+"/";
    }


}
