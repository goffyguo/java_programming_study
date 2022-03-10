package com.guofei.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import org.msgpack.jackson.dataformat.MessagePackFactory;

/**
 * @author: GuoFei
 * @date: 2022-03-08 18:40
 */
public class MessagePackExample {

  public static void main(String[] args) throws IOException {
    //basicUsage();
    // MessagePack pack = new MessagePack();
    ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory());
    Person guofei = new Person("1", "guofei", "25");
    byte[] bytes = objectMapper.writeValueAsBytes(guofei);
    for (byte aByte : bytes) {
      System.out.println(aByte);
    }

    System.out.println("---------------------------");
    Person deserialized = objectMapper.readValue(bytes, Person.class);
    System.out.println(deserialized.toString());
  }















  /**
   * Basic usage example
   *
   * @throws IOException
   */
  public static void basicUsage() throws IOException {
    // Serialize with MessagePacker.
    // MessageBufferPacker is an optimized version of MessagePacker for packing data into a byte array
    MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
    packer
        .packInt(1)
        .packString("leo")
        .packArrayHeader(2)
        .packString("xxx-xxxx")
        .packString("yyy-yyyy");
    packer.close(); // Never forget to close (or flush) the buffer

    // Deserialize with MessageUnpacker
    MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(packer.toByteArray());
    int id = unpacker.unpackInt();             // 1
    String name = unpacker.unpackString();     // "leo"
    int numPhones = unpacker.unpackArrayHeader();  // 2
    String[] phones = new String[numPhones];
    for (int i = 0; i < numPhones; ++i) {
      phones[i] = unpacker.unpackString();   // phones = {"xxx-xxxx", "yyy-yyyy"}
    }
    unpacker.close();

    System.out.println(String.format("id:%d, name:%s, phone:[%s]", id, name, join(phones)));
  }

  private static String join(String[] in) {
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
