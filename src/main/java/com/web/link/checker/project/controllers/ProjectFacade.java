package com.web.link.checker.project.controllers;

import com.web.link.checker.project.service.ProjectService;
import lombok.Data;
import lombok.NonNull;
import org.springframework.transaction.annotation.Transactional;

@Data
public class ProjectFacade {

    @NonNull
    public ProjectService projectService;


}
