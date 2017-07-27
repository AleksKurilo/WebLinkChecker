package com.akproject.WebLinkChecker.service;

import com.akproject.WebLinkChecker.model.Project;
import com.akproject.WebLinkChecker.model.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {

    @Autowired
    public ProjectRepository projectRepository;

    public void saveProject(Project project) {

        projectRepository.save(project);
    }

    @Transactional(readOnly = true)
    public Iterable<Project> findAll() {
                return projectRepository.findAll();
    }
}