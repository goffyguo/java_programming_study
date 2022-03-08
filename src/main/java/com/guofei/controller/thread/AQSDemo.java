package com.guofei.controller.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/20/15:29
 * @Description:
 */
public class AQSDemo {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        //3个线程模拟3个人来银行网点，受理窗口办理业务的顾客
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("------A thread come in");
                try { TimeUnit.MINUTES.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
            }finally {
                lock.unlock();
            }
        },"A").start();

        new Thread(()->{
            lock.lock();
            try {
                System.out.println("------B thread come in");
            }finally {
                lock.unlock();
            }
        },"B").start();

        new Thread(()->{
            lock.lock();
            try {
                System.out.println("------C thread come in");
            }finally {
                lock.unlock();
            }
        },"C").start();
    }
}
