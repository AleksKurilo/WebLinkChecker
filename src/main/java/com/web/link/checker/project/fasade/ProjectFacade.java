package com.web.link.checker.project.fasade;

import com.web.link.checker.project.Exception.DomainObjectNotFoundException;
import com.web.link.checker.project.model.*;
import com.web.link.checker.project.service.ProjectService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import static com.web.link.checker.project.utils.ValidateUtils.notBlank;
import static com.web.link.checker.project.utils.ValidateUtils.notNull;


@Component
@RequiredArgsConstructor
public class ProjectFacade {

    @NonNull
    private final ProjectService projectService;

    @NonNull
    private final ConversionService conversionService;

    public <T> Page<T> findAll(Class <T> projectClass, Pageable pageable) {
        notNull(pageable, "pageable");
        notNull(projectClass, "projectClass");

        Page<Project> projectPage = projectService.findAll(pageable);
        List<T> projectProjections = new ArrayList<>();
        for (Project project : projectPage.getContent()) {
            T convert = conversionService.convert(project, projectClass);
             projectProjections.add(convert);
        }
        return new PageImpl(projectProjections, pageable, projectPage.getTotalElements());
    }

    public <T> T findByUuid(String uuid,  Class <T> projectClass) throws DomainObjectNotFoundException {
        notNull(uuid, "uuid");
        notNull(projectClass, "projectClass");

        Project project = projectService.findByUuid(uuid);
        if (project == null) {
            throw new DomainObjectNotFoundException(uuid, Project.class);
        }
        return conversionService.convert(project, projectClass);
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