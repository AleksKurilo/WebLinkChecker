package com.web.link.checker.project.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LinkInsert {

    @NotEmpty
    private String location;

    @NotEmpty
    private String follow;

    private Boolean dofollow;

    @NotNull
    @Size(min = 1, max = 255)
    private String anchor;

    private Long projectId;
}
