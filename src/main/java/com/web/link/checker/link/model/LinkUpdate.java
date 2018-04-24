package com.web.link.checker.link.model;

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

    private boolean dofollow;

    @NotNull
    @Size(min = 1, max = 1000)
    private String anchor;
}
