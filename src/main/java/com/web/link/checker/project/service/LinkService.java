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

import static com.web.link.checker.project.utils.ValidateUtils.notNull;


@Service
@RequiredArgsConstructor
public class LinkService {

    private static final String INFO_PROJECT_DOES_NOT_EXIST = "Project uuid '%s' doesn't exist.";
    private static final String INFO_LINK_DOES_NOT_EXIST = "Link uuid '%s' doesn't exist.";

    @NonNull
    public final LinkRepository linkRepository;

    @NonNull
    public final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public Link findByUuid(String uuid) {
        notNull(uuid, "uuid");

        return linkRepository.findByUuid(uuid);
    }

    @Transactional
    public void insert(String projectUuid, LinkInsert linkInsert) {
        notNull(linkInsert, "linkInsert");

        Project existProject = projectRepository.findOneByUuid(projectUuid);
        if (existProject == null) {
            throw new IllegalArgumentException(INFO_PROJECT_DOES_NOT_EXIST);
        }
        Link link = new Link();
        link.setAnchor(linkInsert.getAnchor());
        link.setHref(linkInsert.getHref());
        link.setLocation(linkInsert.getLocation());
        link.setDofollow(linkInsert.isDofollow());
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        link.setUuid(uuid);
        link.setProject(existProject);
        linkRepository.save(link);
    }

    @Transactional
    public void update(String projectUuid, String uuid, LinkUpdate linkUpdate) {
        notNull(linkUpdate, "linkUpdate");

        Project existProject = projectRepository.findOneByUuid(projectUuid);
        if (existProject == null) {
            throw new IllegalArgumentException(INFO_PROJECT_DOES_NOT_EXIST);
        }
        Link existLink = linkRepository.findByUuid(uuid);
        if (existLink == null) {
            throw new IllegalArgumentException(INFO_LINK_DOES_NOT_EXIST);
        }
        existLink.setAnchor(linkUpdate.getAnchor());
        existLink.setHref(linkUpdate.getHref());
        existLink.setLocation(linkUpdate.getLocation());
        existLink.setDofollow(linkUpdate.isDofollow());
        existLink.setProject(existProject);
        linkRepository.save(existLink);
    }

    @Transactional
    public void delete(String uuid) {
        notNull(uuid, "uuid");

        linkRepository.deleteByUuid(uuid);
    }
}
