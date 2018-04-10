package com.web.link.checker.project.converter;

import com.web.link.checker.project.model.Link;
import com.web.link.checker.project.model.LinkProjection;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.model.ProjectProjection;
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
class ProjectToProjectProjectionConverter implements Converter<Project, ProjectProjection> {

    @Lazy
    @Autowired
    private ConversionService conversionService;

    @Override
    public ProjectProjection convert(Project project) {
        ValidateUtils.notNull(project, "project");

        ProjectProjection projectProjection = new ProjectProjection();
        projectProjection.setName(project.getName());
        projectProjection.setUuid(project.getUuid());

        Set<Link> links = project.getLinks();
        List<LinkProjection> linkProjections = links.stream()
                .map(link -> conversionService.convert(link, LinkProjection.class))
                .collect(Collectors.toList());
        projectProjection.setLinks(linkProjections);
        return projectProjection;
    }
}
