package com.guofei.base.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: GuoFei
 * @date: 2022-03-08 11:47
 */
public class CopyFile {

  static public void main(String args[]) throws Exception {
    if (args.length < 2) {
      System.err.println("Usage: java CopyFile infile outfile");
      System.exit(1);
    }

    String infile = args[0];
    String outfile = args[1];

    FileInputStream fin = new FileInputStream(infile);
    FileOutputStream fout = new FileOutputStream(outfile);

    FileChannel fcin = fin.getChannel();
    FileChannel fcout = fout.getChannel();
    // 在能够读和写之前，必须有一个缓冲区。要创建缓冲区，您必须 分配 它。我们使用静态方法 allocate() 来分配缓冲区
    // allocate（）分配一个具有指定大小的底层数组，并将它包装到一个缓冲区对象中
    ByteBuffer buffer = ByteBuffer.allocate(1024);

    while (true) {
      // 重设缓冲区，使它可以接受读入的数据
      buffer.clear();
      // 将数据从输入通道 fcin 中读入缓冲区
      int r = fcin.read(buffer);
      // 检查拷贝何时完成，当没有更多的数据时，拷贝就算完成，并且可以在 read() 方法返回 -1 是判断这一点
      if (r == -1) {
        break;
      }
      // 让缓冲区可以将新读入的数据写入另一个通道
      buffer.flip();
      // 将这些数据写到输出通道 fcout
      fcout.write(buffer);
    }
  }

}
