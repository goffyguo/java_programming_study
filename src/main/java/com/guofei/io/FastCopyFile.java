package com.guofei.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 直接缓冲区:直接缓冲区 是为加快 I/O 速度，而以一种特殊的方式分配其内存的缓冲区
 * 给定一个直接字节缓冲区，Java 虚拟机将尽最大努力直接对它执行本机 I/O 操作。
 * 也就是说，它会在每一次调用底层操作系统的本机 I/O 操作之前(或之后)，
 * 尝试避免将缓冲区的内容拷贝到一个中间缓冲区中(或者从一个中间缓冲区中拷贝数据)。
 *
 * @author: GuoFei
 * @date: 2022-03-08 11:53
 */
public class FastCopyFile {
  static public void main( String args[] ) throws Exception {
    if (args.length < 2) {
      System.err.println("Usage: java FastCopyFile infile outfile");
      System.exit(1);
    }

    String infile = args[0];
    String outfile = args[1];

    FileInputStream fin = new FileInputStream(infile);
    FileOutputStream fout = new FileOutputStream(outfile);

    FileChannel fcin = fin.getChannel();
    FileChannel fcout = fout.getChannel();
    // 直接缓冲区
    ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    while (true) {
      buffer.clear();

      int r = fcin.read(buffer);

      if (r == -1) {
        break;
      }

      buffer.flip();

      fcout.write(buffer);
    }
  }
}
