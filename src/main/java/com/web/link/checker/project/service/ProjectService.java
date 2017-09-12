package com.web.link.checker.project.service;

import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectUpdate;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.repository.ProjectRepository;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {

    @NonNull
    public final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Transactional
    public void insert(ProjectInsert projectInsert) {
        ValidateUtils.notNull(projectInsert, "projectInsert");

        Project project = new Project();
        String uuid = UUID.randomUUID().toString();
        project.setName(projectInsert.getName());
        project.setUuid(uuid);
        projectRepository.save(project);
    }

    @Transactional
    public void update(String uuid, ProjectUpdate projectUpdate) {
        ValidateUtils.notBlank(uuid, "uuid");
        ValidateUtils.notNull(projectUpdate, "projectUpdate");

        Project project = projectRepository.findOneByUuid(uuid);
        project.setName(projectUpdate.getName());
        projectRepository.save(project);
    }

    @Transactional
    public void delete(String uuid) {
        ValidateUtils.notBlank(uuid, "uuid");

        projectRepository.deleteByUuid(uuid);
    }

}