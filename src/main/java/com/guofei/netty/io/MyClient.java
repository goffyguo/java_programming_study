package com.guofei.netty.io;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * 处理IO任务
 * @author: GuoFei
 * @date: 2022-04-17 14:25
 */
public class MyClient {

  public static void main(String[] args) throws IOException, InterruptedException {
    Channel channel = new Bootstrap()
        .group(new NioEventLoopGroup())
        .channel(NioSocketChannel.class)
        .handler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new StringEncoder());
          }
        })
        .connect(new InetSocketAddress("localhost", 8080))
        .sync()
        .channel();
    System.out.println(channel);
    // 此处打断点调试，调用 channel.writeAndFlush(...);
    System.in.read();
  }

}
