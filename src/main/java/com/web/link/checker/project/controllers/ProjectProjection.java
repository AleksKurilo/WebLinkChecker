package com.web.link.checker.project.controllers;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProjectProjection {

    @NotNull
    private String name;
}
