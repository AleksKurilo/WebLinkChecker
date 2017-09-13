package com.web.link.checker.project.service;

import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectProjection;
import com.web.link.checker.project.model.ProjectUpdate;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.List;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectFacade {

    @NonNull
    private final ProjectService projectService;

    @NonNull
    private final ConversionService conversionService;

    public List<ProjectProjection> findAll() {
        List<Project> projects = projectService.findAll();
        List<ProjectProjection> projectProjections = projects.stream()
                .map(project -> conversionService.convert(project, ProjectProjection.class))
                .collect(Collectors.toList());
        return projectProjections;
    }

    public void insert(ProjectInsert projectInsert) {
        ValidateUtils.notNull(projectInsert, "projectInsert");

        projectService.insert(projectInsert);
    }

    public void update(String uuid, ProjectUpdate projectUpdate) {
        ValidateUtils.notBlank(uuid, "uuid");
        ValidateUtils.notNull(projectUpdate, "projectUpdate");

        projectService.update(uuid, projectUpdate);
    }

    public void delete(String uuid) {
        ValidateUtils.notBlank(uuid, "uuid");

        projectService.delete(uuid);
    }

}