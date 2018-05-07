package com.web.link.checker.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;


@Data
public class ProjectProjectionWithLinks {

    private String name;

    private String uuid;

    private Timestamp created;

    private Timestamp modified;

    private List<LinkProjection> links;
}
