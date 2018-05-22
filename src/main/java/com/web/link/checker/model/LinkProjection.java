package com.web.link.checker.model;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class LinkProjection {

    private String uuid;

    private String location;

    private String href;

    private boolean dofollow;

    private String anchor;

    private Timestamp created;

    private Timestamp modified;
}
