package com.web.link.checker.project.repository;

import com.web.link.checker.project.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findByName(String name);

    Project findByUuid(String uuid);

    List<Project> findAll();

}
