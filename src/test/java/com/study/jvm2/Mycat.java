package com.study.jvm2;

/**
 * Date: 2019/8/13 15:55
 * Description:
 *
 * @author MOZi12
 */
public class Mycat {
    public void run(Object object) {
        System.out.println(object.getClass().getClassLoader());
    }
}
