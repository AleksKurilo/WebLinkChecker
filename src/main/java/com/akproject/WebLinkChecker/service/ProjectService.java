package com.akproject.WebLinkChecker.service;

import com.akproject.WebLinkChecker.model.Project;
import com.akproject.WebLinkChecker.model.ProjectRepository;
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

    @Transactional
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Transactional
    public void delete(Long id){
        projectRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}