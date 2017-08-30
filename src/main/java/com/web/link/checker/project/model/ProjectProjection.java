package com.web.link.checker.project.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProjectProjection {

    @NotNull
    private String name;

    private String uuid;
}
