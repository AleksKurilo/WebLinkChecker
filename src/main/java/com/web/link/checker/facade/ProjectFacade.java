package com.web.link.checker.facade;

import com.web.link.checker.exception.DomainObjectNotFoundException;
import com.web.link.checker.model.Project;
import com.web.link.checker.model.ProjectInsert;
import com.web.link.checker.model.ProjectUpdate;
import com.web.link.checker.service.ProjectService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import static com.web.link.checker.utils.ValidateUtils.notBlank;
import static com.web.link.checker.utils.ValidateUtils.notNull;


@Component
@RequiredArgsConstructor
public class ProjectFacade {

    @NonNull
    private final ProjectService projectService;

    @NonNull
    private final ConversionService conversionService;

    public <T> Page<T> findAll(Class<T> projectionClass, Pageable pageable) {
        notNull(projectionClass, "projectClass");
        notNull(pageable, "pageable");

        Page<Project> projectPage = projectService.findAll(pageable);
        return projectPage.map(project -> conversionService.convert(project, projectionClass));
    }

    public <T> T findByUuid(String uuid, Class<T> projectionClass) {
        notNull(uuid, "uuid");
        notNull(projectionClass, "projectClass");

        Project project = projectService.findByUuid(uuid);
        if (project == null) {
            throw new DomainObjectNotFoundException(uuid, Project.class);
        }
        return conversionService.convert(project, projectionClass);
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