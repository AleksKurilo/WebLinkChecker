package com.web.link.checker.project.service;

import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectUpdate;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.repository.ProjectRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public  class ProjectService {

    @NonNull
    public final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public List<Project> findAll() {
       return projectRepository.findAll();
    }

    @Transactional
    public void insert(ProjectInsert projectInsert) {
        ValidateService.validateNotNull(projectInsert, "projectInsert");

        Project project = new Project();
        String uuid = UUID.randomUUID().toString();
        project.setName(projectInsert.getName());
        project.setUuid(uuid);
        projectRepository.save(project);
    }

    @Transactional
    public void update(String uuid, ProjectUpdate projectUpdate){
        ValidateService.validateNotBlank(uuid, "projectUpdate");
        ValidateService.validateNotEmpty(uuid, "projectUpdate");
        ValidateService.validateNotNull(projectUpdate, "projectUpdate");

        Project project = projectRepository.findOneByUuid(uuid);
        project.setName(projectUpdate.getName());
        projectRepository.save(project);
    }

    @Transactional
    public void delete(String uuid){
        ValidateService.validateNotBlank(uuid, "in delete method");

        projectRepository.deleteByUuid(uuid);
    }

}