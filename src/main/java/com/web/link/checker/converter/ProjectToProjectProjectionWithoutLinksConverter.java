package com.web.link.checker.converter;

import com.web.link.checker.model.Project;
import com.web.link.checker.model.ProjectWithoutLinksProjection;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.web.link.checker.utils.ValidateUtils.notNull;

@Component
public class ProjectToProjectProjectionWithoutLinksConverter implements Converter<Project, ProjectWithoutLinksProjection> {

    @Override
    public ProjectWithoutLinksProjection convert(Project project) {
        notNull(project, "project");

        ProjectWithoutLinksProjection projectProjection = new ProjectWithoutLinksProjection();
        projectProjection.setName(project.getName());
        projectProjection.setUuid(project.getUuid());
        return projectProjection;
    }
}
