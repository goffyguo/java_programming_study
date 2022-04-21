package com.guofei.other.compress.example;

import java.io.IOException;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;

/**
 * @author: GuoFei
 * @date: 2022-03-12 18:52
 */
public class MessagePackExample4 {

  public static void main(String[] args) throws IOException {
    encodeWithMsgPack("sssssssssss");
  }

  public static byte[] encodeWithMsgPack(String obj) throws IOException {
    byte[] byteStr = obj.getBytes();
    System.out.println("Original size: " + byteStr.length);
    MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
    packer.packString(obj);
    packer.close();
    byte[] msgPackByte = packer.toByteArray();
    System.out.println("Message pack size " + msgPackByte.length);
    return msgPackByte;
  }

}
