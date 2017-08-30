package com.web.link.checker.project.service;

import com.web.link.checker.project.model.ProjectProjection;
import com.web.link.checker.project.model.Project;

import org.springframework.core.convert.converter.Converter;


public final class ProjectToProjectProjection implements Converter<Project, ProjectProjection> {


    @Override
    public ProjectProjection convert(Project project){
        ProjectProjection projectProjection = new ProjectProjection();
        projectProjection.setName(project.getName());
        projectProjection.setUuid(project.getUuid());
        return projectProjection;
    }


}
