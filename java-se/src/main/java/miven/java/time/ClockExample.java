package miven.java.time;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

/**
 *  时钟
 * @see  java.time.Clock
 * @author mingzhi.xie
 * @date 2019/8/14
 * @since 1.0
 */
public class ClockExample {

    public static void main(String[] args) {
        tickClock();
    }

    /**
     *  滴答时钟
     *  我们日常见到的挂钟就是 滴答为1秒的 滴答时钟
     *  例如指针移动一格就是30分钟、1小时、1天、1年等各种场景
     */
    private static void tickClock() {
        // 系统默认时区的 时钟
        Clock system = Clock.systemDefaultZone();
        // 时刻 (开始)
        Instant baseInstant = system.instant();
        System.out.println("开始时刻：" + baseInstant.getEpochSecond() + "秒");

        // 滴答的持续时间 (时钟指针移动一格的最小单位)
        Duration duration = Duration.ofSeconds(2L);
        // 设置滴答 时钟
        Clock tick = Clock.tick(system, duration);
        System.out.println("滴答的持续时间: 2秒");

        // 时刻 (现在)
        Instant instant = tick.instant();
        System.out.println("现在时刻：" + instant.getEpochSecond() + "秒");

    }
}
