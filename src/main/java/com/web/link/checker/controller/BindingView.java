package com.web.link.checker.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BindingView {

    public static final String PROJECTS_VIEW = "/projects/list";
    public static final String PROJECT_INSERT_VIEW = "/projects/insert";
    public static final String PROJECT_UPDATE_VIEW = "/projects/update";

    public static final String LINKS_VIEW = "/links/list";
    public static final String LINK_INSERT_VIEW = "/links/insert";
    public static final String LINK_UPDATE_VIEW = "/links/update";
}
