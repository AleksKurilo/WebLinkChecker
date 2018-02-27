package com.web.link.checker.project.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LinkBinding {
    public static final String LINK_BASE_PATH = "/links/";
    public static final String GET_PROJECT_LINKS = "project/{projectUuid}";
    public static final String LINK_SAVE = "project/{projectUuid}/save";
    public static final String LINK_UPDATE = "project/{projectUuid}/link/{linkId}";
    public static final String LINK_DELETE = "link/{linkId}/delete";
}
