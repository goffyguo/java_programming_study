package com.guofei.example;

import java.io.IOException;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import sun.misc.BASE64Encoder;

/**
 * @author: GuoFei
 * @date: 2022-03-12 17:23
 */
public class MessagePackExample3 {

  public static void main(String[] args) throws IOException {
    Person guofei = new Person("1", "guofei", "25");
    MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
    packer

        .packString(guofei.getId())
        .packString(guofei.getName())
        .packString(guofei.getAge());
    packer.close(); // Never forget to close (or flush) the buffer
    byte[] bytes = packer.toByteArray(); // [-95, 49, -90, 103, 117, 111, 102, 101, 105, -94, 50, 53]
    System.out.println(guofei.toString().length());
    System.out.println(byteToString(bytes).length());
    // Deserialize with MessageUnpackers
    /*MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(packer.toByteArray());
    int id = unpacker.unpackInt();             // 1
    String name = unpacker.unpackString();     // "leo"
    int numPhones = unpacker.unpackArrayHeader();  // 2
    String[] phones = new String[numPhones];
    for (int i = 0; i < numPhones; ++i) {
      phones[i] = unpacker.unpackString();   // phones = {"xxx-xxxx", "yyy-yyyy"}
    }
    unpacker.close();

    System.out.println(String.format("id:%d, name:%s, phone:[%s]", id, name, join(phones)));*/
  }


  public static String byteToString(byte [] bytes){
    return new BASE64Encoder().encodeBuffer(bytes);
  }

  private static String join(String[] in)
  {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < in.length; ++i) {
      if (i > 0) {
        s.append(", ");
      }
      s.append(in[i]);
    }
    return s.toString();
  }

}
