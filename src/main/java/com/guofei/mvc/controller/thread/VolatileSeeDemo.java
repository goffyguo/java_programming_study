package com.guofei.mvc.controller.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/07/11:30
 * @Description: Volatile 可见性
 */
public class VolatileSeeDemo {

    /**
     * 不加 Volatile 没有可见性
     */
    //static boolean flag = true;

    /**
     * 加 Volatile 具有可见性
     */
    volatile  static boolean flag = true;

     public static void main(String[] args)
    {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t"+"---come in");
            while(flag)
            {
                new Integer(308);
            }
            System.out.println("t1 over");
        },"t1").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> {
            flag = false;
        },"t2").start();
    }
}
