package com.web.link.checker.model;

import lombok.Data;

import java.util.List;


@Data
public class ProjectProjection {

    private String name;

    private String uuid;

    private List<LinkProjection> links;
}
