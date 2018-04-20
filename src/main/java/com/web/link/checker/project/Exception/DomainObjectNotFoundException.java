package com.web.link.checker.project.Exception;

import lombok.Getter;


public class DomainObjectNotFoundException extends Exception {

    private final static String MASSAGE = "'%s' uuid '%s' doesn't exist.";

    @Getter
    private String uuid;

    public DomainObjectNotFoundException(String uuid, Class clazz) {
        super(String.format(MASSAGE, clazz.getName(), uuid));
        this.uuid = uuid;
    }
}
