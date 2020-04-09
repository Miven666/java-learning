package miven.java.concurrent.executor;

import miven.java.pool.ThreadPoolExample;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mingzhi.xie
 * @date 2020/4/2
 * @since 1.0
 */
public class ScheduledExecutorServiceExample {

    static volatile AtomicInteger i = new AtomicInteger(1);

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = ThreadPoolExample.createScheduledThreadPoolExecutor();
        // schedule(executor);

        // 当周期时间小于任务执行时间时，后面的任务会在前面的任务执行完立即执行，此时的周期时间相当于失效了，任务+任务+任务
        // 当周期时间大于任务执行时间时，每个任务的开始时间相差的才是周期时间
        scheduleAtFixedRate(executor);

        // 这种延迟固定时间会在前一个任务执行完延迟固定时间，任务+延迟时间+任务+延迟时间
        // scheduleWithFixedDelay(executor);

        while (true) {
            if (i.get() >= 3) {
                executor.shutdownNow();
                break;
            }
        }

    }

    private static void schedule(ScheduledThreadPoolExecutor executor) {
        long start = System.currentTimeMillis();
        System.out.println("开始时间：" + start);
        executor.schedule(() -> {
            long end = System.currentTimeMillis();
            System.out.println("延迟 5 秒：" + end);
            System.out.println("相差: "  + (end - start));
        }, 5, TimeUnit.SECONDS);
    }

    private static void scheduleAtFixedRate(ScheduledThreadPoolExecutor executor) {
        long start = System.currentTimeMillis();
        System.out.println("执行固定周期为5秒，任务所需时间为6秒，开始时间：" + start);
        executor.scheduleAtFixedRate(() -> {
            System.out.println("固定周期任务, 开始：" + System.currentTimeMillis());
            sleep(start, "固定周期任务, 结束：");
        }, 0, 5, TimeUnit.SECONDS);

    }

    public static void scheduleWithFixedDelay(ScheduledThreadPoolExecutor executor) {
        long start = System.currentTimeMillis();
        System.out.println("执行固定延迟时间为5秒，任务所需时间6秒，开始时间：" + System.currentTimeMillis());
        executor.scheduleWithFixedDelay(() -> {
            System.out.println("固定延迟时间, 开始：" + System.currentTimeMillis());
            sleep(start, "固定延迟时间, 结束：");
        }, 0, 5, TimeUnit.SECONDS);
    }


    private static void sleep(long start, String s) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(s + end);
        System.out.println("第" + i + "次执行结束距首次开始相差：" + (end - start));
        i.getAndIncrement();
    }

}
