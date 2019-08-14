package com.study.jvm2;

import org.junit.Test;

/**
 * Date: 2019/8/12 14:45
 * Description:
 *
 * @author MOZi12
 */
public class Test2 {
    //类的初始化过程：准备，初始化。初始化时，静态属性从上往下执行。
    @Test
    public void test1(){
        Signal instance = Signal.getInstance();
        System.out.println(Signal.a1);
        System.out.println(Signal.a2);
    }
}
class Signal{

    public static int a1;

    private static Signal signal = new Signal();

    public static int a2=0;

    private Signal(){
        a1++;
        a2++;
    }

    public static Signal getInstance(){
        return signal;
    }
}
