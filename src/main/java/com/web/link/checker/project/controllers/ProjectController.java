package com.web.link.checker.project.controllers;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.service.ProjectService;
import static com.web.link.checker.project.controllers.ProjectBinding.*;


@Controller
@RequestMapping(path = BASE_PATH)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProjectController {

    @NonNull
    private final ProjectService projectService;

    private BindingResult bindingResult;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView projects() {
        List<Project> projects = projectService.findAll();
        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

    @RequestMapping(path = SAVE, method = RequestMethod.GET)
    public ModelAndView saveView(){

        return new ModelAndView("save", "command", new Project());
    }


    @RequestMapping(path = SAVE, method = RequestMethod.POST)
    public String save(@ModelAttribute("project") @Valid Project project, BindingResult bindingResult){
        this.bindingResult = bindingResult;

        if(bindingResult.hasErrors()){
            return BASE_PATH+SAVE; //"No message available"
        }
        projectService.save(project);
        return "redirect:"+BASE_PATH;
    }


    @RequestMapping(path =SAVE_ERROR, method = RequestMethod.GET)
    public ModelAndView saveViewError(){
        ModelAndView modelAndViewError = new ModelAndView("saveError");
        String messageError = bindingResult.getFieldError("name").getDefaultMessage();
        modelAndViewError.addObject("messageError", messageError);
        return modelAndViewError;
    }


    @RequestMapping(path = UPDATE, method = RequestMethod.GET)
    public ModelAndView updateView(){
        return new ModelAndView("update");
    }



    @RequestMapping(path = UPDATE, method = RequestMethod.POST)
    public String update(@PathVariable long id, @ModelAttribute("project") @Valid Project project, BindingResult bindingResult){
        this.bindingResult = bindingResult;
        if(bindingResult.hasErrors()){
            return "redirect:"+BASE_PATH+UPDATE_ERROR;
        }
        projectService.update(id, project);
        return "redirect:"+BASE_PATH;
    }


    @RequestMapping(path = UPDATE_ERROR, method = RequestMethod.GET)
    public ModelAndView updateViewError(){
        ModelAndView modelAndViewError =  new ModelAndView("updateError");
        String messageError = bindingResult.getFieldError("name").getDefaultMessage();
        modelAndViewError.addObject("messageError", messageError);
        return modelAndViewError;
    }


    @RequestMapping(path = DELETE, method = RequestMethod.GET)
    public String delete(@PathVariable long id){
        projectService.delete(id);
        return "redirect:"+BASE_PATH+"/";
    }

}
