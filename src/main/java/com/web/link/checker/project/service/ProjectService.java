package com.web.link.checker.project.service;

import com.web.link.checker.project.controllers.ProjectInsert;
import com.web.link.checker.project.controllers.ProjectUpdate;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.repository.ProjectRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Validate.notNull(projectInsert, "ProjectInsert is null");
        Project project = new Project();
        project.setName(projectInsert.getName());
        projectRepository.save(project);
    }

    @Transactional
    public void update(Long id, ProjectUpdate projectUpdate){
        Validate.notNull(projectUpdate, "ProjectUpdate is null");
        Project project = projectRepository.findOne(id);
        project.setName(projectUpdate.getName());
        projectRepository.save(project);
    }

    @Transactional
    public void delete(String uuid){
        Project project = projectRepository.findByUuid(uuid);
        Long id = project.getId();
        projectRepository.delete(id);
    }


}