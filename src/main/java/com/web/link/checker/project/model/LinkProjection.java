package com.web.link.checker.project.model;

import lombok.Data;

@Data
public class LinkProjection {

    private Long id;
    private String location;
    private String follow;
    private Boolean dofollow;
    private String anchor;

}
