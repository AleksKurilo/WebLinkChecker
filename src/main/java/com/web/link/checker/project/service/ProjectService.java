package com.web.link.checker.project.service;

import com.web.link.checker.project.controllers.ProjectInsert;
import com.web.link.checker.project.controllers.ProjectUpdate;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.repository.ProjectRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    @NonNull
    public ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Transactional
    public void save(ProjectInsert projectInsert) {
        Project project = new Project();
        project.setName(projectInsert.getName());
        projectRepository.save(project);
    }

    @Transactional
    public void update(Long id, ProjectUpdate projectUpdate){
        Project project = new Project();
        project.setId(id);
        project.setName(projectUpdate.getName());
        projectRepository.save(project);
    }

    @Transactional
    public void delete(Long id){
        projectRepository.delete(id);
    }


}