package com.guofei.controller.thread;

import org.openjdk.jol.info.ClassLayout;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/10/16:24
 * @Description: sync 锁升级 DEMO
 */
public class SyncUpgradeDemo {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("10进制 hash 码"+o.hashCode());
        System.out.println("16进制 hash 码"+Integer.toHexString(o.hashCode()));
        System.out.println("2进制 hash 码"+Integer.toBinaryString(o.hashCode()));

        //  101010000100111001101001010101
        //00101010000100111001101001010101
        //System.out.println(ClassLayout.parseInstance(o).toPrintable());
        new Thread(()->{
            synchronized (o){
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        },"t1").start();
    }
}
