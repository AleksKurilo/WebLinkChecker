package com.web.link.checker.service;

import com.web.link.checker.exception.DomainObjectNotFoundException;
import com.web.link.checker.model.Project;
import com.web.link.checker.model.ProjectInsert;
import com.web.link.checker.model.ProjectUpdate;
import com.web.link.checker.repository.ProjectRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.web.link.checker.utils.ValidateUtils.notBlank;
import static com.web.link.checker.utils.ValidateUtils.notNull;

@Service
@RequiredArgsConstructor
public class ProjectService {

    public final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public Page<Project> findAll(Pageable pageable) {
        notNull(pageable, "pageable");

        return projectRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Project findByUuid(String uuid) {
        notBlank(uuid, "uuid");

        return projectRepository.findByUuid(uuid);
    }

    @Transactional
    public void insert(ProjectInsert projectInsert) {
        notNull(projectInsert, "projectInsert");

        Project project = new Project();
        String uuid = UUID.randomUUID().toString();
        project.setName(projectInsert.getName());
        project.setUuid(uuid);
        projectRepository.save(project);
    }

    @Transactional
    public void update(String uuid, ProjectUpdate projectUpdate) {
        notBlank(uuid, "uuid");
        notNull(projectUpdate, "projectUpdate");

        Project project = projectRepository.findByUuid(uuid);
        if (project == null) {
            throw new DomainObjectNotFoundException(uuid, Project.class);
        }
        project.setName(projectUpdate.getName());
        projectRepository.save(project);
    }

    @Transactional
    public void delete(String uuid) {
        notBlank(uuid, "uuid");

        projectRepository.deleteByUuid(uuid);
    }
}