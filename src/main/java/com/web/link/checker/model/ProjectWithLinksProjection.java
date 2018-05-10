package com.web.link.checker.model;

import lombok.Data;

import java.util.List;


@Data
public class ProjectWithLinksProjection {

    private String name;

    private String uuid;

    private long created;

    private long modified;

    private List<LinkProjection> links;
}
