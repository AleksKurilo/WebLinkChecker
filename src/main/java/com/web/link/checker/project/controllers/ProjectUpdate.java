package com.web.link.checker.project.controllers;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProjectUpdate {

    @NotNull
    @Size(min = 3, max = 255)
    private String name;
}