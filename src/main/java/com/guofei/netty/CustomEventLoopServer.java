package com.guofei.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义EventLoopGroup
 * @author: GuoFei
 * @date: 2022-04-17 14:32
 */
@Slf4j
public class CustomEventLoopServer {
  public static void main(String[] args) {
    // 增加自定义的非NioEventLoopGroup
    EventLoopGroup group = new DefaultEventLoopGroup();

    new ServerBootstrap()
        .group(new NioEventLoopGroup(1), new NioEventLoopGroup(2))
        .channel(NioServerSocketChannel.class)
        .childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel socketChannel) throws Exception {
            // 增加两个handler，第一个使用NioEventLoopGroup处理，第二个使用自定义EventLoopGroup处理
            socketChannel.pipeline().addLast("nioHandler",new ChannelInboundHandlerAdapter() {
              @Override
              public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                ByteBuf buf = (ByteBuf) msg;
                log.info(Thread.currentThread().getName() + " " + buf.toString(
                    StandardCharsets.UTF_8));
                // 调用下一个handler
                ctx.fireChannelRead(msg);
              }
            })
                // 该handler绑定自定义的Group
                .addLast(group, "myHandler", new ChannelInboundHandlerAdapter() {
                  @Override
                  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                    ByteBuf buf = (ByteBuf) msg;
                    log.info(Thread.currentThread().getName() + " " + buf.toString(StandardCharsets.UTF_8));
                  }
                });
          }
        })
        .bind(8080);
  }
}
