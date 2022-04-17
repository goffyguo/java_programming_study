package com.guofei.netty.future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * JDK Future
 * @author: GuoFei
 * @date: 2022-04-17 14:38
 */
public class JdkFuture {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ThreadFactory factory = new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        return new Thread(r, "JdkFuture");
      }
    };
    // 创建线程池
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(10), factory);

    // 获得Future对象
    Future<Integer> future = executor.submit(new Callable<Integer>() {

      @Override
      public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return 50;
      }
    });

    // 通过阻塞的方式，获得运行结果
    System.out.println(future.get());
  }
}
