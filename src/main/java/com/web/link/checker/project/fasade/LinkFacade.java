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
        ValidateUtils.notBlank(uuid, "uuid");

        Link link = linkService.findByUuid(uuid);
        return conversionService.convert(link, LinkProjection.class);
    }

    public void insert(String projectUuid, LinkInsert linkInsert) {
        ValidateUtils.notNull(linkInsert, "linkInsert");
        ValidateUtils.notNull(projectUuid, "projectUuid");

        linkService.insert(projectUuid, linkInsert);
    }

    public void update(String projectUuid, String linkUuid, LinkUpdate linkUpdate) {
        ValidateUtils.notNull(linkUpdate, "linkUpdate");
        ValidateUtils.notBlank(projectUuid, "projectUuid");

        linkService.update(projectUuid, linkUuid, linkUpdate);
    }

    public void delete(String uuid) {
        ValidateUtils.notNull(uuid, "uuid");

        linkService.delete(uuid);
    }
}
