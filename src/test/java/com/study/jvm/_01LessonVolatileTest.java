package com.study.jvm;

import com.study.jvm._01LessonVolatile;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Date: 2019/7/30 10:32
 * Description:
 *
 * @author MOZi12
 */
public class _01LessonVolatileTest {

    @Test
    public void Volatile可见性() {
        //普通变量无可见性，当一个线程修改变量值之后，其他线程从主内存中拷贝到工作内存（栈）的值不会改变
        _01LessonVolatile.NoVolatileDemo volatileDemo = new _01LessonVolatile.NoVolatileDemo();
//        _01LessonVolatile.VolatileDemo volatileDemo = new _01LessonVolatile.VolatileDemo();
        new Thread(() -> {
            System.out.println("change in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                volatileDemo.changeTo60();
                System.out.println("change after num:" + volatileDemo.num);
            }
        }, "change thread").start();

        while (volatileDemo.num == 0) {
            System.out.println("go");
        }
        System.out.println("main over num:" + volatileDemo.num);
    }

    @Test
    public void Volatile不保证原子性() {
        _01LessonVolatile.VolatileDemo volatileDemo = new _01LessonVolatile.VolatileDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileDemo.addPP();
                    volatileDemo.addAI();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("final num:" + volatileDemo.num); //?? why 小于20000
        System.out.println("final atomicInteger:" + volatileDemo.atomicInteger);
    }
}
