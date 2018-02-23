package com.web.link.checker.project.service;

import com.web.link.checker.project.model.Link;
import com.web.link.checker.project.model.LinkProjection;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.repository.LinkRepository;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinkService {

    @NonNull
    public final LinkRepository linkRepository;

    public List<Link> findAll() {
        return linkRepository.findAll();
    }

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
}
