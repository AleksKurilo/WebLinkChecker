package com.web.link.checker.project.service;

import com.web.link.checker.project.model.ProjectProjection;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.utils.ValidateUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProjectToProjectProjectionConverter implements Converter<Project, ProjectProjection> {

    @Override
    public ProjectProjection convert(Project project) {
        ValidateUtils.notNull(project, "project");

        ProjectProjection projectProjection = new ProjectProjection();
        projectProjection.setName(project.getName());
        projectProjection.setUuid(project.getUuid());
        return projectProjection;
    }

}
