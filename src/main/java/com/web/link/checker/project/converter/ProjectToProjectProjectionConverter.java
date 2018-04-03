package com.web.link.checker.project.converter;

import com.web.link.checker.project.model.*;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectToProjectProjectionConverter implements Converter<Project, ProjectProjectionWithoutLinks> {

    @Override
    public ProjectProjectionWithoutLinks convert(Project project) {
        ValidateUtils.notNull(project, "project");

        ProjectProjectionWithoutLinks projectProjection = new ProjectProjectionWithoutLinks();
        projectProjection.setName(project.getName());
        projectProjection.setUuid(project.getUuid());
        return projectProjection;
    }
}
