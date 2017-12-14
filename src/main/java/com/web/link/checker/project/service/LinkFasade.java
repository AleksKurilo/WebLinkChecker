package com.web.link.checker.project.service;

import com.web.link.checker.project.model.Link;
import com.web.link.checker.project.model.LinkProjection;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LinkFasade {

    @NonNull
    private final LinkService linkService;

    @NonNull
    private final ConversionService conversionService;

    public List<LinkProjection> findAll() {
        List<Link> links = linkService.findAll();
        List<LinkProjection> linkProjections = links.stream()
                .map(link -> conversionService.convert(link, LinkProjection.class))
                .collect(Collectors.toList());
        return linkProjections;
    }
}
