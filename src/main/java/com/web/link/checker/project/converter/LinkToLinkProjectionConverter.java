package com.web.link.checker.project.converter;

import com.web.link.checker.project.model.Link;
import com.web.link.checker.project.model.LinkProjection;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LinkToLinkProjectionConverter implements Converter<Link, LinkProjection> {

    @Override
    public LinkProjection convert(Link link) {
        ValidateUtils.notNull(link, "link");

        LinkProjection linkProjection = new LinkProjection();
        linkProjection.setAnchor(link.getAnchor());
        linkProjection.setHref(link.getHref());
        linkProjection.setLocation(link.getLocation());
        linkProjection.setDofollow(link.isDofollow());
        linkProjection.setUuid(link.getUuid());
        return linkProjection;
    }



}