package com.web.link.checker.project.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LinkProjection {

    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String location;

    @NotNull
    @Size(min = 3, max = 255)
    private String follow;

    private Boolean dofollow;

    @NotEmpty
    private String anchor;

    private Long projectId;

}
