package com.web.link.checker.project.model;

import lombok.Data;

import java.util.List;


@Data
public class ProjectWithLinksProjection {

    private String name;

    private String uuid;

    private List<LinkProjection> links;
}
