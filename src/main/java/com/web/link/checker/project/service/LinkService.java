package com.web.link.checker.project.service;

import com.web.link.checker.project.model.Link;
import com.web.link.checker.project.model.LinkProjection;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.repository.LinkRepository;
import com.web.link.checker.project.repository.ProjectRepository;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class LinkService {

    @NonNull
    public final LinkRepository linkRepository;

    @NonNull
    public final ProjectRepository projectRepository;

    @Transactional
    public void insert(LinkProjection linkProjection) {
        ValidateUtils.notNull(linkProjection, "linkProjection");

        Link link = new Link();
        link.setAnchor(linkProjection.getAnchor());
        link.setDofollow(linkProjection.getDofollow());
        link.setFollow(linkProjection.getFollow());
        link.setLocation(linkProjection.getLocation());
        Project project = new Project();
        project.setId(linkProjection.getProjectId());
        link.setProject(project);
        linkRepository.save(link);
    }

    @Transactional
    public void update (LinkProjection linkProjection) {
        ValidateUtils.notNull(linkProjection, "linkProjection");

        Link existLink = linkRepository.findById(linkProjection.getId());
        existLink.setAnchor(linkProjection.getAnchor());
        existLink.setDofollow(linkProjection.getDofollow());
        existLink.setFollow(linkProjection.getFollow());
        existLink.setLocation(linkProjection.getLocation());
        Project project = new Project();
        project.setId(linkProjection.getProjectId());
        existLink.setProject(project);
        linkRepository.save(existLink);
    }

    @Transactional
    public void delete(Long id) {
        ValidateUtils.notNull(id, "id");

        linkRepository.delete(id);
    }
}
