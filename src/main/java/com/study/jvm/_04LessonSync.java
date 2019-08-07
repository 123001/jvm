package com.study.jvm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Date: 2019/8/7 9:08
 * Description:
 *
 * @author MOZi12
 */
public class _04LessonSync {
    public static class SyncLock implements Runnable {

        @Override
        public synchronized void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " run");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    this.notify();
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class SyncLock2 implements Runnable {
        private Object lock;

        public SyncLock2(Object lock) {
            this.lock = lock;
        }


        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " run");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static class LockRun implements Runnable {

        private Lock lock;
        private Condition condition;

        public LockRun(Lock lock) {
            this.lock = lock;
            this.condition = lock.newCondition();
        }

        @Override
        public void run() {
            try {
                lock.lock();
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " run");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        condition.signal();
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } finally {
                lock.unlock();
            }


        }
    }


}
