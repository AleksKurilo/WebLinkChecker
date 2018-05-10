package com.web.link.checker.service;

import com.web.link.checker.exception.DomainObjectNotFoundException;
import com.web.link.checker.model.Link;
import com.web.link.checker.model.LinkInsert;
import com.web.link.checker.model.LinkUpdate;
import com.web.link.checker.model.Project;
import com.web.link.checker.repository.LinkRepository;
import com.web.link.checker.repository.ProjectRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.web.link.checker.utils.ValidateUtils.notBlank;
import static com.web.link.checker.utils.ValidateUtils.notNull;


@Service
@RequiredArgsConstructor
public class LinkService {

    @NonNull
    public final LinkRepository linkRepository;

    @NonNull
    public final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public Page<Link> findByProject(String projectUuid, Pageable pageable) {
        notBlank(projectUuid, "projectUuid");
        notNull(pageable, "pageable");

        Project project = projectRepository.findByUuid(projectUuid);
        if (project == null) {
            throw new DomainObjectNotFoundException(projectUuid, Project.class);
        }
        return linkRepository.findByProject(project, pageable);
    }

    @Transactional(readOnly = true)
    public Link findByUuid(String uuid) {
        notBlank(uuid, "uuid");

        return linkRepository.findByUuid(uuid);
    }

    @Transactional
    public void insert(String projectUuid, LinkInsert insert) {
        notBlank(projectUuid, "projectUuid");
        notNull(insert, "insert");

        Project project = projectRepository.findByUuid(projectUuid);
        if (project == null) {
            throw new DomainObjectNotFoundException(projectUuid, Project.class);
        }
        Link link = new Link();
        link.setAnchor(insert.getAnchor());
        link.setHref(insert.getHref());
        link.setLocation(insert.getLocation());
        link.setDofollow(insert.isDofollow());
        String uuid = UUID.randomUUID().toString();
        link.setUuid(uuid);
        link.setProject(project);
        linkRepository.save(link);
    }

    @Transactional
    public void update(String projectUuid, String uuid, LinkUpdate update) {
        notBlank(projectUuid, "projectUuid");
        notBlank(uuid, "uuid");
        notNull(update, "update");

        Project project = projectRepository.findByUuid(projectUuid);
        if (project == null) {
            throw new DomainObjectNotFoundException(projectUuid, Project.class);
        }
        Link link = linkRepository.findByUuid(uuid);
        if (link == null) {
            throw new DomainObjectNotFoundException(uuid, Link.class);
        }
        link.setAnchor(update.getAnchor());
        link.setHref(update.getHref());
        link.setLocation(update.getLocation());
        link.setDofollow(update.isDofollow());
        link.setProject(project);
        linkRepository.save(link);
    }

    @Transactional
    public void delete(String uuid) {
        notNull(uuid, "uuid");

        linkRepository.deleteByUuid(uuid);
    }
}
