package com.miven.pool;

import org.junit.Test;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExampleTest {

    private ThreadPoolExample threadPoolExample = new ThreadPoolExample();

    @Test
    public void ctlTest() {
        System.out.println(-1 << 29);
        System.out.println(0);
        System.out.println(1 << 29);
        System.out.println(2 << 29);
        System.out.println(3 << 29);
    }

    @Test
    public void createThreadPoolExecutorTest() {
        ThreadPoolExecutor poolExample = threadPoolExample.createThreadPoolExecutor();
        System.out.println("Create ThreadPoolExecutor success");
        System.out.println("正在积极执行任务的线程数 activeCount: " + poolExample.getActiveCount());
    }
}
