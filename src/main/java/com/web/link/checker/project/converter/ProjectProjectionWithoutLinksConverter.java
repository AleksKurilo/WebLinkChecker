package com.web.link.checker.project.converter;

import com.web.link.checker.project.model.*;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class ProjectProjectionWithoutLinksConverter implements Converter<Project, ProjectWithoutLinksProjection> {

    @Override
    public ProjectWithoutLinksProjection convert(Project project) {
        ValidateUtils.notNull(project, "project");

        ProjectWithoutLinksProjection projectProjection = new ProjectWithoutLinksProjection();
        projectProjection.setName(project.getName());
        projectProjection.setUuid(project.getUuid());
        return projectProjection;
    }
}
