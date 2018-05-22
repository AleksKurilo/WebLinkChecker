package com.web.link.checker.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class LinkUpdate {

    @NotEmpty
    private String location;

    @NotEmpty
    private String href;

    private boolean dofollow;

    @NotEmpty
    private String anchor;
}
