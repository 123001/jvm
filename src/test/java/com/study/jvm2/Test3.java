package com.study.jvm2;

import org.junit.Test;

/**
 * Date: 2019/8/12 15:43
 * Description:
 *
 * @author MOZi12
 */
public class Test3 {
    //子类初始化时，父接口不会初始化
    @Test
    public void test(){
        System.out.println(Son.i);
        System.out.println(new Son());
    }
}

interface Parent {
    static Thread t1 = new Thread() {
        {
            System.out.println("parent init ...");
        }
    };
}

class Son implements Parent {
    static Thread t1 = new Thread() {
        {
            System.out.println("Son init ...");
        }
    };
    public static int i = 10;
}