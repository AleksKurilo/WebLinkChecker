package com.web.link.checker.exception;

import lombok.Getter;

public class DomainObjectNotFoundException extends RuntimeException {

    private final static String MESSAGE = "'%s' uuid '%s' doesn't exist.";

    @Getter
    private final String uuid;

    @Getter
    private final Class clazz;

    public DomainObjectNotFoundException(String uuid, Class clazz) {
        super(String.format(MESSAGE, clazz.getName(), uuid));
        this.uuid = uuid;
        this.clazz = clazz;
    }
}
