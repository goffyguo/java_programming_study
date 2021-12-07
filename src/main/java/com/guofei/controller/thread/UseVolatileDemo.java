package com.guofei.controller.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/07/15:09
 * @Description:
 */
public class UseVolatileDemo {
    /*private volatile static boolean flag = true;


    public static void main(String[] args) {
        new Thread(() -> {
            while (flag) {
            }
        }, "t1").start();

        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            flag = false;
        }, "t2").start();
    }*/
    public class Counter {
        private volatile int value;

        //利用 volatile 保证读取操作的可见性
        public int getValue() {
            return value;
        }

        //利用 synchronized 保证复合操作的原子性
        public synchronized int increment() {
            return value++;
        }
    }
}
