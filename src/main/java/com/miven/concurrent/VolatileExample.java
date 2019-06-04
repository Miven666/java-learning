package com.miven.concurrent;

/**
 * volatile 关键字
 *
 * @author mingzhi.xie
 * @date 2019/6/4.
 */
public class VolatileExample {

    // private int inc = 0;

    /**
     * volatile 只能保证可见性，无法保证 自增这类 非原子性 操作
     */
    private volatile int inc = 0;

    private void increase() {
        inc++;
        // inc = inc + 1;
    }
    public static void main(String[] args) {
        final VolatileExample example = new VolatileExample();

        for (int i = 0; i < 60; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " start inc: " + example.inc);
                for (int j = 0; j < 1000; j++) {
                    example.increase();
                }
                System.out.println(Thread.currentThread().getName() + " end inc: " + example.inc);

            });

            thread.start();
        }


        //保证前面的线程都执行完
        while(Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("inc: " + example.inc);

    }
}
