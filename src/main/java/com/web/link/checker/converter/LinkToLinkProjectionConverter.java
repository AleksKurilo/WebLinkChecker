package com.web.link.checker.converter;

import com.web.link.checker.model.Link;
import com.web.link.checker.model.LinkProjection;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.web.link.checker.utils.ValidateUtils.notNull;

@Component
public class LinkToLinkProjectionConverter implements Converter<Link, LinkProjection> {

    @Override
    public LinkProjection convert(Link link) {
        notNull(link, "link");

        LinkProjection linkProjection = new LinkProjection();
        linkProjection.setAnchor(link.getAnchor());
        linkProjection.setHref(link.getHref());
        linkProjection.setLocation(link.getLocation());
        linkProjection.setDofollow(link.isDofollow());
        linkProjection.setUuid(link.getUuid());
        linkProjection.setCreateOn(link.getAudit().getCreated());
        linkProjection.setLastUpdate(link.getAudit().getModified());
        return linkProjection;
    }
}
