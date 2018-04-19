package com.web.link.checker.project.fasade;

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

    public <T> Page<T> findAllLinks(Pageable pageable, Class <T> projectClass) {
        notNull(pageable, "pageable");

        Page<Project> projectsPage = projectService.findAll(pageable);
        List<T> projectProjections = new ArrayList<>();
        for (Project project : projectsPage.getContent()) {
            T convert = conversionService.convert(project, projectClass);
             projectProjections.add(convert);
        }
        return new PageImpl(projectProjections, pageable, projectsPage.getTotalElements());
    }

    public <T> T findByUuid(String uuid,  Class <T> projectClass) {
        notNull(uuid, "uuid");

        Project project = projectService.findByUuid(uuid);
        if (project == null) {
            throw new IllegalArgumentException(String.format("Project uuid '%s' doesn't exist.", uuid));
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