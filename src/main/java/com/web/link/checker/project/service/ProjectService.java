package com.web.link.checker.project.service;

import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectUpdate;
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
        List<Project> projects =  projectRepository.findAll();
        Validate.notNull(projects, "List<Project> projects is null in ProjectService.class");
        return projects;
    }

    @Transactional
    public void insert(ProjectInsert projectInsert) {
        Validate.notNull(projectInsert, "projectInsert is null in ProjectService.class");
        Project project = new Project();
        project.setName(projectInsert.getName());
        projectRepository.save(project);
    }

    @Transactional
    public void update(String uuid, ProjectUpdate projectUpdate){
        Validate.notNull(uuid, "uuid is null in ProjectService.class");
        Validate.notNull(projectUpdate, "projectUpdate is null in ProjectService.class");
        Project project = projectRepository.findByUuid(uuid);
        project.setName(projectUpdate.getName());
        projectRepository.save(project);
    }

    @Transactional
    public void delete(String uuid){
        Project project = projectRepository.findByUuid(uuid);
        Validate.notNull(project, "project is null in ProjectService.class");
        Long id = project.getId();
        projectRepository.delete(id);
    }

}