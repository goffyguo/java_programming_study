package com.guofei.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import java.nio.charset.StandardCharsets;

/**
 * @author: GuoFei
 * @date: 2022-04-17 14:42
 */
public class ByteBufStudy {
  public static void main(String[] args) {
    // 创建ByteBuf
    ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16);
    ByteBufUtils.log(buffer);

    // 向buffer中写入数据
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 20; i++) {
      sb.append("a");
    }
    buffer.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8));

    // 查看写入结果
    ByteBufUtils.log(buffer);
  }
}
