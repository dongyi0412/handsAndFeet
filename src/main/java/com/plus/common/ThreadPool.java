package com.plus.common;

import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dongyi
 * @date  2022年11月15日11:38:46
 */
@Component
public class ThreadPool {

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2,CPU_COUNT * 2);
    private static final int MAX_POOL_SIZE = Math.max(2,CPU_COUNT * 2);
    private static final int QUEUE_CAPACITY = 200000;
    private static final Long KEEP_ALIVE_TIME = 1L;


    public ThreadPoolExecutor IOThreadPool()  {

        return new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
