package com.web.link.checker.project.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProjectBinding {
    public static final String BASE_PATH    = "/projects/";
    public static final String SAVE         = "save";
    public static final String UPDATE       = "{id}/update";
    public static final String DELETE       = "{id}/delete";
}
