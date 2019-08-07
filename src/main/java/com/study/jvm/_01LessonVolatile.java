package com.study.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Date: 2019/7/30 10:05
 * Description:
 *
 * @author MOZi12
 */
public class _01LessonVolatile {

    static public class NoVolatileDemo {
        public int num;

        public void changeTo60() {
            this.num =60;
        }
        public int get(){
            return num;
        }
    }

    static public class VolatileDemo {
        public volatile int num;

        public void changeTo60() {
            this.num = 60;
        }

        public void addPP() {
            this.num++;
        }
        public synchronized  void addPPSync(){
            this.num++;
        }
        public AtomicInteger atomicInteger=new AtomicInteger();
        public void addAI(){
            atomicInteger.getAndIncrement();
        }
    }



}
