package com.miven.pool;

import java.util.concurrent.*;

/**
 * 线程池 例子
 *
 * @author mingzhi.xie
 * @date 2019/4/23.
 */
public class ThreadPoolExample {

    public ThreadPoolExecutor createThreadPoolExecutor() {
        // init params
        int corePoolSize = 5;
        int maximumPoolSize = 15;
        long keepAliveTime = 20;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        return new ThreadPoolExecutor(
                corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue, threadFactory, handler);
    }
}
