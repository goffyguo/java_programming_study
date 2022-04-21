package com.guofei.mvc.controller.thread;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/07/15:01
 * @Description:
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.get());


        System.out.println(atomicInteger.compareAndSet(5, 308) + "\t" + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 3333) + "\t" + atomicInteger.get());
    }
}
