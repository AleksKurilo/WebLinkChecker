package com.akproject.WebLinkChecker.service;

import com.akproject.WebLinkChecker.model.Project;
import com.akproject.WebLinkChecker.model.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService {

      @Autowired
      public ProjectRepository projectRepository;


    @Override
    public void addProject(Project project) {

        projectRepository.save(project);
    }

    @Override
    @Transactional
    public Iterable<Project> findAll() {
                return projectRepository.findAll();
    }
}