package com.web.link.checker.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LinkBinding {

    public static final String BASE_PATH = "/projects/{projectUuid}/links/";
    public static final String INSERT_PATH = "insert";
    public static final String UPDATE_PATH = "{uuid}/update";
    public static final String DELETE_PATH = "{uuid}/delete";
    public static final String REDIRECT_TO_INSERT_PATH = "redirect:/projects/{projectUuid}/links/insert";
    public static final String REDIRECT_TO_LINKS_PATH = "redirect:/projects/{projectUuid}/links/";
    public static final String REDIRECT_TO_UPDATE_PATH = "redirect:/projects/{projectUuid}/links/{uuid}/update";
}
