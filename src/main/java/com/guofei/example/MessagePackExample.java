package com.guofei.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guofei.JsonUtils;
import com.guofei.SimpleRedisMessage;
import java.io.IOException;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

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
    /*for (byte aByte : bytes) {
      System.out.println(aByte);
    }*/
    // final String s = bytes.toString();
    /*System.out.println(bytes2Hex(bytes));

    System.out.println("---------------------------");
    Person deserialized = objectMapper.readValue(bytes, Person.class);
    System.out.println(deserialized.toString());*/
    /*final String s = JsonUtils.toString(guofei);
    System.out.println(objectMapper.writeValueAsBytes(s));*/
    //System.out.println(s1);
    /*SimpleRedisMessage simpleRedisMessage = new SimpleRedisMessage();
    simpleRedisMessage.setData(bytes);
    //System.out.println(simpleRedisMessage.toString());
    Object data = simpleRedisMessage.getData();
    System.out.println(data);
    SimpleRedisMessage deserialized = objectMapper.readValue(bytes, SimpleRedisMessage.class);
    System.out.println(deserialized.getData());*/

    final String s = byteToString(bytes);
    System.out.println("压缩后---"+s);
    byte[] bytes1 = stringToBytes(s);
    Person deserialized = objectMapper.readValue(bytes1, Person.class);
    System.out.println("解压缩后---"+deserialized.toString());
  }

  public static String byteToString(byte [] bytes){
    return new BASE64Encoder().encodeBuffer(bytes);
  }
  public static byte [] stringToBytes(String  string) throws IOException {
    return new BASE64Decoder().decodeBuffer(string);
  }

  public static String bytes2Hex(byte[] src){
    if (src == null || src.length <= 0) {
      return null;
    }

    StringBuilder stringBuilder = new StringBuilder("");
    for (int i = 0; i < src.length; i++) {
      // 之所以用byte和0xff相与，是因为int是32位，与0xff相与后就舍弃前面的24位，只保留后8位
      String str = Integer.toHexString(src[i] & 0xff);
      if (str.length() < 2) { // 不足两位要补0
        stringBuilder.append(0);
      }
      stringBuilder.append(str);
    }
    return stringBuilder.toString();
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
