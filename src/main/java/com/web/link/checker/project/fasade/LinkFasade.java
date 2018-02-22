package com.web.link.checker.project.fasade;

import com.web.link.checker.project.model.Link;
import com.web.link.checker.project.model.LinkProjection;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.service.LinkService;
import com.web.link.checker.project.service.ProjectService;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LinkFasade {

    @NonNull
    private final LinkService linkService;

    @NonNull
    private final ProjectService projectService;

    @NonNull
    private final ConversionService conversionService;

    public List<LinkProjection> findAll() {
        List<Link> links = linkService.findAll();
        List<LinkProjection> linkProjections = links.stream()
                .map(link -> conversionService.convert(link, LinkProjection.class))
                .collect(Collectors.toList());
        return linkProjections;
    }

    public void insert(String projectUuid, LinkProjection linkProjection) {
        ValidateUtils.notNull(linkProjection, "linkProjection");

        Project project = projectService.findByUuid(projectUuid);
        linkProjection.setProjectId(project.getId());
        linkService.insert(linkProjection);
    }
}
