package com.web.link.checker.controller;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public final class LinkBinding {

    public static final String BASE_PATH = "/projects/{projectUuid}/links/";
    public static final String INSERT_PATH = "insert";
    public static final String UPDATE_PATH = "{uuid}/update";
    public static final String DELETE_PATH = "{uuid}/delete";
    public static final String REDIRECT_TO_INSERT_PATH = "redirect:/projects/{projectUuid}/links/insert";
    public static final String REDIRECT_TO_LINKS_PATH = "redirect:/projects/{projectUuid}/links/";
    public static final String REDIRECT_TO_UPDATE_PATH = "redirect:/projects/{projectUuid}/links/{uuid}/update";

    public static final String LINKS_VIEW = "/links/list";
    public static final String INSERT_VIEW = "/links/insert";
    public static final String UPDATE_VIEW = "/links/update";
}
