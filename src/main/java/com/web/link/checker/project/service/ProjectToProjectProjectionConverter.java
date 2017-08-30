package com.web.link.checker.project.service;

import com.web.link.checker.project.model.ProjectProjection;
import com.web.link.checker.project.model.Project;

import org.apache.commons.lang3.Validate;
import org.springframework.core.convert.converter.Converter;


public final class ProjectToProjectProjectionConverter implements Converter<Project, ProjectProjection> {


    @Override
    public ProjectProjection convert(Project project){
        Validate.notNull(project, "project is null in ProjectToProjectProjectionConverter.class");
        ProjectProjection projectProjection = new ProjectProjection();
        projectProjection.setName(project.getName());
        projectProjection.setUuid(project.getUuid());
        return projectProjection;
    }


}
