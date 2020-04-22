package miven.java.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环屏障锁 学习示例
 * @author mingzhi.xie
 * @date 2020/4/22
 * @since 1.0
 * @see CyclicBarrier
 */
public class CyclicBarrierExample {

    private static final CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("所有员工到齐了"));


    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 15; i++) {
            new AttendMeetingEmployee().start();
            Thread.sleep(1000L);
        }

    }

    private static class AttendMeetingEmployee extends Thread {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "员工到了");
            try {
                barrier.await();
                System.out.println(name + "收到，准备巴拉巴拉");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
