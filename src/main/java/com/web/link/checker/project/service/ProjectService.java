package com.web.link.checker.project.service;

import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectUpdate;
import com.web.link.checker.project.repository.ProjectRepository;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.web.link.checker.project.utils.ValidateUtils.notBlank;
import static com.web.link.checker.project.utils.ValidateUtils.notNull;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private static final String INFO_PROJECT_DOES_NOT_EXIST = "Project uuid '%s' doesn't exist.";

    @NonNull
    public final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public Page<Project> findAll(Pageable pageable) {
        notNull(pageable, "pageable");

        return projectRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Project findByUuid(String uuid) {
        notBlank(uuid, "uuid");

        return projectRepository.findOneByUuid(uuid);
    }

    @Transactional
    public void insert(ProjectInsert projectInsert) {
        notNull(projectInsert, "projectInsert");

        Project project = new Project();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        project.setName(projectInsert.getName());
        project.setUuid(uuid);
        projectRepository.save(project);
    }

    @Transactional
    public void update(String uuid, ProjectUpdate projectUpdate) {
        notBlank(uuid, "uuid");
        notNull(projectUpdate, "projectUpdate");

        Project project = projectRepository.findOneByUuid(uuid);
        if (project == null) {
            throw new IllegalArgumentException(INFO_PROJECT_DOES_NOT_EXIST);
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