package com.web.link.checker.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidateUtils {

    public static void notNull(Object object, String objectName) {
        Validate.notNull(object, String.format("Object '%s' cannot be null", objectName));
    }

    public static void notBlank(String uuid, String objectName) {
        Validate.notBlank(uuid, String.format(" '%s' cannot be blank", objectName));
    }
}
