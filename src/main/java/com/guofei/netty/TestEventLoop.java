package com.guofei.netty;

import io.netty.channel.nio.NioEventLoopGroup;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * 处理普通与定时任务
 * @author: GuoFei
 * @date: 2022-04-17 14:14
 */
@Slf4j
public class TestEventLoop {

  public static void main(String[] args) {

    // 创建拥有两个EventLoop的NioEventLoopGroup，对应两个线程
    NioEventLoopGroup eventExecutors = new NioEventLoopGroup(2);
    // 通过next方法可以获得下一个 EventLoop
    log.info("group.next{}", eventExecutors.next());
    log.info("group.next{}", eventExecutors.next());

    // 通过EventLoop执行普通任务
    eventExecutors.next().execute(() -> log.info(Thread.currentThread().getName() + "Hello"));
    // 通过EventLoop执行定时任务
    eventExecutors.next().scheduleAtFixedRate(
        () -> log.info(Thread.currentThread().getName() + "Hello2"), 0, 1, TimeUnit.SECONDS);

    // 优雅的关闭
    eventExecutors.shutdownGracefully();

  }

}
