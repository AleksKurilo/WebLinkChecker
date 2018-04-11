package com.web.link.checker.project.service;

import com.web.link.checker.project.converter.ConverterHelper;
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
        ValidateUtils.notNull(uuid, "uuid");

        return linkRepository.findByUuid(uuid);
    }

    @Transactional
    public void insert(String projectUuid, LinkInsert linkInsert) {
        ValidateUtils.notNull(linkInsert, "linkInsert");

        Project projectExist = projectRepository.findOneByUuid(projectUuid);
        if (projectExist != null) {
            Link link = new Link();
            if (linkInsert.getDofollow() == null) {
                link.setDofollow(false);
            }
            ConverterHelper.combine2Objects(linkInsert, link);
            String uuid = UUID.randomUUID().toString();
            link.setUuid(uuid);
            link.setProject(projectExist);
            linkRepository.save(link);
        }
    }

    @Transactional
    public void update(String projectUuid, String uuid, LinkUpdate linkUpdate) {
        ValidateUtils.notNull(linkUpdate, "linkUpdate");

        Project projectExist = projectRepository.findOneByUuid(projectUuid);
        Link existLink = linkRepository.findByUuid(uuid);
        if (projectExist != null && existLink != null) {
            if (linkUpdate.getDofollow() == null) {
                existLink.setDofollow(false);
            }
            ConverterHelper.combine2Objects(linkUpdate, existLink);
            existLink.setProject(projectExist);
            linkRepository.save(existLink);
        }
    }

    @Transactional
    public void delete(String uuid) {
        ValidateUtils.notNull(uuid, "uuid");

        linkRepository.deleteByUuid(uuid);
    }
}
