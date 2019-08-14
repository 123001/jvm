package com.study.jvm2;

import org.junit.Test;

/**
 * Date: 2019/8/12 17:13
 * Description:
 *
 * @author MOZi12
 */
class CL {
    static {
        System.out.println("cl init");
    }
}

public class Test4 {
    //类加载类加载类，不属于首次使用。反射属于首次使用，所以才会初始化
    @Test
    public void test() throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> cl = systemClassLoader.loadClass("com.study.jvm2.CL");
        System.out.println(cl);
        System.out.println("-----------------");
        Class<?> aClass = Class.forName("com.study.jvm2.CL");
        System.out.println(aClass);
    }
}
