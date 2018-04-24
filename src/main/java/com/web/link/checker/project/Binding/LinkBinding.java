package com.web.link.checker.project.Binding;



public final class LinkBinding {
    public static final String BASE_PATH = "/projects/{projectUuid}/links/";
    public static final String SAVE_PATH = "save";
    public static final String REDIRECT_TO_SAVE_PATH = "redirect:/projects/{projectUuid}/links/save";
    public static final String REDIRECT_TO_LINKS_PATH = "redirect:/projects/{projectUuid}/links/";
    public static final String UPDATE_PATH = "{linkUuid}/update";
    public static final String REDIRECT_TO_UPDATE_PATH = "redirect:/projects/{projectUuid}/links/{linkUuid}/update";
    public static final String DELETE_PATH = "{linkUuid}/delete";

    public static final String LINKS_VIEW = "links";
    public static final String LINK_SAVE_VIEW = "linkSave";
    public static final String LINK_UPDATE_VIEW = "linkUpdate";
}
