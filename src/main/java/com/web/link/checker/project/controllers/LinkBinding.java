package com.web.link.checker.project.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LinkBinding {
    public static final String BASE_PATH = "/projects/{projectUuid}/links/";
    public static final String SAVE = "save";
    public static final String UPDATE = "{linkUuid}/update";
    public static final String DELETE = "{linkUuid}/delete";
    public static final String REDIRECT = "redirect:";
}
