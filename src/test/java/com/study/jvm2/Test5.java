package com.study.jvm2;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Date: 2019/8/13 10:29
 * Description:
 *
 * @author MOZi12
 */
public class Test5 {
    @Test
    public void test1() throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = contextClassLoader.getResources("java/lang/String.class");
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url);
        }

    }

}
