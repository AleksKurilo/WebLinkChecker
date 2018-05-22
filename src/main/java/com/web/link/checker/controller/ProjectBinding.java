package com.web.link.checker.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProjectBinding {

    public static final String BASE_PATH = "/projects/";
    public static final String INSERT_PATH = "insert";
    public static final String UPDATE_PATH = "{uuid}/update";
    public static final String DELETE_PATH = "{uuid}/delete";
    public static final String REDIRECT_PROJECT_PATH = "redirect:/projects/";
    public static final String REDIRECT_TO_INSERT_PATH = "redirect:/projects/insert";
    public static final String REDIRECT_TO_UPDATE_PATH = "redirect:/projects/{uuid}/update";
}
