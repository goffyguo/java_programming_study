package com.guofei.netty.io;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;

/**
 * 处理IO任务
 * @author: GuoFei
 * @date: 2022-04-17 14:25
 */
@Slf4j
public class MyServer {

  public static void main(String[] args) {
    new ServerBootstrap()
        // 两个Group，分别为Boss 负责Accept事件，Worker 负责读写事件
        .group(new NioEventLoopGroup(1), new NioEventLoopGroup(2))
        .channel(NioServerSocketChannel.class)
        .childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
              @Override
              public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                ByteBuf buf = (ByteBuf) msg;
                log.info(
                    Thread.currentThread().getName() + " " + buf.toString(StandardCharsets.UTF_8));
                //super.channelRead(ctx, msg);
              }
            });
          }
        }).bind(8080);
  }
}
