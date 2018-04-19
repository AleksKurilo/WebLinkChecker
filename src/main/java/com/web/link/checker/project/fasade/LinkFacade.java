package com.web.link.checker.project.fasade;

import com.web.link.checker.project.model.*;
import com.web.link.checker.project.service.LinkService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import static com.web.link.checker.project.utils.ValidateUtils.notBlank;
import static com.web.link.checker.project.utils.ValidateUtils.notNull;


@Component
@RequiredArgsConstructor
public class LinkFacade {

    @NonNull
    private final LinkService linkService;

    @NonNull
    private final ConversionService conversionService;

    public LinkProjection findByUuid(String uuid) {
        notBlank(uuid, "uuid");

        Link link = linkService.findByUuid(uuid);
        if (link == null) {
            throw new IllegalArgumentException(String.format("Link uuid '%s' doesn't exist.", uuid));
        }
         return conversionService.convert(link, LinkProjection.class);
    }

    public void insert(String projectUuid, LinkInsert linkInsert) {
        notNull(linkInsert, "linkInsert");
        notNull(projectUuid, "projectUuid");

        linkService.insert(projectUuid, linkInsert);
    }

    public void update(String projectUuid, String linkUuid, LinkUpdate linkUpdate) {
        notNull(linkUpdate, "linkUpdate");
        notBlank(projectUuid, "projectUuid");

        linkService.update(projectUuid, linkUuid, linkUpdate);
    }

    public void delete(String uuid) {
        notBlank(uuid, "uuid");

        linkService.delete(uuid);
    }
}