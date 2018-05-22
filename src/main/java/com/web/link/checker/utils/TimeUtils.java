package com.web.link.checker.utils;

import java.sql.Timestamp;

public class TimeUtils {

    public static Timestamp getTimeFromMilliseconds(long milliseconds) {
        Timestamp time = new Timestamp(milliseconds);
        return milliseconds != 0 ? time : null;
    }
}
