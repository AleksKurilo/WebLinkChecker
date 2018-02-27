package com.web.link.checker.project.fasade;

import com.web.link.checker.project.model.LinkProjection;
import com.web.link.checker.project.model.Project;
import com.web.link.checker.project.service.LinkService;
import com.web.link.checker.project.service.ProjectService;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class LinkFasade {

    @NonNull
    private final LinkService linkService;

    @NonNull
    private final ProjectService projectService;

    public void insert(String projectUuid, LinkProjection linkProjection) {
        ValidateUtils.notNull(linkProjection, "linkProjection");

        Project project = projectService.findByUuid(projectUuid);
        linkProjection.setProjectId(project.getId());
        linkService.insert(linkProjection);
    }

    public void update (String projectUuid, LinkProjection linkProjection){
        Project project = projectService.findByUuid(projectUuid);
        linkProjection.setProjectId(project.getId());
        linkService.update(linkProjection);
    }

    public void delete(Long id) {
        ValidateUtils.notNull(id, "id");

        linkService.delete(id);
    }
}
