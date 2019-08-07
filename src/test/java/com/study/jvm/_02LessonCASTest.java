package com.study.jvm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Date: 2019/7/31 11:25
 * Description:
 *
 * @author MOZi12
 */
public class _02LessonCASTest {

    @Test
    public void test01() {
        //i++线程安全问题，atomicInteger解决
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    int andIncrement = atomicInteger.getAndIncrement();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
        }
        System.out.println(atomicInteger.get());
    }


    @Getter
    @AllArgsConstructor
    static class Person {
        volatile int id;
    }

    @Test
    public void test22() {
        Person person = new Person(0);
        AtomicIntegerFieldUpdater<Person> id = AtomicIntegerFieldUpdater.newUpdater(Person.class, "id");
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    id.getAndIncrement(person);
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
        }
        System.out.println(person.getId());
    }


}