package com.guofei.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/11/18/16:06
 * @Description: Redssion 看门狗源码分析
 */
public class WatchDogDemo {

    public static final String LOCK_KEY = "AAA";
    private static Config config;
    private static Redisson redisson;

    static {
        config = new Config();
        config.useSingleServer().setAddress( "redis://" + "127.0.0.1" + ":6379").setDatabase(0);
        redisson = (Redisson) Redisson.create(config);
    }

    public static void main(String[] args) {
        RLock lock = redisson.getLock(LOCK_KEY);
        lock.lock();
        lock.lock();
        lock.lock();

        try {
            System.out.println("AAA start...");
            try {
                TimeUnit.SECONDS.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()){
                lock.unlock();
                lock.unlock();
                lock.unlock();
            }
        }

        System.out.println(Thread.currentThread().getName()+ "end.");

        try  {
            TimeUnit. SECONDS .sleep( 3 );
        }  catch  (InterruptedException e) {
            e.printStackTrace();
        }
        redisson .shutdown();
    }
}
