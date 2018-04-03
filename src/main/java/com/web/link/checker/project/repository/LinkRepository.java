package com.web.link.checker.project.repository;

import com.web.link.checker.project.model.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends CrudRepository<Link, Long> {

    Link findByUuid(String uuid);

    void deleteByUuid(String uuid);
}
