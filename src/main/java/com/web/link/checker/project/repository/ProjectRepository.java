package com.web.link.checker.project.repository;

import com.web.link.checker.project.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Page<Project> findAll(Pageable pageable);

    Project findOneByUuid(String uuid);

    void deleteByUuid(String uuid);
}
