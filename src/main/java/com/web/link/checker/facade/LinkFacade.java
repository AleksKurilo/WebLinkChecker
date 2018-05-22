package com.web.link.checker.facade;

import com.web.link.checker.exception.DomainObjectNotFoundException;
import com.web.link.checker.model.Link;
import com.web.link.checker.model.LinkInsert;
import com.web.link.checker.model.LinkProjection;
import com.web.link.checker.model.LinkUpdate;
import com.web.link.checker.service.LinkService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<LinkProjection> findByProject(String projectUuid, Pageable pageable) {
        notBlank(projectUuid, "projectUuid");
        notNull(pageable, "pageable");
        Page<Link> page = linkService.findByProject(projectUuid, pageable);
        return page.map(link -> conversionService.convert(link, LinkProjection.class));
    }

    public LinkProjection findByUuid(String uuid) {
        notBlank(uuid, "uuid");

        Link link = linkService.findByUuid(uuid);
        if (link == null) {
            throw new DomainObjectNotFoundException(uuid, Link.class);
        }
        return conversionService.convert(link, LinkProjection.class);
    }

    public void insert(String projectUuid, LinkInsert insert) {
        notNull(projectUuid, "projectUuid");
        notNull(insert, "insert");

        linkService.insert(projectUuid, insert);
    }

    public void update(String projectUuid, String uuid, LinkUpdate update) {
        notBlank(projectUuid, "projectUuid");
        notBlank(uuid, "uuid");
        notNull(update, "update");

        linkService.update(projectUuid, uuid, update);
    }

    public void delete(String uuid) {
        notBlank(uuid, "uuid");

        linkService.delete(uuid);
    }
}
