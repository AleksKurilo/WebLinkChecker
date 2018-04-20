package com.web.link.checker.project.service;

import com.web.link.checker.project.Exception.DomainObjectNotFoundException;
import com.web.link.checker.project.model.*;
import com.web.link.checker.project.repository.LinkRepository;
import com.web.link.checker.project.repository.ProjectRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.web.link.checker.project.utils.ValidateUtils.notBlank;
import static com.web.link.checker.project.utils.ValidateUtils.notNull;


@Service
@RequiredArgsConstructor
public class LinkService {

    @NonNull
    public final LinkRepository linkRepository;

    @NonNull
    public final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public Link findByUuid(String uuid) {
        notBlank(uuid, "uuid");

        return linkRepository.findByUuid(uuid);
    }

    @Transactional
    public void insert(String projectUuid, LinkInsert linkInsert) throws DomainObjectNotFoundException {
        notNull(linkInsert, "linkInsert");

        Project project = projectRepository.findOneByUuid(projectUuid);
        if (project == null) {
            throw new DomainObjectNotFoundException(projectUuid, Project.class);
        }
        Link link = new Link();
        link.setAnchor(linkInsert.getAnchor());
        link.setHref(linkInsert.getHref());
        link.setLocation(linkInsert.getLocation());
        link.setDofollow(linkInsert.isDofollow());
        String uuid = UUID.randomUUID().toString().replace("-", "");
        link.setUuid(uuid);
        link.setProject(project);
        linkRepository.save(link);
    }

    @Transactional
    public void update(String projectUuid, String uuid, LinkUpdate linkUpdate) throws DomainObjectNotFoundException {
        notBlank(projectUuid, "projectUuid");
        notBlank(uuid, "uuid");
        notNull(linkUpdate, "linkUpdate");

        Project project = projectRepository.findOneByUuid(projectUuid);
        if (project == null) {
            throw new DomainObjectNotFoundException(projectUuid, Project.class);
        }
        Link link = linkRepository.findByUuid(uuid);
        if (link == null) {
            throw new DomainObjectNotFoundException(uuid, Link.class);
        }
        link.setAnchor(linkUpdate.getAnchor());
        link.setHref(linkUpdate.getHref());
        link.setLocation(linkUpdate.getLocation());
        link.setDofollow(linkUpdate.isDofollow());
        link.setProject(project);
        linkRepository.save(link);
    }

    @Transactional
    public void delete(String uuid) {
        notNull(uuid, "uuid");

        linkRepository.deleteByUuid(uuid);
    }
}
