package com.study.jvm2;

import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Date: 2019/8/13 11:18
 * Description:
 *
 * @author MOZi12
 */
public class Test6 extends ClassLoader {

    private String path = "d:\\loader\\";
    private String ex = ".class";


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = this.loadClassData(name);
        return this.defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassData(String name) {
        return FileUtil.readBytes(path + name.replace(".", "\\") + ex);
    }

    /**
     * 命名空间：
     * 1.子加载器所加载的类能访问到父加载器所加载的类
     * 2.父加载器所加载的类不能访问到子加载器所加载的类
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Test6 test6 = new Test6();
        Class<?> a = test6.loadClass("com.study.jvm._01LessonVolatileTest");
        Object o = a.newInstance();
        System.out.println(a.getClassLoader());
        Test6 test2 = new Test6();
        Class<?> b = test2.loadClass("com.study.jvm._01LessonVolatileTest");
        System.out.println(b.getClassLoader());
        System.out.println(a.isAssignableFrom(b));

        o = null;
        a = null;
        test6 = null;

        System.gc();

    }

    @Test
    public void test2() throws Exception {
        Test6 test1 = new Test6();
        Test6 test2 = new Test6();

        Class<?> a = test1.loadClass("com.study.jvm2.Mycat");
        Class<?> b = test2.loadClass("com.study.jvm2.Mycat");
        Object o1 = a.newInstance();
        Object o2 = b.newInstance();

        System.out.println(a == b);
        Method method = a.getMethod("run", Object.class);

        method.invoke(o2, o1);
    }

    public static void main(String[] a) {
        System.out.println(Test6.class.getClassLoader());
        System.out.println(Mycat.class.getClassLoader());
        System.out.println(System.getProperty("java.ext.dirs"));
    }
}
