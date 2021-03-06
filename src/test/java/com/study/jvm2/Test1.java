package com.study.jvm2;

import org.junit.Test;

import java.util.UUID;

/**
 * Date: 2019/8/9 13:58
 * Description:
 *
 * @author MOZi12
 */
public class Test1 {


    /**
     * 静态方法或属性使用，会初始化定义一那个类
     * 常量：常量使用不会加载常量类，因为编译时常量以编译进入调用类中常量池中
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(Child.age);
//        System.out.println(Child.age2);
        System.out.println(Child.name);
        while (true) {
        }
    }

    @Test
    public void test1() {
        System.out.println(Dog.name);
    }
    @Test
    public void test2() {
        System.out.println(Dog.name1);
    }
    @Test
    public void test3() {
        System.out.println(Dog.name2);
    }
}

class Person {
    public static final String name = "aaaa";
    public static String age = "12";

    static {
        System.out.println("person init ....");
    }
}

class Child extends Person {
    public static String age2 = "15";

    static {
        System.out.println("child init ....");
    }
}

class Dog {
    public static final String name = "aaaa";
    public static String name1 = "aaaa";
    public static final String name2 = UUID.randomUUID().toString();

    static {
        System.out.println("Dog init ....");
    }
}
