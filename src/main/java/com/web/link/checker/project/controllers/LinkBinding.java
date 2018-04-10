package com.web.link.checker.project.controllers;



public final class LinkBinding {
    public static final String BASE_PATH = "/projects/{projectUuid}/links/";
    public static final String SAVE = "save";
    public static final String REDIRECT_TO_SAVE = "redirect:/projects/{projectUuid}/links/save";
    public static final String REDIRECT_TO_LINKS = "redirect:/projects/{projectUuid}/links/";
    public static final String UPDATE = "{linkUuid}/update";
    public static final String REDIRECT_TO_UPDATE = "redirect:/projects/{projectUuid}/links/{linkUuid}/update";
    public static final String DELETE = "{linkUuid}/delete";
}
