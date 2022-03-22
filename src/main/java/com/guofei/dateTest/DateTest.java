package com.guofei.dateTest;

import java.util.concurrent.CountDownLatch;

/**
 * @author: GuoFei
 * @date: 2022-03-22 14:16
 */
public class DateTest {



  public static void main(String[] args) throws InterruptedException {
    //extracted();

    System.out.println(CurrentTimeMillisClock.getInstance().now());


  }

  private static void extracted() throws InterruptedException {
    int COUNT = 100;
    long beginTime = System.nanoTime();
    for (int i = 0; i < COUNT; i++) {
      System.currentTimeMillis();
    }

    long elapsedTime = System.nanoTime() - beginTime;
    System.out.println("100 System.currentTimeMillis() serial calls: " + elapsedTime + " ns");

    CountDownLatch startLatch = new CountDownLatch(1);
    CountDownLatch endLatch = new CountDownLatch(COUNT);
    for (int i = 0; i < COUNT; i++) {
      new Thread(() -> {
        try {
          startLatch.await();
          System.currentTimeMillis();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          endLatch.countDown();
        }
      }).start();
    }

    beginTime = System.nanoTime();
    startLatch.countDown();
    endLatch.await();
    elapsedTime = System.nanoTime() - beginTime;
    System.out.println("100 System.currentTimeMillis() parallel calls: " + elapsedTime + " ns");
  }

}
