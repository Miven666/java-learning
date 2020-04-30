package miven.java.concurrent;

import miven.java.pool.ThreadPoolExample;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * volatile 关键字
 *
 * @author mingzhi.xie
 * @date 2019/6/4.
 */
public class VolatileExample {

    // private int inc = 0;

    /**
     * volatile 只能保证可见性，无法保证自增这种非原子性操作
     */
    private volatile int inc = 0;

    /**
     * 线程数
     */
    private final int threadNum = 10;

    /**
     * 单线程自增次数
     */
    private final int increaseNum = 1000;

    /**
     * 通过 synchronized 保证自增的原子性
     */
    private synchronized void increase() {
        // inc = inc + 1;
        inc++;
    }
    public static void main(String[] args) {
        final VolatileExample example = new VolatileExample();
        ThreadPoolExecutor executor = ThreadPoolExample.createThreadPoolExecutor();

        for (int i = 0; i < example.threadNum; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " start inc: " + example.inc);
                for (int j = 0; j < example.increaseNum; j++) {
                    example.increase();
                }
                System.out.println(Thread.currentThread().getName() + " end inc: " + example.inc);

            });

        }

        //有序关闭，在此过程中执行以前提交的任务，但不接受任何新任务
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                break;
            }
        }

        System.out.println("inc: " + example.inc);
    }
}
