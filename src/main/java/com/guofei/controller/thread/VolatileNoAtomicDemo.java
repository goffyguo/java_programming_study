package com.guofei.controller.thread;

import org.springframework.ui.context.Theme;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/07/14:53
 * @Description: Volatile 不保证原子性
 */
public class VolatileNoAtomicDemo {

    public static void main(String[] args) {

        MyNumber myNumber = new MyNumber();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myNumber.addPlusPlus();
                }
            },String.valueOf(i)).start();
        }

        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(Thread.currentThread().getName() + "\t" + myNumber.num);
    }

}
class MyNumber{

    volatile int num = 10;

    public void addPlusPlus(){
        num++;
    }

}
