package com.guofei.netty.promise;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultPromise;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * NettyPromise
 * @author: GuoFei
 * @date: 2022-04-17 14:40
 */
public class NettyPromise {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // 创建EventLoop
    NioEventLoopGroup group = new NioEventLoopGroup();
    EventLoop eventLoop = group.next();

    // 创建Promise对象，用于存放结果
    DefaultPromise<Integer> promise = new DefaultPromise<>(eventLoop);

    new Thread(()->{
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // 自定义线程向Promise中存放结果
      promise.setSuccess(50);
    }).start();

    // 主线程从Promise中获取结果
    System.out.println(Thread.currentThread().getName() + " " + promise.get());
  }
}
