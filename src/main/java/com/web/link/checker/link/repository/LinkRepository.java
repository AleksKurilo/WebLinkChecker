package com.web.link.checker.link.repository;

import com.web.link.checker.link.model.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends CrudRepository<Link, Long> {

    Link findByUuid(String uuid);

    void deleteByUuid(String uuid);
}
