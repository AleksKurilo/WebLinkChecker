package com.web.link.checker.project.utils;

import lombok.Data;
import org.apache.commons.lang3.Validate;

@Data
public final class ValidateUtils {

    public static void notNull(Object object, String objectName) {
        Validate.notNull(object, String.format("Object '%s' cannot be null", objectName));
    }

    public static void notEmpty(String uuid, String objectName) {
        Validate.notEmpty(uuid, String.format("Object '%s' cannot be empty", objectName));
    }

    public static void notBlank(String uuid, String objectName) {
        Validate.notBlank(uuid, String.format(" '%s' cannot be blank", objectName));
    }
}
