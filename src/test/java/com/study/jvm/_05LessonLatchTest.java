package com.study.jvm;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Date: 2019/8/7 9:40
 * Description:
 *
 * @author MOZi12
 */
public class _05LessonLatchTest {

    @Test
    public void testLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        _05LessonLatch.LatchRun latchRun = new _05LessonLatch.LatchRun(countDownLatch);
        for(int i=0;i<10;i++){
            new Thread(latchRun,String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("main go");
    }
    @Test
    public void testSemaphore() throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        _05LessonLatch.SemaRun semaRun = new _05LessonLatch.SemaRun(semaphore);
        for(int i=0;i<10;i++){
            new Thread(semaRun,String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    public void testCyclicBarrier() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("最后任务"));
        _05LessonLatch.CyclicBarrierRun cyclicBarrierRun = new _05LessonLatch.CyclicBarrierRun(cyclicBarrier);

        for(int i=0;i<10;i++){
            new Thread(cyclicBarrierRun,String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(10);
    }

}