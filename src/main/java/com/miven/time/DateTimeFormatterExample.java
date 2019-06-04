package com.miven.time;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mingzhi.xie
 * @date 2019/6/3.
 */
public class DateTimeFormatterExample {

    public static void main(String[] args) {

        String defaultZoneId = ZoneId.systemDefault().toString();
        System.out.println("defaultZoneId: " + defaultZoneId);

        String localDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        System.out.println("localDateTime: " + localDateTime);

        String zonedDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ZonedDateTime.now());
        System.out.println("zonedDateTime: " + zonedDateTime);

        String timestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
        System.out.println("timestamp: " + timestamp);

        String isoDateTime = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
        System.out.println("isoDateTime: " + isoDateTime);
    }
}
