package com.study.jvm;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Date: 2019/7/31 9:41
 * Description:
 *
 * @author MOZi12
 */
public class Test21 {

    void change(String a){
        a=new String("xxxx");
    }
    public static void main(String[]a){
        Test21 test21 = new Test21();
        String aaaa= new String("aaa");
        test21.change(aaaa);
        System.out.println(aaaa);
    }


}
