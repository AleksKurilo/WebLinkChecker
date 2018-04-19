package com.web.link.checker.project.converter;

import com.web.link.checker.project.model.Link;
import com.web.link.checker.project.model.LinkProjection;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.model.ProjectWithLinksProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.web.link.checker.project.utils.ValidateUtils.notNull;

@Component
@RequiredArgsConstructor
class ProjectToProjectProjectionConverter implements Converter<Project, ProjectWithLinksProjection> {

    @Lazy
    @Autowired
    private ConversionService conversionService;

    @Override
    public ProjectWithLinksProjection convert(Project project) {
        notNull(project, "project");

        ProjectWithLinksProjection projectProjection = new ProjectWithLinksProjection();
        projectProjection.setUuid(project.getUuid());
        projectProjection.setName(project.getName());

        Set<Link> links = project.getLinks();
        List<LinkProjection> linkProjections = links.stream()
                .map(link -> conversionService.convert(link, LinkProjection.class))
                .collect(Collectors.toList());
        projectProjection.setLinks(linkProjections);
        return projectProjection;
    }
}