package com.web.link.checker.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProjectProjection {

    private String name;

    private String uuid;

    private Timestamp created;

    private Timestamp modified;
}
