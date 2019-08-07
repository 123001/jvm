package com.study.jvm;

/**
 * Date: 2019/7/31 14:31
 * Description:
 *
 * @author MOZi12
 */
public class InterruptionInJava implements Runnable {

    static volatile boolean on = false;

    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new InterruptionInJava(), "InterruptionInJava");
        testThread.start();
        Thread.sleep(1000);
        InterruptionInJava.on = true;
        testThread.interrupt();

        System.out.println("main end");

    }

    @Override
    public void run() {
        while (!on) {
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                System.out.println("caught exception: " + e);
            }
        }
    }

}
