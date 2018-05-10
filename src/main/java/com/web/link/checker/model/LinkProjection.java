package com.web.link.checker.model;

import lombok.Data;


@Data
public class LinkProjection {

    private String uuid;

    private String location;

    private String href;

    private boolean dofollow;

    private String anchor;

    private long createOn;

    private long lastUpdate;
}
