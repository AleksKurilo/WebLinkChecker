package com.web.link.checker.project.Exception;

import lombok.Getter;

@SuppressWarnings("unchecked")
public class DomainObjectNotFoundException extends RuntimeException {

    private final static String MESSAGE = "'%s' uuid '%s' doesn't exist.";

    @Getter
    private String uuid;

    @Getter
    private Class clazz;

    public DomainObjectNotFoundException(String uuid, Class clazz) {
        super(String.format(MESSAGE, clazz.getName(), uuid));
        this.uuid = uuid;
        this.clazz = clazz;
    }
}
