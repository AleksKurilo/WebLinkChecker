package com.web.link.checker.project.model;

import lombok.Data;


@Data
public class LinkProjection {

    private String uuid;

    private String location;

    private String follow;

    private boolean dofollow;

    private String anchor;

    private Long projectId;

}
