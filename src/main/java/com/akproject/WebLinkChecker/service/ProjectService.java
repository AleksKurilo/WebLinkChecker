package com.akproject.WebLinkChecker.service;

import com.akproject.WebLinkChecker.model.Project;

public interface ProjectService {

    public void addProject(Project project);

    Iterable <Project> findAll();
}
