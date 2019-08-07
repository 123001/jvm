package com.study.jvm;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Date: 2019/8/7 9:11
 * Description:
 *
 * @author MOZi12
 */
public class _04LessonSyncTest {

    @Test
    public void testSync() throws InterruptedException {
        _04LessonSync.SyncLock syncLock = new _04LessonSync.SyncLock();
        new Thread(syncLock, "AAA").start();
        new Thread(syncLock, "BBB").start();

        TimeUnit.SECONDS.sleep(100);
    }

    @Test
    public void testSync2() throws InterruptedException {
        Object o = new Object();
        _04LessonSync.SyncLock2 syncLock = new _04LessonSync.SyncLock2(o);
        new Thread(syncLock, "AAA").start();
        new Thread(syncLock, "BBB").start();

        TimeUnit.SECONDS.sleep(100);
    }

    @Test
    public void testLock() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        _04LessonSync.LockRun lockRun = new _04LessonSync.LockRun(lock);
        new Thread(lockRun, "AAA").start();
        new Thread(lockRun, "BBB").start();

        TimeUnit.SECONDS.sleep(100);
    }
}