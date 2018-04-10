package com.web.link.checker.project.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LinkUpdate {

    @NotEmpty
    private String location;

    @NotEmpty
    private String href;

    private Boolean dofollow;

    @NotNull
    @Size(min = 1, max = 1000)
    private String anchor;

    private String uuid;
}
