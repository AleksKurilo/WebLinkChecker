package com.web.link.checker.converter;

import com.web.link.checker.model.Link;
import com.web.link.checker.model.LinkProjection;
import com.web.link.checker.model.Project;
import com.web.link.checker.model.ProjectProjectionWithLinksProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.web.link.checker.utils.ValidateUtils.notNull;

@Component
class ProjectToProjectProjectionWithLinksProjectionConverter implements Converter<Project, ProjectProjectionWithLinksProjection> {

    @Lazy
    @Autowired
    private ConversionService conversionService;

    @Override
    public ProjectProjectionWithLinksProjection convert(Project project) {
        notNull(project, "project");

        ProjectProjectionWithLinksProjection projectProjection = new ProjectProjectionWithLinksProjection();
        projectProjection.setUuid(project.getUuid());
        projectProjection.setName(project.getName());
        projectProjection.setCreateOn(project.getEmbeddableData().getCreateOn());
        projectProjection.setLastUpdate(project.getEmbeddableData().getLastUpdate());

        Set<Link> links = project.getLinks();
        List<LinkProjection> linkProjections = links.stream()
                .map(link -> conversionService.convert(link, LinkProjection.class))
                .collect(Collectors.toList());
        projectProjection.setLinks(linkProjections);
        return projectProjection;
    }
}