package com.study.jvm;

import lombok.SneakyThrows;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Date: 2019/7/30 10:04
 * Description:
 *
 * @author MOZi12
 */
@Slf4j
public class Test5 {
    static class Person {
        int i = 0;

        @SneakyThrows
        public void print() {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                int i = this.i;
                log.info("i={}", i);
            }
        }

        @SneakyThrows
        public void add() {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("add " + i);
                i++;
            }
        }
    }

    public static void main(String[] a) throws InterruptedException {
        Person person = new Person();
       /* new Thread(()->{
            person.print();
        },"a").start();*/
        new Thread(() -> {
            person.add();
        }, "b").start();
        while (person.i == 0) {
            int i =person.i;
             i =person.i;
             int j=i+1;
            Person person1 = new Person();
            int i1 = person1.i + i;
        }
        System.out.println("out");
    }

}
