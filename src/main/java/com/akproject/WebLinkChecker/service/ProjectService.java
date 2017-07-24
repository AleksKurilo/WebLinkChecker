package com.akproject.WebLinkChecker.service;

import com.akproject.WebLinkChecker.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    public void addProject(Project project);

    List<Project> findAll();
}
