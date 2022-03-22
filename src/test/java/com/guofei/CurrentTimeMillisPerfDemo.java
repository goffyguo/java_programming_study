package com.guofei;

import java.util.concurrent.CountDownLatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: GuoFei
 * @date: 2022-03-22 14:02
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CurrentTimeMillisPerfDemo {


  @Test
  public void test() throws InterruptedException {
    int COUNT = 100;
    long beginTime = System.nanoTime();
    for (int i = 0; i < COUNT; i++) {
      System.currentTimeMillis();
    }

    long elapsedTime = System.nanoTime() - beginTime;
    System.out.println("100 System.currentTimeMillis() serial calls: " + elapsedTime + " ns\"");


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
