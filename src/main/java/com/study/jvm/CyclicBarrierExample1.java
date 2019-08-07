package com.study.jvm;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Date: 2019/8/1 10:05
 * Description:
 *
 * @author MOZi12
 */
@Slf4j
public class CyclicBarrierExample1 {

    private static CyclicBarrier barrier = new CyclicBarrier(5,()->{
        log.info("over  "+Thread.currentThread().getId());
        int i=1/0;
    });

    public static void main(String[] args) throws Exception {

        ExecutorService executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception",e);
                }
            });
        }
        TimeUnit.SECONDS.sleep(10);
        executor.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info(threadNum+"{} is ready "+Thread.currentThread().getId());
        barrier.await();
        log.info(threadNum+"{} is continue "+Thread.currentThread().getId());
    }
}
