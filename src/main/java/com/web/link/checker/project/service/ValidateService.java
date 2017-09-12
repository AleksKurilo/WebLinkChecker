package com.web.link.checker.project.service;

import org.apache.commons.lang3.Validate;


public class ValidateService {

    static void validateNotNull(Object object, String objectName) {
        Validate.notNull(object, String.format("Object %s cannot be null", objectName));
    }

    static void validateNotEmpty(String uuid, String objectName) {
        Validate.notEmpty(uuid, String.format("Object %s cannot be empty", objectName));
    }

    static void validateNotBlank(String uuid, String objectName) {
        Validate.notBlank(uuid, String.format("Uuid %s cannot be blank", objectName));
    }
}
