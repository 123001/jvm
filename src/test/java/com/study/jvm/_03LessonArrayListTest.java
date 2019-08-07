package com.study.jvm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Date: 2019/7/31 13:37
 * Description:
 *
 * @author MOZi12
 */
public class _03LessonArrayListTest {


    @Test
    public void test1() throws InterruptedException {
        /**
         * 故障：
         * java.util.ConcurrentModificationException
         * 原因：
         * 多线程并发写引起的
         * 解决方案：
         * 1 new Vector<>()
         * 2 Collections.synchronizedList(new ArrayList<>())
         * 3 new CopyOnWriteArrayList<>()
         */
        List<String> mj = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                mj.add(UUID.randomUUID().toString());
                System.out.println(mj);
            }).start();
        }
        TimeUnit.SECONDS.sleep(5);
    }

}