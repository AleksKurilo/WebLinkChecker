package com.web.link.checker.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


@Data
public class ProjectProjectionWithLinksProjection {

    private String name;

    private String uuid;

    private Timestamp createOn;

    private List<LinkProjection> links;
}
