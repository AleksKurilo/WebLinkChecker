package com.web.link.checker.converter;

import com.web.link.checker.model.Project;
import com.web.link.checker.model.ProjectProjection;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.web.link.checker.utils.ValidateUtils.notNull;

@Component
public class ProjectToProjectProjectionConverter implements Converter<Project, ProjectProjection> {

    @Override
    public ProjectProjection convert(Project project) {
        notNull(project, "project");

        ProjectProjection projectProjection = new ProjectProjection();
        projectProjection.setName(project.getName());
        projectProjection.setUuid(project.getUuid());
        projectProjection.setCreateOn(project.getEmbeddableData().getCreateOn());
        projectProjection.setLastUpdate(project.getEmbeddableData().getLastUpdate());
        return projectProjection;
    }
}
