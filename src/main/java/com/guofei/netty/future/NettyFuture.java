package com.guofei.netty.future;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

/**
 * NettyFuture
 * @author: GuoFei
 * @date: 2022-04-17 14:39
 */
public class NettyFuture {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    NioEventLoopGroup group = new NioEventLoopGroup();

    // 获得 EventLoop 对象
    EventLoop eventLoop = group.next();
    Future<Integer> future = eventLoop.submit(() -> 50);

    // 主线程中获取结果
    System.out.println(Thread.currentThread().getName() + " 获取结果");
    System.out.println("getNow " + future.getNow());
    System.out.println("get " + future.get());

    // NIO线程中异步获取结果
    future.addListener(future1 -> {
      System.out.println(Thread.currentThread().getName() + " 获取结果");
      System.out.println("getNow " + future1.getNow());
    });
  }
}
