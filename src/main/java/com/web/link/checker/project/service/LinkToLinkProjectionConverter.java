package com.web.link.checker.project.service;

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
        ValidateUtils.notNull(link, "LINK_IS_NULL");

        LinkProjection linkProjection = new LinkProjection();
        linkProjection.setId(link.getId());
        linkProjection.setAnchor(link.getAnchor());
        linkProjection.setFollow(link.getFollow());
        linkProjection.setDofollow(link.getDofollow());

        return linkProjection;
    }
}
