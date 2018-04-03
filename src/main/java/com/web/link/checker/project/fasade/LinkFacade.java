package com.web.link.checker.project.fasade;

import com.web.link.checker.project.model.*;
import com.web.link.checker.project.service.LinkService;
import com.web.link.checker.project.service.ProjectService;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class LinkFacade {

    @NonNull
    private final LinkService linkService;

    @NonNull
    private final ProjectService projectService;

    @NonNull
    private final ConversionService conversionService;

    public LinkProjection findByUuid(String uuid) {
        ValidateUtils.notBlank(uuid, "UUID_IS_BLANK");

        Link link = linkService.findByUuid(uuid);
        return conversionService.convert(link, LinkProjection.class);
    }

    public void insert(String projectUuid, LinkInsert linkInsert) {
        ValidateUtils.notNull(linkInsert, "LINK_INSERT_IS_NULL");

        Project project = projectService.findByUuid(projectUuid);
        linkInsert.setProjectId(project.getId());
        linkService.insert(linkInsert);
    }

    public void update(String projectUuid, String linkUuid, LinkUpdate linkUpdate) {
        ValidateUtils.notNull(linkUpdate, "LINK_UPDATE_IS_NULL");
        ValidateUtils.notBlank(projectUuid, "PROJECT_UUID_IS_BLANK");

        Project project = projectService.findByUuid(projectUuid);
        if (linkUpdate.getDofollow() == null) {
            linkUpdate.setDofollow(false);
        }
        linkUpdate.setProjectId(project.getId());
        linkService.update(linkUuid, linkUpdate);
    }

    public void delete(String uuid) {
        ValidateUtils.notNull(uuid, "UUID_IS_EMPTY");

        linkService.delete(uuid);
    }
}
