package com.web.link.checker.project.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProjectBinding {
    public static final String PROJECT_BASE_PATH = "/projects/";
    public static final String PROJECT_SAVE      = "save";
    public static final String PROJECT_UPDATE    = "{uuid}/update";
    public static final String PROJECT_DELETE    = "{uuid}/delete";
}
