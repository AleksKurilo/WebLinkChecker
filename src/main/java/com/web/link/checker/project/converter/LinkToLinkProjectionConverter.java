package com.web.link.checker.project.converter;

import com.web.link.checker.project.model.Link;
import com.web.link.checker.project.model.LinkProjection;
import com.web.link.checker.project.utils.ValidateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static com.web.link.checker.project.converter.ConverterHelper.combine2Objects;


@Component
@RequiredArgsConstructor
public class LinkToLinkProjectionConverter implements Converter<Link, LinkProjection> {

    @Override
    public LinkProjection convert(Link link) {
        ValidateUtils.notNull(link, "link");

        LinkProjection linkProjection = new LinkProjection();
        ConverterHelper.combine2Objects(link, linkProjection);
        linkProjection.setProjectUuid(link.getProject().getUuid());
        return linkProjection;
    }



}
