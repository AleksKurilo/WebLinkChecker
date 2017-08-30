package com.web.link.checker.project.service;

import com.web.link.checker.project.model.ProjectInsert;
import com.web.link.checker.project.model.ProjectProjection;
import com.web.link.checker.project.model.ProjectUpdate;
import com.web.link.checker.project.model.Project;
import lombok.Data;
import lombok.NonNull;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@Service
public class ProjectFacade {

    @NonNull
    private final ProjectService projectService;

    @NonNull
    private ConversionService conversionService;

    public List<ProjectProjection>  findAll(){
        List<Project> projects = projectService.findAll();
        List<ProjectProjection> projectProjections = new ArrayList<ProjectProjection>();
        Iterator<Project> iteratorProject = projects.iterator();
        while(iteratorProject.hasNext()) {
            Project project = iteratorProject.next();
            ProjectProjection projectProjection = conversionService.convert(project, ProjectProjection.class);
            projectProjections.add(projectProjection);
        }
        return projectProjections;
    }

    public void insert(ProjectInsert projectInsert){
        projectService.insert(projectInsert);
    }

    public void update(String uuid, ProjectUpdate projectUpdate){
        projectService.update(uuid, projectUpdate);
    }

    public void delete(String uuid){
        projectService.delete(uuid);
    }

}
