package com.web.link.checker.repository;

import com.web.link.checker.model.Link;
import com.web.link.checker.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends CrudRepository<Link, Long> {

    Page<Link> findByProject(Project project, Pageable pageable);

    Link findByUuid(String uuid);

    void deleteByUuid(String uuid);
}
