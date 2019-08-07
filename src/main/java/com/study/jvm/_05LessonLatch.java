package com.study.jvm;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Date: 2019/8/7 9:36
 * Description:
 *
 * @author MOZi12
 */
@Slf4j
public class _05LessonLatch {
    public static class LatchRun implements Runnable {

        private CountDownLatch countDownLatch;

        public LatchRun(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        @SneakyThrows
        public void run() {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            System.out.println(Thread.currentThread().getName() + " thread");
            countDownLatch.countDown();
        }
    }

    public static class SemaRun implements Runnable {
        private Semaphore semaphore;

        public SemaRun(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        @SneakyThrows
        public void run() {
            try {
                semaphore.acquire();
                log.info(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            } finally {
                semaphore.release();
            }
        }
    }

    public static class CyclicBarrierRun implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public CyclicBarrierRun(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        @SneakyThrows
        public void run() {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            log.info("到达栅栏");
            cyclicBarrier.await();
            log.info("冲破栅栏");

        }
    }
}
