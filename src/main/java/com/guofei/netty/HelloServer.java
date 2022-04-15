package com.guofei.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author guofei
 * @date 2022/4/15 3:01 PM
 */
@Slf4j
public class HelloServer {

  public static void main(String[] args) {
    // 1、启动器，负责装配netty组件，启动服务器
    new ServerBootstrap()
        // 2、创建NioEventLoopGroup,可以简答理解为线程池+selector
        .group(new NioEventLoopGroup())
        .channel(NioServerSocketChannel.class)
        .childHandler(new ChannelInitializer<NioSocketChannel>() {
          @Override
          protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
            nioSocketChannel.pipeline().addLast(new StringDecoder());
            nioSocketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
              @Override
              protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s)
                  throws Exception {
                log.info("----s---->{}",s);
              }
            });
          }
        }).bind(8888);
  }

}
