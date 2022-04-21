package com.guofei.base.io;

import java.nio.FloatBuffer;

/**
 * 缓冲区类型
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * 每一个 Buffer 类都是 Buffer 接口的一个实例。
 * 除了 ByteBuffer，每一个 Buffer 类都有完全一样的操作，只是它们所处理的数据类型不一样。
 * 因为大多数标准 I/O 操作都使用 ByteBuffer，所以它具有所有共享的缓冲区操作以及一些特有的操作。
 *
 * @author: GuoFei
 * @date: 2022-03-08 11:40
 */
public class UseFloatBuffer {

  public static void main(String[] args) {
    FloatBuffer buffer = FloatBuffer.allocate(10);
    for (int i = 0; i < buffer.capacity(); i++) {
      float f = (float)Math.sin( (((float)i)/10)*(2*Math.PI) );
      buffer.put(f);
    }
    buffer.flip();
    while (buffer.hasRemaining()){
      float v = buffer.get();
      System.out.println(v);
    }
  }

}
