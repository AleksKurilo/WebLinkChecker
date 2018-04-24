package com.web.link.checker.link.facade;

import com.web.link.checker.link.model.Link;
import com.web.link.checker.link.model.LinkInsert;
import com.web.link.checker.link.model.LinkProjection;
import com.web.link.checker.link.model.LinkUpdate;
import com.web.link.checker.link.service.LinkService;
import com.web.link.checker.project.exception.DomainObjectNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import static com.web.link.checker.utils.ValidateUtils.notBlank;
import static com.web.link.checker.utils.ValidateUtils.notNull;


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
            throw new DomainObjectNotFoundException(uuid, Link.class);
        }
        return conversionService.convert(link, LinkProjection.class);
    }

    public void insert(String projectUuid, LinkInsert linkInsert) {
        notNull(projectUuid, "projectUuid");
        notNull(linkInsert, "linkInsert");

        linkService.insert(projectUuid, linkInsert);
    }

    public void update(String projectUuid, String uuid, LinkUpdate linkUpdate) {
        notBlank(projectUuid, "projectUuid");
        notBlank(uuid, "uuid");
        notNull(linkUpdate, "linkUpdate");

        linkService.update(projectUuid, uuid, linkUpdate);
    }

    public void delete(String uuid) {
        notBlank(uuid, "uuid");

        linkService.delete(uuid);
    }
}
