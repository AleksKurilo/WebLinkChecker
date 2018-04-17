package com.web.link.checker.project.fasade;

import com.web.link.checker.project.model.*;
import com.web.link.checker.project.service.ProjectService;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.web.link.checker.project.utils.ValidateUtils.notBlank;
import static com.web.link.checker.project.utils.ValidateUtils.notNull;


@Component
@RequiredArgsConstructor
public class ProjectFacade {

    @NonNull
    private final ProjectService projectService;

    @NonNull
    private final ConversionService conversionService;

    public Page<ProjectWithoutLinksProjection> findAllWithoutLinks(Pageable pageable) {
        notNull(pageable, "pageable");

        Page<Project> projectsPage = projectService.findAll(pageable);
        List<ProjectWithoutLinksProjection> projectProjections = projectsPage.getContent().stream()
                .map(project -> conversionService.convert(project, ProjectWithoutLinksProjection.class))
                .collect(Collectors.toList());
        return new PageImpl(projectProjections, pageable, projectsPage.getTotalElements());
    }

    public ProjectWithLinksProjection getByUuid(String uuid) {
        notNull(uuid, "uuid");

        Project project = projectService.findByUuid(uuid);
        return conversionService.convert(project, ProjectWithLinksProjection.class);
    }

    public void insert(ProjectInsert projectInsert) {
        notNull(projectInsert, "projectInsert");

        projectService.insert(projectInsert);
    }

    public void update(String uuid, ProjectUpdate projectUpdate) {
        notBlank(uuid, "uuid");
        notNull(projectUpdate, "projectUpdate");

        projectService.update(uuid, projectUpdate);
    }

    public void delete(String uuid) {
        notBlank(uuid, "uuid");

        projectService.delete(uuid);
    }

}