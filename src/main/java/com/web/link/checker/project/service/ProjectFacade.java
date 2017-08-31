package com.web.link.checker.project.service;

import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectProjection;
import com.web.link.checker.project.model.ProjectUpdate;
import com.web.link.checker.project.model.Project;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectFacade {

    @NonNull
    private final ProjectService projectService;

    @NonNull
    private final ConversionService conversionService;

    public List<ProjectProjection>  findAll(){
        List<Project> projects = projectService.findAll();
        List<ProjectProjection> projectProjections = projects.stream()
                .map(project -> conversionService.convert(project, ProjectProjection.class))
                .collect(Collectors.toList());
        return projectProjections;
    }

    public void insert(ProjectInsert projectInsert){
        Validate.notNull(projectInsert, "projectInsert is null in ProjectFacade.class");
        projectService.insert(projectInsert);
    }

    public void update(String uuid, ProjectUpdate projectUpdate){
        Validate.notNull(projectUpdate, "projectUpdate is null in ProjectFacade.class");
        projectService.update(uuid, projectUpdate);
    }

    public void delete(String uuid){
        Validate.notNull(uuid, "uuid is null in ProjectService.class");
        projectService.delete(uuid);
    }

}