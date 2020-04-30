package miven.java.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 递减计数锁
 * @author mingzhi.xie
 * @date 2020/4/20
 * @since 1.0
 * @see CountDownLatch
 */
public class CountDownLatchExample {
    /**
     * 老板进入会议室等待5员工全部到达会议室才会开会（给这样的老板点赞吧！！！！）
     */
    private static final CountDownLatch latch = new CountDownLatch(5);

    public static void main(String[] args) {
        new Boss().start();

        long count = latch.getCount();
        for (int i = 0; i < count; i++) {
            new Employee().start();
        }
    }

    private static class Boss extends Thread {
        @Override
        public void run() {
            System.out.println("Boss 要在会议室等待 " + latch.getCount() + " 个员工");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Boss 线程被中断了");
                Thread.currentThread().interrupt();
            }
            System.out.println("所有人都到齐了，开会吧");
        }
    }

    private static class Employee extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ", 到达会议室......");
            latch.countDown();
        }
    }
}
