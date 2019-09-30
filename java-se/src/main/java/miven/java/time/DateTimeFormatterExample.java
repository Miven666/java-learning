package miven.java.time;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DateTimeFormatter 例子
 * @author mingzhi.xie
 * @date 2019/6/3.
 * @see DateTimeFormatter
 */
class DateTimeFormatterExample {

    static void formatTime() {
        String defaultZoneId = ZoneId.systemDefault().toString();
        System.out.println("默认时区 defaultZoneId: " + defaultZoneId);

        String localDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        System.out.println("本地时间 localDateTime: " + localDateTime);

        String zonedDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ZonedDateTime.now());
        System.out.println("时区时间 zonedDateTime: " + zonedDateTime);

        String isoDateTime = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
        System.out.println("标准时间 isoDateTime: " + isoDateTime);

        long millis = System.currentTimeMillis();
        System.out.println("当前时间毫秒值 currentTimeMillis: " + millis);
        System.out.println("当前时间时间戳 timestamp: " + new Timestamp(millis));
    }
}
