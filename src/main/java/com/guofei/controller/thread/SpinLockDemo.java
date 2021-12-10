package com.guofei.controller.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/07/17:02
 * @Description:
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void MyLock(){
        System.out.println((Thread.currentThread().getName() + "\t" + "come in..."));
        while (!atomicReference.compareAndSet(null,Thread.currentThread())){

        }
        System.out.println((Thread.currentThread().getName() + "\t" + "持有锁成功。。。"));
    }
    public void MyUnlock(){
        atomicReference.compareAndSet(Thread.currentThread(),null);
        System.out.println((Thread.currentThread().getName() + "\t" + "释放锁成功。。。"));
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.MyLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.MyUnlock();
        },"t1").start();
        new Thread(()->{
            spinLockDemo.MyLock();
            spinLockDemo.MyUnlock();
        },"t2").start();
    }
}
