package com.web.link.checker.project.service;

import com.web.link.checker.project.model.*;
import com.web.link.checker.project.repository.LinkRepository;
import com.web.link.checker.project.repository.ProjectRepository;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class LinkService {

    @NonNull
    public final LinkRepository linkRepository;

    @NonNull
    public final ProjectRepository projectRepository;

    @Transactional
    public Link findByUuid(String uuid) {
        return linkRepository.findByUuid(uuid);
    }

    @Transactional
    public void insert(LinkInsert linkInsert) {
        ValidateUtils.notNull(linkInsert, "LINK_PROJECTION_IS_NULL");

        Link link = new Link();
        link.setAnchor(linkInsert.getAnchor());
        link.setDofollow(linkInsert.getDofollow());
        link.setFollow(linkInsert.getFollow());
        link.setLocation(linkInsert.getLocation());
        String uuid = UUID.randomUUID().toString();
        link.setUuid(uuid);
        Project project = new Project();
        project.setId(linkInsert.getProjectId());
        link.setProject(project);
        linkRepository.save(link);
    }

    @Transactional
    public void update(String uuid, LinkUpdate linkUpdate) {
        ValidateUtils.notNull(linkUpdate, "LINK_PROJECTION_IS_NULL");

        Link existLink = linkRepository.findByUuid(uuid);
        existLink.setAnchor(linkUpdate.getAnchor());
        existLink.setDofollow(linkUpdate.getDofollow());
        existLink.setFollow(linkUpdate.getFollow());
        existLink.setLocation(linkUpdate.getLocation());
        Project project = new Project();
        project.setId(linkUpdate.getProjectId());
        existLink.setProject(project);
        linkRepository.save(existLink);
    }

    @Transactional
    public void delete(String uuid) {
        ValidateUtils.notNull(uuid, "UUID_IS_EMPTY");

        linkRepository.deleteByUuid(uuid);
    }
}
