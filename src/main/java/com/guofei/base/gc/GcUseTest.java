package com.guofei.base.gc;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * -XX:+PrintCommandLineFlags
 *
 * @Author: GuoFei
 * @Date: 2021/12/01/10:25
 * @Description:
 */
public class GcUseTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        while (true){
            byte[] bytes = new byte[100];
            list.add(bytes);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
