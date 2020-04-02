package miven.java.concurrent.executor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mingzhi.xie
 * @date 2020/4/2
 * @since 1.0
 */
public class ScheduledExecutorServiceExample {

    @SuppressWarnings({"unchecked"})
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
        // schedule(executor);
        // executor.shutdown();

        // 当周期时间小于任务执行时间时，后面的任务会在前面的任务执行完立即执行，此时的周期时间相当于失效了，任务+任务+任务
        // 当周期时间大于任务执行时间时，每个任务的开始时间相差的才是周期时间
        scheduleAtFixedRate(executor);

        // 这种延迟固定时间会在前一个任务执行完延迟固定时间，任务+延迟时间+任务+延迟时间
        // scheduleWithFixedDelay(executor);
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
        final int[] i = {1};
        executor.scheduleAtFixedRate(() -> {
            System.out.println("固定周期任务, 开始：" + System.currentTimeMillis());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            System.out.println("固定周期任务, 结束：" + end);
            System.out.println("第" + i[0] + "次执行结束距首次开始相差：" + (end - start));
            i[0]++;

            while (i[0] >= 11) {
                executor.shutdownNow();
                System.exit(0);
            }
        }, 0, 5, TimeUnit.SECONDS);

    }

    private static void scheduleWithFixedDelay(ScheduledThreadPoolExecutor executor) {
        long start = System.currentTimeMillis();
        System.out.println("执行固定延迟时间为5秒，任务所需时间6秒，开始时间：" + System.currentTimeMillis());
        final int[] i = {1};
        executor.scheduleWithFixedDelay(() -> {
            System.out.println("固定延迟时间, 开始：" + System.currentTimeMillis());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            System.out.println("固定延迟时间, 结束：" + end);
            System.out.println("第" + i[0] + "次执行结束距首次开始相差：" + (end - start));
            i[0]++;

            while (i[0] >= 11) {
                executor.shutdownNow();
                System.exit(0);
            }
        }, 0, 5, TimeUnit.SECONDS);
    }


}
