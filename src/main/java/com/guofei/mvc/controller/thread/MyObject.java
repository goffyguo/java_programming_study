package com.guofei.mvc.controller.thread;


import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/09/11:25
 * @Description:
 */
public class MyObject {

    private final Object object = new Object();
    public void m1(){
        synchronized (object){
            System.out.println(11);
        }
    }

}

