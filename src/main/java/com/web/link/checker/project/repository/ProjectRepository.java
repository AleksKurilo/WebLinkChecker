package com.web.link.checker.project.repository;

import com.web.link.checker.project.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Page<Project> findAll(Pageable pageable);

    Project findOneByUuid(String uuid);

    void deleteByUuid(String uuid);
}
