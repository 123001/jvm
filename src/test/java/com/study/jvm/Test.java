package com.study.jvm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Date: 2019/7/31 17:17
 * Description:
 *
 * @author MOZi12
 */
public class Test {


    @org.junit.Test
    public void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t begin");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println("go init ");
        });
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        LockSupport.unpark(t1);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("begin");
        LockSupport.unpark(t1);
        TimeUnit.SECONDS.sleep(2);



    }
}
