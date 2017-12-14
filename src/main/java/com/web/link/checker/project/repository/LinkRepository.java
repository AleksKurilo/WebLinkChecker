package com.web.link.checker.project.repository;

import com.web.link.checker.project.model.Link;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LinkRepository extends CrudRepository<Link, Long> {

    List<Link> findAll();

    Link findById(String id);

    void deleteById(Long id);
}
