package com.miven.concurrent;

import com.miven.pool.ThreadPoolExample;

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
    private int threadNum = 10;

    /**
     * 单线程自增次数
     */
    private int increaseNum = 1000;

    /**
     * 通过 synchronized 保证自增的原子性
     */
    private synchronized void increase() {
        // inc = inc + 1;
        inc++;
    }
    public static void main(String[] args) {
        final VolatileExample example = new VolatileExample();
        ThreadPoolExecutor executor = new ThreadPoolExample().createThreadPoolExecutor();

        for (int i = 0; i < example.threadNum; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " start inc: " + example.inc);
                for (int j = 0; j < example.increaseNum; j++) {
                    example.increase();
                }
                System.out.println(Thread.currentThread().getName() + " end inc: " + example.inc);

            });

        }

        //保证前面的线程都执行完
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                break;
            }
        }

        System.out.println("inc: " + example.inc);
    }
}
