package com.guofei.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guofei.JsonUtils;
import com.guofei.SimpleRedisMessage;
import java.io.IOException;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import org.msgpack.jackson.dataformat.JsonArrayFormat;
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

    objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.setAnnotationIntrospector(new JsonArrayFormat());

    Person guofei = new Person("1", "guofei", "25");
    byte[] bytes = objectMapper.writeValueAsBytes(guofei);
    System.out.println(bytes); // [-109, -95, 49, -90, 103, 117, 111, 102, 101, 105, -94, 50, 53]
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

    // final String s = byteToString(bytes);
    // System.out.println("压缩后---"+s);
    String s = getString();
    byte[] bytes1 = stringToBytes(s);
    ApiBaseModel deserialized = objectMapper.readValue(bytes1, ApiBaseModel.class);
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

  private static String getString(){
    String s = "hKpyZXR1cm5jb2RlzMinbWVzc2FnZabmiJDlip+mcmVzdWx0hqkyMDIyLTMtMTiS3gA5omlkzgAB\n"
        + "bq2pY2FsZVRpdGxlqeaXoOS4u+mimKdjYWxlRGVzoKliZWdpblRpbWWzMjAyMi0wMy0xOCAyMjox\n"
        + "NTowMadlbmRUaW1lszIwMjItMDMtMTggMjI6MzA6MDCoZGVtb0RhdGHCqGR1cmF0aW9uD6Zyb29t\n"
        + "SWTNGCyocm9vbU5hbWXArXN5bmNSb29tRW1haWygsHN5bmNSb29tSWRlbnRpdHmgrHN5bmNSb29t\n"
        + "TmFtZaCpY29tcGFueUlkzMOrbWVldGluZ1R5cGUErmJlZ2luVGltZVN0YW1wzwAAAX+dYbaIrGVu\n"
        + "ZFRpbWVTdGFtcM8AAAF/nW9uQKpjcmVhdGVUaW1lszIwMjEtMTItMzEgMTc6MjE6MjGqbWVldGlu\n"
        + "Z0Rhec8AAAF/mJt4AKttb2RpZml5VGltZc8AAAF+D8qZ+KVpc0RlbACwY2FsZW5kYXJJZGVudGl0\n"
        + "edknOTAzNWQ5MzgtNDA3Mi00YmNmLTk1MTktN2Q1NDFhYzJjMTY0Xzc4rnVzZXJDYWxlbmRhcklk\n"
        + "oLFyZXF1aXJlZEF0dGVuZGVlc9nBW3siaWQiOjAsImNhbGVuZGFyRXZlbnRJZCI6MCwidXNlcklk\n"
        + "IjowLCJlbWFpbCI6ImxpdXlhbmdAdmlzaW9uLWlvdC5jbyIsImFjY2VwdFN0YXR1cyI6MCwiZGlz\n"
        + "cGxheU5hbWUiOiIiLCJyZXNvdXJjZSI6MCwiY3JlYXRlVGltZSI6bnVsbCwibW9kaWZpeVRpbWUi\n"
        + "Om51bGwsImlzRGVsIjowLCJjaGVja2luIjowLCJwYWdlSWQiOm51bGx9Xalvcmdhbml6ZXK1bGl1\n"
        + "eWFuZ0B2aXNpb24taW90LmNvpnVzZXJJZM0GxahjaGVja0FsbACtbWVldGluZ1N0YXR1cwCxc2Vs\n"
        + "ZkNhbGVuZGFyRXZlbnTCqmVuYWJsZUVkaXQAqHRpbWVab25lrUFzaWEvU2hhbmdoYWmqcm9vbVN0\n"
        + "YXR1cwGocm9vbVR5cGXNA0CqaXNCaW5kWm9vbQCoZ3JvdXBJZHPAsHJlY3VycmluZ0V2ZW50SWTZ\n"
        + "JDkwMzVkOTM4LTQwNzItNGJjZi05NTE5LTdkNTQxYWMyYzE2NK1yZWN1cnJpbmdEYXRlwKZhbGxE\n"
        + "YXkAqG1vbnRoZGF5qTIwMjItMy0xOLFyZWN1cnJlbmNlU2V0dGluZ9mSeyJyZWN1cnJlbmNlRW51\n"
        + "bVR5cGUiOiJEQUlMWSIsImNvdW50IjpudWxsLCJ1bnRpbCI6MTY1NjQ5NDQzNDk0MSwiaW50ZXJ2\n"
        + "YWwiOjAsIndlZWtEYXlzIjpudWxsLCJieU1vbnRoRGF5cyI6bnVsbCwiYnlZZWFyRGF5cyI6bnVs\n"
        + "bCwiYnlNb250eSI6bnVsbH2pcmVtaW5kZXJzoKxyZW1pbmRlckxpc3TApnNvdXJjZQCrY2hlY2tJ\n"
        + "bk5hbWWgqmNhbmNlbFRpbWUAsGJlZ2luQ2hlY2tJblRpbWXPAAABf51K0yiyY2FsZW5kYXJFdmVu\n"
        + "dFJvb21zwKlldmVudFR5cGUBqW9wZW5BcHBseQCrYXBwbHlTdGF0dXMBsWV4dGVybmFsUm9vbXNU\n"
        + "eXBlALRleHRlcm5hbFJvb21zRXZlbnRJZMCsYWRkVGNlbnRNZWV0AbFvcmdhbml6ZXJOaWtlTmFt\n"
        + "Zdkw5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2otmNhbGVu\n"
        + "ZGFyRXZlbnRBdHRlbmRlZXORjKJpZM4AGI1xr2NhbGVuZGFyRXZlbnRJZM4AAW6tpnVzZXJJZM0G\n"
        + "xaVlbWFpbLVsaXV5YW5nQHZpc2lvbi1pb3QuY2+sYWNjZXB0U3RhdHVzAKtkaXNwbGF5TmFtZdkw\n"
        + "5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2oqHJlc291cmNl\n"
        + "AKpjcmVhdGVUaW1lszIwMjEtMTItMzEgMTc6MjE6MjKrbW9kaWZpeVRpbWWzMjAyMS0xMi0zMSAx\n"
        + "NzoyMToyMqVpc0RlbACnY2hlY2tpbgCmcGFnZUlkwK1yZW1vdGVVcGRhdGVkwKluZWVkQ2hlY2vD\n"
        + "r3VwZGF0ZVRpbWVTdGFtcM8AAAF+D8qZ+N4AOaJpZM4AAW9iqWNhbGVUaXRsZaR0ZXN0p2NhbGVE\n"
        + "ZXOgqWJlZ2luVGltZbMyMDIyLTAzLTE4IDIzOjAwOjAxp2VuZFRpbWWzMjAyMi0wMy0xOSAwMTow\n"
        + "MDowMKhkZW1vRGF0YcKoZHVyYXRpb254pnJvb21JZM0YLKhyb29tTmFtZcCtc3luY1Jvb21FbWFp\n"
        + "bKCwc3luY1Jvb21JZGVudGl0eaCsc3luY1Jvb21OYW1loKljb21wYW55SWTMw6ttZWV0aW5nVHlw\n"
        + "ZQSuYmVnaW5UaW1lU3RhbXDPAAABf52K6WisZW5kVGltZVN0YW1wzwAAAX+d+MKAqmNyZWF0ZVRp\n"
        + "bWWzMjAyMS0xMi0zMSAxNzoyODo1MaptZWV0aW5nRGF5zwAAAX+Ym3gAq21vZGlmaXlUaW1lzwAA\n"
        + "AX4P0WBYpWlzRGVsALBjYWxlbmRhcklkZW50aXR52Sc0N2EzZTJhYy1iNTNhLTQ0MTQtOGQxNC0x\n"
        + "NjY0ZmU5M2U3NzhfNziudXNlckNhbGVuZGFySWSgsXJlcXVpcmVkQXR0ZW5kZWVz2cFbeyJpZCI6\n"
        + "MCwiY2FsZW5kYXJFdmVudElkIjowLCJ1c2VySWQiOjAsImVtYWlsIjoibGl1eWFuZ0B2aXNpb24t\n"
        + "aW90LmNvIiwiYWNjZXB0U3RhdHVzIjowLCJkaXNwbGF5TmFtZSI6IiIsInJlc291cmNlIjowLCJj\n"
        + "cmVhdGVUaW1lIjpudWxsLCJtb2RpZml5VGltZSI6bnVsbCwiaXNEZWwiOjAsImNoZWNraW4iOjAs\n"
        + "InBhZ2VJZCI6bnVsbH1dqW9yZ2FuaXplcrVsaXV5YW5nQHZpc2lvbi1pb3QuY2+mdXNlcklkzQbF\n"
        + "qGNoZWNrQWxsAK1tZWV0aW5nU3RhdHVzALFzZWxmQ2FsZW5kYXJFdmVudMKqZW5hYmxlRWRpdACo\n"
        + "dGltZVpvbmWtQXNpYS9TaGFuZ2hhaapyb29tU3RhdHVzAahyb29tVHlwZc0DQKppc0JpbmRab29t\n"
        + "AKhncm91cElkc8CwcmVjdXJyaW5nRXZlbnRJZNkkNDdhM2UyYWMtYjUzYS00NDE0LThkMTQtMTY2\n"
        + "NGZlOTNlNzc4rXJlY3VycmluZ0RhdGXApmFsbERheQCobW9udGhkYXmpMjAyMi0zLTE4sXJlY3Vy\n"
        + "cmVuY2VTZXR0aW5n2ZJ7InJlY3VycmVuY2VFbnVtVHlwZSI6IkRBSUxZIiwiY291bnQiOm51bGws\n"
        + "InVudGlsIjoxNjU2NDk0ODc1NDYzLCJpbnRlcnZhbCI6MCwid2Vla0RheXMiOm51bGwsImJ5TW9u\n"
        + "dGhEYXlzIjpudWxsLCJieVllYXJEYXlzIjpudWxsLCJieU1vbnR5IjpudWxsfalyZW1pbmRlcnOg\n"
        + "rHJlbWluZGVyTGlzdMCmc291cmNlAKtjaGVja0luTmFtZaCqY2FuY2VsVGltZQCwYmVnaW5DaGVj\n"
        + "a0luVGltZc8AAAF/nXQGCLJjYWxlbmRhckV2ZW50Um9vbXPAqWV2ZW50VHlwZQGpb3BlbkFwcGx5\n"
        + "AKthcHBseVN0YXR1cwGxZXh0ZXJuYWxSb29tc1R5cGUAtGV4dGVybmFsUm9vbXNFdmVudElkwKxh\n"
        + "ZGRUY2VudE1lZXQBsW9yZ2FuaXplck5pa2VOYW1l2TDliJjmnajliJjmnajliJjmnajliJjmnajl\n"
        + "iJjmnajliJjmnajliJjmnajliJjmnai2Y2FsZW5kYXJFdmVudEF0dGVuZGVlc5GMomlkzgAYjkGv\n"
        + "Y2FsZW5kYXJFdmVudElkzgABb2KmdXNlcklkzQbFpWVtYWlstWxpdXlhbmdAdmlzaW9uLWlvdC5j\n"
        + "b6xhY2NlcHRTdGF0dXMAq2Rpc3BsYXlOYW1l2TDliJjmnajliJjmnajliJjmnajliJjmnajliJjm\n"
        + "najliJjmnajliJjmnajliJjmnaiocmVzb3VyY2UAqmNyZWF0ZVRpbWWzMjAyMS0xMi0zMSAxNzoy\n"
        + "ODo1Mqttb2RpZml5VGltZbMyMDIxLTEyLTMxIDE3OjI4OjUypWlzRGVsAKdjaGVja2luAKZwYWdl\n"
        + "SWTArXJlbW90ZVVwZGF0ZWTAqW5lZWRDaGVja8OvdXBkYXRlVGltZVN0YW1wzwAAAX4P0WBYqTIw\n"
        + "MjItMy0xM5HeADmiaWTOAAFvUaljYWxlVGl0bGWkdGVzdKdjYWxlRGVzoKliZWdpblRpbWWzMjAy\n"
        + "Mi0wMy0xMyAyMzowMDowMadlbmRUaW1lszIwMjItMDMtMTQgMDE6MDA6MDCoZGVtb0RhdGHCqGR1\n"
        + "cmF0aW9ueKZyb29tSWTNGCyocm9vbU5hbWXArXN5bmNSb29tRW1haWygsHN5bmNSb29tSWRlbnRp\n"
        + "dHmgrHN5bmNSb29tTmFtZaCpY29tcGFueUlkzMOrbWVldGluZ1R5cGUErmJlZ2luVGltZVN0YW1w\n"
        + "zwAAAX+Dyx1orGVuZFRpbWVTdGFtcM8AAAF/hDj2gKpjcmVhdGVUaW1lszIwMjEtMTItMzEgMTc6\n"
        + "Mjg6NDOqbWVldGluZ0Rhec8AAAF/ftusAKttb2RpZml5VGltZc8AAAF+D9FgWKVpc0RlbACwY2Fs\n"
        + "ZW5kYXJJZGVudGl0edknNDdhM2UyYWMtYjUzYS00NDE0LThkMTQtMTY2NGZlOTNlNzc4XzczrnVz\n"
        + "ZXJDYWxlbmRhcklkoLFyZXF1aXJlZEF0dGVuZGVlc9nBW3siaWQiOjAsImNhbGVuZGFyRXZlbnRJ\n"
        + "ZCI6MCwidXNlcklkIjowLCJlbWFpbCI6ImxpdXlhbmdAdmlzaW9uLWlvdC5jbyIsImFjY2VwdFN0\n"
        + "YXR1cyI6MCwiZGlzcGxheU5hbWUiOiIiLCJyZXNvdXJjZSI6MCwiY3JlYXRlVGltZSI6bnVsbCwi\n"
        + "bW9kaWZpeVRpbWUiOm51bGwsImlzRGVsIjowLCJjaGVja2luIjowLCJwYWdlSWQiOm51bGx9Xalv\n"
        + "cmdhbml6ZXK1bGl1eWFuZ0B2aXNpb24taW90LmNvpnVzZXJJZM0GxahjaGVja0FsbACtbWVldGlu\n"
        + "Z1N0YXR1cwCxc2VsZkNhbGVuZGFyRXZlbnTCqmVuYWJsZUVkaXQAqHRpbWVab25lrUFzaWEvU2hh\n"
        + "bmdoYWmqcm9vbVN0YXR1cwGocm9vbVR5cGXNA0CqaXNCaW5kWm9vbQCoZ3JvdXBJZHPAsHJlY3Vy\n"
        + "cmluZ0V2ZW50SWTZJDQ3YTNlMmFjLWI1M2EtNDQxNC04ZDE0LTE2NjRmZTkzZTc3OK1yZWN1cnJp\n"
        + "bmdEYXRlwKZhbGxEYXkAqG1vbnRoZGF5qTIwMjItMy0xM7FyZWN1cnJlbmNlU2V0dGluZ9mSeyJy\n"
        + "ZWN1cnJlbmNlRW51bVR5cGUiOiJEQUlMWSIsImNvdW50IjpudWxsLCJ1bnRpbCI6MTY1NjQ5NDg3\n"
        + "NTQ2MywiaW50ZXJ2YWwiOjAsIndlZWtEYXlzIjpudWxsLCJieU1vbnRoRGF5cyI6bnVsbCwiYnlZ\n"
        + "ZWFyRGF5cyI6bnVsbCwiYnlNb250eSI6bnVsbH2pcmVtaW5kZXJzoKxyZW1pbmRlckxpc3TApnNv\n"
        + "dXJjZQCrY2hlY2tJbk5hbWWgqmNhbmNlbFRpbWUAsGJlZ2luQ2hlY2tJblRpbWXPAAABf4O0Ogiy\n"
        + "Y2FsZW5kYXJFdmVudFJvb21zwKlldmVudFR5cGUBqW9wZW5BcHBseQCrYXBwbHlTdGF0dXMBsWV4\n"
        + "dGVybmFsUm9vbXNUeXBlALRleHRlcm5hbFJvb21zRXZlbnRJZMCsYWRkVGNlbnRNZWV0AbFvcmdh\n"
        + "bml6ZXJOaWtlTmFtZdkw5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o\n"
        + "5YiY5p2otmNhbGVuZGFyRXZlbnRBdHRlbmRlZXORjKJpZM4AGI4xr2NhbGVuZGFyRXZlbnRJZM4A\n"
        + "AW9RpnVzZXJJZM0GxaVlbWFpbLVsaXV5YW5nQHZpc2lvbi1pb3QuY2+sYWNjZXB0U3RhdHVzAKtk\n"
        + "aXNwbGF5TmFtZdkw5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY\n"
        + "5p2oqHJlc291cmNlAKpjcmVhdGVUaW1lszIwMjEtMTItMzEgMTc6Mjg6NDSrbW9kaWZpeVRpbWWz\n"
        + "MjAyMS0xMi0zMSAxNzoyODo0NKVpc0RlbACnY2hlY2tpbgCmcGFnZUlkwK1yZW1vdGVVcGRhdGVk\n"
        + "wKluZWVkQ2hlY2vDr3VwZGF0ZVRpbWVTdGFtcM8AAAF+D9FgWKkyMDIyLTMtMTKT3gA5omlkzgAB\n"
        + "ppypY2FsZVRpdGxlrOWNs+aXtuS8muiurqdjYWxlRGVzoKliZWdpblRpbWWzMjAyMi0wMy0xMiAx\n"
        + "MToyOToyM6dlbmRUaW1lszIwMjItMDMtMTIgMTE6NDQ6MjKoZGVtb0RhdGHCqGR1cmF0aW9uD6Zy\n"
        + "b29tSWTNGCyocm9vbU5hbWXArXN5bmNSb29tRW1haWygsHN5bmNSb29tSWRlbnRpdHmgrHN5bmNS\n"
        + "b29tTmFtZaCpY29tcGFueUlkzMOrbWVldGluZ1R5cGUErmJlZ2luVGltZVN0YW1wzwAAAX98LHa4\n"
        + "rGVuZFRpbWVTdGFtcM8AAAF/fDoucKpjcmVhdGVUaW1lszIwMjItMDMtMTIgMTE6Mjk6MTmqbWVl\n"
        + "dGluZ0Rhec8AAAF/ebVQAKttb2RpZml5VGltZc8AAAF/fCxmmKVpc0RlbACwY2FsZW5kYXJJZGVu\n"
        + "dGl0edkkYWRiNDM5MDYtMGIzMi00NDg1LTkwMGQtYmUxYTI3ZTE0MDlkrnVzZXJDYWxlbmRhcklk\n"
        + "oLFyZXF1aXJlZEF0dGVuZGVlc6JbXalvcmdhbml6ZXKgpnVzZXJJZACoY2hlY2tBbGwBrW1lZXRp\n"
        + "bmdTdGF0dXMAsXNlbGZDYWxlbmRhckV2ZW50wqplbmFibGVFZGl0AKh0aW1lWm9uZa1Bc2lhL1No\n"
        + "YW5naGFpqnJvb21TdGF0dXMBqHJvb21UeXBlzQNAqmlzQmluZFpvb20AqGdyb3VwSWRzwLByZWN1\n"
        + "cnJpbmdFdmVudElkwK1yZWN1cnJpbmdEYXRlwKZhbGxEYXkAqG1vbnRoZGF5qTIwMjItMy0xMrFy\n"
        + "ZWN1cnJlbmNlU2V0dGluZ8CpcmVtaW5kZXJzoKxyZW1pbmRlckxpc3TApnNvdXJjZQKrY2hlY2tJ\n"
        + "bk5hbWWgqmNhbmNlbFRpbWUAsGJlZ2luQ2hlY2tJblRpbWXPAAABf3wVk1iyY2FsZW5kYXJFdmVu\n"
        + "dFJvb21zwKlldmVudFR5cGUAqW9wZW5BcHBseQGrYXBwbHlTdGF0dXMBsWV4dGVybmFsUm9vbXNU\n"
        + "eXBlALRleHRlcm5hbFJvb21zRXZlbnRJZMCsYWRkVGNlbnRNZWV0AbFvcmdhbml6ZXJOaWtlTmFt\n"
        + "ZcC2Y2FsZW5kYXJFdmVudEF0dGVuZGVlc5CtcmVtb3RlVXBkYXRlZMCpbmVlZENoZWNrw691cGRh\n"
        + "dGVUaW1lU3RhbXDPAAABf3wsZpjeADmiaWTOAAFum6ljYWxlVGl0bGWp5peg5Li76aKYp2NhbGVE\n"
        + "ZXOgqWJlZ2luVGltZbMyMDIyLTAzLTEyIDIyOjE1OjAxp2VuZFRpbWWzMjAyMi0wMy0xMiAyMjoz\n"
        + "MDowMKhkZW1vRGF0YcKoZHVyYXRpb24PpnJvb21JZM0YLKhyb29tTmFtZcCtc3luY1Jvb21FbWFp\n"
        + "bKCwc3luY1Jvb21JZGVudGl0eaCsc3luY1Jvb21OYW1loKljb21wYW55SWTMw6ttZWV0aW5nVHlw\n"
        + "ZQSuYmVnaW5UaW1lU3RhbXDPAAABf357joisZW5kVGltZVN0YW1wzwAAAX9+iUZAqmNyZWF0ZVRp\n"
        + "bWWzMjAyMS0xMi0zMSAxNzoyMToxNaptZWV0aW5nRGF5zwAAAX95tVAAq21vZGlmaXlUaW1lzwAA\n"
        + "AX4Pypn4pWlzRGVsALBjYWxlbmRhcklkZW50aXR52Sc5MDM1ZDkzOC00MDcyLTRiY2YtOTUxOS03\n"
        + "ZDU0MWFjMmMxNjRfNzKudXNlckNhbGVuZGFySWSgsXJlcXVpcmVkQXR0ZW5kZWVz2cFbeyJpZCI6\n"
        + "MCwiY2FsZW5kYXJFdmVudElkIjowLCJ1c2VySWQiOjAsImVtYWlsIjoibGl1eWFuZ0B2aXNpb24t\n"
        + "aW90LmNvIiwiYWNjZXB0U3RhdHVzIjowLCJkaXNwbGF5TmFtZSI6IiIsInJlc291cmNlIjowLCJj\n"
        + "cmVhdGVUaW1lIjpudWxsLCJtb2RpZml5VGltZSI6bnVsbCwiaXNEZWwiOjAsImNoZWNraW4iOjAs\n"
        + "InBhZ2VJZCI6bnVsbH1dqW9yZ2FuaXplcrVsaXV5YW5nQHZpc2lvbi1pb3QuY2+mdXNlcklkzQbF\n"
        + "qGNoZWNrQWxsAK1tZWV0aW5nU3RhdHVzALFzZWxmQ2FsZW5kYXJFdmVudMKqZW5hYmxlRWRpdACo\n"
        + "dGltZVpvbmWtQXNpYS9TaGFuZ2hhaapyb29tU3RhdHVzAahyb29tVHlwZc0DQKppc0JpbmRab29t\n"
        + "AKhncm91cElkc8CwcmVjdXJyaW5nRXZlbnRJZNkkOTAzNWQ5MzgtNDA3Mi00YmNmLTk1MTktN2Q1\n"
        + "NDFhYzJjMTY0rXJlY3VycmluZ0RhdGXApmFsbERheQCobW9udGhkYXmpMjAyMi0zLTEysXJlY3Vy\n"
        + "cmVuY2VTZXR0aW5n2ZJ7InJlY3VycmVuY2VFbnVtVHlwZSI6IkRBSUxZIiwiY291bnQiOm51bGws\n"
        + "InVudGlsIjoxNjU2NDk0NDM0OTQxLCJpbnRlcnZhbCI6MCwid2Vla0RheXMiOm51bGwsImJ5TW9u\n"
        + "dGhEYXlzIjpudWxsLCJieVllYXJEYXlzIjpudWxsLCJieU1vbnR5IjpudWxsfalyZW1pbmRlcnOg\n"
        + "rHJlbWluZGVyTGlzdMCmc291cmNlAKtjaGVja0luTmFtZaCqY2FuY2VsVGltZQCwYmVnaW5DaGVj\n"
        + "a0luVGltZc8AAAF/fmSrKLJjYWxlbmRhckV2ZW50Um9vbXPAqWV2ZW50VHlwZQGpb3BlbkFwcGx5\n"
        + "AKthcHBseVN0YXR1cwGxZXh0ZXJuYWxSb29tc1R5cGUAtGV4dGVybmFsUm9vbXNFdmVudElkwKxh\n"
        + "ZGRUY2VudE1lZXQBsW9yZ2FuaXplck5pa2VOYW1l2TDliJjmnajliJjmnajliJjmnajliJjmnajl\n"
        + "iJjmnajliJjmnajliJjmnajliJjmnai2Y2FsZW5kYXJFdmVudEF0dGVuZGVlc5GMomlkzgAYjV+v\n"
        + "Y2FsZW5kYXJFdmVudElkzgABbpumdXNlcklkzQbFpWVtYWlstWxpdXlhbmdAdmlzaW9uLWlvdC5j\n"
        + "b6xhY2NlcHRTdGF0dXMAq2Rpc3BsYXlOYW1l2TDliJjmnajliJjmnajliJjmnajliJjmnajliJjm\n"
        + "najliJjmnajliJjmnajliJjmnaiocmVzb3VyY2UAqmNyZWF0ZVRpbWWzMjAyMS0xMi0zMSAxNzoy\n"
        + "MToxNqttb2RpZml5VGltZbMyMDIxLTEyLTMxIDE3OjIxOjE2pWlzRGVsAKdjaGVja2luAKZwYWdl\n"
        + "SWTArXJlbW90ZVVwZGF0ZWTAqW5lZWRDaGVja8OvdXBkYXRlVGltZVN0YW1wzwAAAX4Pypn43gA5\n"
        + "omlkzgABb06pY2FsZVRpdGxlpHRlc3SnY2FsZURlc6CpYmVnaW5UaW1lszIwMjItMDMtMTIgMjM6\n"
        + "MDA6MDGnZW5kVGltZbMyMDIyLTAzLTEzIDAxOjAwOjAwqGRlbW9EYXRhwqhkdXJhdGlvbnimcm9v\n"
        + "bUlkzRgsqHJvb21OYW1lwK1zeW5jUm9vbUVtYWlsoLBzeW5jUm9vbUlkZW50aXR5oKxzeW5jUm9v\n"
        + "bU5hbWWgqWNvbXBhbnlJZMzDq21lZXRpbmdUeXBlBK5iZWdpblRpbWVTdGFtcM8AAAF/fqTBaKxl\n"
        + "bmRUaW1lU3RhbXDPAAABf38SmoCqY3JlYXRlVGltZbMyMDIxLTEyLTMxIDE3OjI4OjQyqm1lZXRp\n"
        + "bmdEYXnPAAABf3m1UACrbW9kaWZpeVRpbWXPAAABfg/RYFilaXNEZWwAsGNhbGVuZGFySWRlbnRp\n"
        + "dHnZJzQ3YTNlMmFjLWI1M2EtNDQxNC04ZDE0LTE2NjRmZTkzZTc3OF83Mq51c2VyQ2FsZW5kYXJJ\n"
        + "ZKCxcmVxdWlyZWRBdHRlbmRlZXPZwVt7ImlkIjowLCJjYWxlbmRhckV2ZW50SWQiOjAsInVzZXJJ\n"
        + "ZCI6MCwiZW1haWwiOiJsaXV5YW5nQHZpc2lvbi1pb3QuY28iLCJhY2NlcHRTdGF0dXMiOjAsImRp\n"
        + "c3BsYXlOYW1lIjoiIiwicmVzb3VyY2UiOjAsImNyZWF0ZVRpbWUiOm51bGwsIm1vZGlmaXlUaW1l\n"
        + "IjpudWxsLCJpc0RlbCI6MCwiY2hlY2tpbiI6MCwicGFnZUlkIjpudWxsfV2pb3JnYW5pemVytWxp\n"
        + "dXlhbmdAdmlzaW9uLWlvdC5jb6Z1c2VySWTNBsWoY2hlY2tBbGwArW1lZXRpbmdTdGF0dXMAsXNl\n"
        + "bGZDYWxlbmRhckV2ZW50wqplbmFibGVFZGl0AKh0aW1lWm9uZa1Bc2lhL1NoYW5naGFpqnJvb21T\n"
        + "dGF0dXMBqHJvb21UeXBlzQNAqmlzQmluZFpvb20AqGdyb3VwSWRzwLByZWN1cnJpbmdFdmVudElk\n"
        + "2SQ0N2EzZTJhYy1iNTNhLTQ0MTQtOGQxNC0xNjY0ZmU5M2U3NzitcmVjdXJyaW5nRGF0ZcCmYWxs\n"
        + "RGF5AKhtb250aGRheakyMDIyLTMtMTKxcmVjdXJyZW5jZVNldHRpbmfZknsicmVjdXJyZW5jZUVu\n"
        + "dW1UeXBlIjoiREFJTFkiLCJjb3VudCI6bnVsbCwidW50aWwiOjE2NTY0OTQ4NzU0NjMsImludGVy\n"
        + "dmFsIjowLCJ3ZWVrRGF5cyI6bnVsbCwiYnlNb250aERheXMiOm51bGwsImJ5WWVhckRheXMiOm51\n"
        + "bGwsImJ5TW9udHkiOm51bGx9qXJlbWluZGVyc6CscmVtaW5kZXJMaXN0wKZzb3VyY2UAq2NoZWNr\n"
        + "SW5OYW1loKpjYW5jZWxUaW1lALBiZWdpbkNoZWNrSW5UaW1lzwAAAX9+jd4IsmNhbGVuZGFyRXZl\n"
        + "bnRSb29tc8CpZXZlbnRUeXBlAalvcGVuQXBwbHkAq2FwcGx5U3RhdHVzAbFleHRlcm5hbFJvb21z\n"
        + "VHlwZQC0ZXh0ZXJuYWxSb29tc0V2ZW50SWTArGFkZFRjZW50TWVldAGxb3JnYW5pemVyTmlrZU5h\n"
        + "bWXZMOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqLZjYWxl\n"
        + "bmRhckV2ZW50QXR0ZW5kZWVzkYyiaWTOABiOLq9jYWxlbmRhckV2ZW50SWTOAAFvTqZ1c2VySWTN\n"
        + "BsWlZW1haWy1bGl1eWFuZ0B2aXNpb24taW90LmNvrGFjY2VwdFN0YXR1cwCrZGlzcGxheU5hbWXZ\n"
        + "MOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqKhyZXNvdXJj\n"
        + "ZQCqY3JlYXRlVGltZbMyMDIxLTEyLTMxIDE3OjI4OjQzq21vZGlmaXlUaW1lszIwMjEtMTItMzEg\n"
        + "MTc6Mjg6NDOlaXNEZWwAp2NoZWNraW4ApnBhZ2VJZMCtcmVtb3RlVXBkYXRlZMCpbmVlZENoZWNr\n"
        + "w691cGRhdGVUaW1lU3RhbXDPAAABfg/RYFipMjAyMi0zLTE1kt4AOaJpZM4AAW6kqWNhbGVUaXRs\n"
        + "Zanml6DkuLvpopinY2FsZURlc6CpYmVnaW5UaW1lszIwMjItMDMtMTUgMjI6MTU6MDGnZW5kVGlt\n"
        + "ZbMyMDIyLTAzLTE1IDIyOjMwOjAwqGRlbW9EYXRhwqhkdXJhdGlvbg+mcm9vbUlkzRgsqHJvb21O\n"
        + "YW1lwK1zeW5jUm9vbUVtYWlsoLBzeW5jUm9vbUlkZW50aXR5oKxzeW5jUm9vbU5hbWWgqWNvbXBh\n"
        + "bnlJZMzDq21lZXRpbmdUeXBlBK5iZWdpblRpbWVTdGFtcM8AAAF/je6iiKxlbmRUaW1lU3RhbXDP\n"
        + "AAABf438WkCqY3JlYXRlVGltZbMyMDIxLTEyLTMxIDE3OjIxOjE4qm1lZXRpbmdEYXnPAAABf4ko\n"
        + "ZACrbW9kaWZpeVRpbWXPAAABfg/KmfilaXNEZWwAsGNhbGVuZGFySWRlbnRpdHnZJzkwMzVkOTM4\n"
        + "LTQwNzItNGJjZi05NTE5LTdkNTQxYWMyYzE2NF83Na51c2VyQ2FsZW5kYXJJZKCxcmVxdWlyZWRB\n"
        + "dHRlbmRlZXPZwVt7ImlkIjowLCJjYWxlbmRhckV2ZW50SWQiOjAsInVzZXJJZCI6MCwiZW1haWwi\n"
        + "OiJsaXV5YW5nQHZpc2lvbi1pb3QuY28iLCJhY2NlcHRTdGF0dXMiOjAsImRpc3BsYXlOYW1lIjoi\n"
        + "IiwicmVzb3VyY2UiOjAsImNyZWF0ZVRpbWUiOm51bGwsIm1vZGlmaXlUaW1lIjpudWxsLCJpc0Rl\n"
        + "bCI6MCwiY2hlY2tpbiI6MCwicGFnZUlkIjpudWxsfV2pb3JnYW5pemVytWxpdXlhbmdAdmlzaW9u\n"
        + "LWlvdC5jb6Z1c2VySWTNBsWoY2hlY2tBbGwArW1lZXRpbmdTdGF0dXMAsXNlbGZDYWxlbmRhckV2\n"
        + "ZW50wqplbmFibGVFZGl0AKh0aW1lWm9uZa1Bc2lhL1NoYW5naGFpqnJvb21TdGF0dXMBqHJvb21U\n"
        + "eXBlzQNAqmlzQmluZFpvb20AqGdyb3VwSWRzwLByZWN1cnJpbmdFdmVudElk2SQ5MDM1ZDkzOC00\n"
        + "MDcyLTRiY2YtOTUxOS03ZDU0MWFjMmMxNjStcmVjdXJyaW5nRGF0ZcCmYWxsRGF5AKhtb250aGRh\n"
        + "eakyMDIyLTMtMTWxcmVjdXJyZW5jZVNldHRpbmfZknsicmVjdXJyZW5jZUVudW1UeXBlIjoiREFJ\n"
        + "TFkiLCJjb3VudCI6bnVsbCwidW50aWwiOjE2NTY0OTQ0MzQ5NDEsImludGVydmFsIjowLCJ3ZWVr\n"
        + "RGF5cyI6bnVsbCwiYnlNb250aERheXMiOm51bGwsImJ5WWVhckRheXMiOm51bGwsImJ5TW9udHki\n"
        + "Om51bGx9qXJlbWluZGVyc6CscmVtaW5kZXJMaXN0wKZzb3VyY2UAq2NoZWNrSW5OYW1loKpjYW5j\n"
        + "ZWxUaW1lALBiZWdpbkNoZWNrSW5UaW1lzwAAAX+N178osmNhbGVuZGFyRXZlbnRSb29tc8CpZXZl\n"
        + "bnRUeXBlAalvcGVuQXBwbHkAq2FwcGx5U3RhdHVzAbFleHRlcm5hbFJvb21zVHlwZQC0ZXh0ZXJu\n"
        + "YWxSb29tc0V2ZW50SWTArGFkZFRjZW50TWVldAGxb3JnYW5pemVyTmlrZU5hbWXZMOWImOadqOWI\n"
        + "mOadqOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqLZjYWxlbmRhckV2ZW50QXR0\n"
        + "ZW5kZWVzkYyiaWTOABiNaK9jYWxlbmRhckV2ZW50SWTOAAFupKZ1c2VySWTNBsWlZW1haWy1bGl1\n"
        + "eWFuZ0B2aXNpb24taW90LmNvrGFjY2VwdFN0YXR1cwCrZGlzcGxheU5hbWXZMOWImOadqOWImOad\n"
        + "qOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqOWImOadqKhyZXNvdXJjZQCqY3JlYXRlVGlt\n"
        + "ZbMyMDIxLTEyLTMxIDE3OjIxOjE5q21vZGlmaXlUaW1lszIwMjEtMTItMzEgMTc6MjE6MTmlaXNE\n"
        + "ZWwAp2NoZWNraW4ApnBhZ2VJZMCtcmVtb3RlVXBkYXRlZMCpbmVlZENoZWNrw691cGRhdGVUaW1l\n"
        + "U3RhbXDPAAABfg/KmfjeADmiaWTOAAFvV6ljYWxlVGl0bGWkdGVzdKdjYWxlRGVzoKliZWdpblRp\n"
        + "bWWzMjAyMi0wMy0xNSAyMzowMDowMadlbmRUaW1lszIwMjItMDMtMTYgMDE6MDA6MDCoZGVtb0Rh\n"
        + "dGHCqGR1cmF0aW9ueKZyb29tSWTNGCyocm9vbU5hbWXArXN5bmNSb29tRW1haWygsHN5bmNSb29t\n"
        + "SWRlbnRpdHmgrHN5bmNSb29tTmFtZaCpY29tcGFueUlkzMOrbWVldGluZ1R5cGUErmJlZ2luVGlt\n"
        + "ZVN0YW1wzwAAAX+OF9VorGVuZFRpbWVTdGFtcM8AAAF/joWugKpjcmVhdGVUaW1lszIwMjEtMTIt\n"
        + "MzEgMTc6Mjg6NDeqbWVldGluZ0Rhec8AAAF/iShkAKttb2RpZml5VGltZc8AAAF+D9FgWKVpc0Rl\n"
        + "bACwY2FsZW5kYXJJZGVudGl0edknNDdhM2UyYWMtYjUzYS00NDE0LThkMTQtMTY2NGZlOTNlNzc4\n"
        + "Xzc1rnVzZXJDYWxlbmRhcklkoLFyZXF1aXJlZEF0dGVuZGVlc9nBW3siaWQiOjAsImNhbGVuZGFy\n"
        + "RXZlbnRJZCI6MCwidXNlcklkIjowLCJlbWFpbCI6ImxpdXlhbmdAdmlzaW9uLWlvdC5jbyIsImFj\n"
        + "Y2VwdFN0YXR1cyI6MCwiZGlzcGxheU5hbWUiOiIiLCJyZXNvdXJjZSI6MCwiY3JlYXRlVGltZSI6\n"
        + "bnVsbCwibW9kaWZpeVRpbWUiOm51bGwsImlzRGVsIjowLCJjaGVja2luIjowLCJwYWdlSWQiOm51\n"
        + "bGx9Xalvcmdhbml6ZXK1bGl1eWFuZ0B2aXNpb24taW90LmNvpnVzZXJJZM0GxahjaGVja0FsbACt\n"
        + "bWVldGluZ1N0YXR1cwCxc2VsZkNhbGVuZGFyRXZlbnTCqmVuYWJsZUVkaXQAqHRpbWVab25lrUFz\n"
        + "aWEvU2hhbmdoYWmqcm9vbVN0YXR1cwGocm9vbVR5cGXNA0CqaXNCaW5kWm9vbQCoZ3JvdXBJZHPA\n"
        + "sHJlY3VycmluZ0V2ZW50SWTZJDQ3YTNlMmFjLWI1M2EtNDQxNC04ZDE0LTE2NjRmZTkzZTc3OK1y\n"
        + "ZWN1cnJpbmdEYXRlwKZhbGxEYXkAqG1vbnRoZGF5qTIwMjItMy0xNbFyZWN1cnJlbmNlU2V0dGlu\n"
        + "Z9mSeyJyZWN1cnJlbmNlRW51bVR5cGUiOiJEQUlMWSIsImNvdW50IjpudWxsLCJ1bnRpbCI6MTY1\n"
        + "NjQ5NDg3NTQ2MywiaW50ZXJ2YWwiOjAsIndlZWtEYXlzIjpudWxsLCJieU1vbnRoRGF5cyI6bnVs\n"
        + "bCwiYnlZZWFyRGF5cyI6bnVsbCwiYnlNb250eSI6bnVsbH2pcmVtaW5kZXJzoKxyZW1pbmRlckxp\n"
        + "c3TApnNvdXJjZQCrY2hlY2tJbk5hbWWgqmNhbmNlbFRpbWUAsGJlZ2luQ2hlY2tJblRpbWXPAAAB\n"
        + "f44A8giyY2FsZW5kYXJFdmVudFJvb21zwKlldmVudFR5cGUBqW9wZW5BcHBseQCrYXBwbHlTdGF0\n"
        + "dXMBsWV4dGVybmFsUm9vbXNUeXBlALRleHRlcm5hbFJvb21zRXZlbnRJZMCsYWRkVGNlbnRNZWV0\n"
        + "AbFvcmdhbml6ZXJOaWtlTmFtZdkw5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o\n"
        + "5YiY5p2o5YiY5p2otmNhbGVuZGFyRXZlbnRBdHRlbmRlZXORjKJpZM4AGI44r2NhbGVuZGFyRXZl\n"
        + "bnRJZM4AAW9XpnVzZXJJZM0GxaVlbWFpbLVsaXV5YW5nQHZpc2lvbi1pb3QuY2+sYWNjZXB0U3Rh\n"
        + "dHVzAKtkaXNwbGF5TmFtZdkw5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY\n"
        + "5p2o5YiY5p2oqHJlc291cmNlAKpjcmVhdGVUaW1lszIwMjEtMTItMzEgMTc6Mjg6NDirbW9kaWZp\n"
        + "eVRpbWWzMjAyMS0xMi0zMSAxNzoyODo0OKVpc0RlbACnY2hlY2tpbgCmcGFnZUlkwK1yZW1vdGVV\n"
        + "cGRhdGVkwKluZWVkQ2hlY2vDr3VwZGF0ZVRpbWVTdGFtcM8AAAF+D9FgWKkyMDIyLTMtMTSS3gA5\n"
        + "omlkzgABbqGpY2FsZVRpdGxlqeaXoOS4u+mimKdjYWxlRGVzoKliZWdpblRpbWWzMjAyMi0wMy0x\n"
        + "NCAyMjoxNTowMadlbmRUaW1lszIwMjItMDMtMTQgMjI6MzA6MDCoZGVtb0RhdGHCqGR1cmF0aW9u\n"
        + "D6Zyb29tSWTNGCyocm9vbU5hbWXArXN5bmNSb29tRW1haWygsHN5bmNSb29tSWRlbnRpdHmgrHN5\n"
        + "bmNSb29tTmFtZaCpY29tcGFueUlkzMOrbWVldGluZ1R5cGUErmJlZ2luVGltZVN0YW1wzwAAAX+I\n"
        + "yEaIrGVuZFRpbWVTdGFtcM8AAAF/iNX+QKpjcmVhdGVUaW1lszIwMjEtMTItMzEgMTc6MjE6MTeq\n"
        + "bWVldGluZ0Rhec8AAAF/hAIIAKttb2RpZml5VGltZc8AAAF+D8qZ+KVpc0RlbACwY2FsZW5kYXJJ\n"
        + "ZGVudGl0edknOTAzNWQ5MzgtNDA3Mi00YmNmLTk1MTktN2Q1NDFhYzJjMTY0Xzc0rnVzZXJDYWxl\n"
        + "bmRhcklkoLFyZXF1aXJlZEF0dGVuZGVlc9nBW3siaWQiOjAsImNhbGVuZGFyRXZlbnRJZCI6MCwi\n"
        + "dXNlcklkIjowLCJlbWFpbCI6ImxpdXlhbmdAdmlzaW9uLWlvdC5jbyIsImFjY2VwdFN0YXR1cyI6\n"
        + "MCwiZGlzcGxheU5hbWUiOiIiLCJyZXNvdXJjZSI6MCwiY3JlYXRlVGltZSI6bnVsbCwibW9kaWZp\n"
        + "eVRpbWUiOm51bGwsImlzRGVsIjowLCJjaGVja2luIjowLCJwYWdlSWQiOm51bGx9Xalvcmdhbml6\n"
        + "ZXK1bGl1eWFuZ0B2aXNpb24taW90LmNvpnVzZXJJZM0GxahjaGVja0FsbACtbWVldGluZ1N0YXR1\n"
        + "cwCxc2VsZkNhbGVuZGFyRXZlbnTCqmVuYWJsZUVkaXQAqHRpbWVab25lrUFzaWEvU2hhbmdoYWmq\n"
        + "cm9vbVN0YXR1cwGocm9vbVR5cGXNA0CqaXNCaW5kWm9vbQCoZ3JvdXBJZHPAsHJlY3VycmluZ0V2\n"
        + "ZW50SWTZJDkwMzVkOTM4LTQwNzItNGJjZi05NTE5LTdkNTQxYWMyYzE2NK1yZWN1cnJpbmdEYXRl\n"
        + "wKZhbGxEYXkAqG1vbnRoZGF5qTIwMjItMy0xNLFyZWN1cnJlbmNlU2V0dGluZ9mSeyJyZWN1cnJl\n"
        + "bmNlRW51bVR5cGUiOiJEQUlMWSIsImNvdW50IjpudWxsLCJ1bnRpbCI6MTY1NjQ5NDQzNDk0MSwi\n"
        + "aW50ZXJ2YWwiOjAsIndlZWtEYXlzIjpudWxsLCJieU1vbnRoRGF5cyI6bnVsbCwiYnlZZWFyRGF5\n"
        + "cyI6bnVsbCwiYnlNb250eSI6bnVsbH2pcmVtaW5kZXJzoKxyZW1pbmRlckxpc3TApnNvdXJjZQCr\n"
        + "Y2hlY2tJbk5hbWWgqmNhbmNlbFRpbWUAsGJlZ2luQ2hlY2tJblRpbWXPAAABf4ixYyiyY2FsZW5k\n"
        + "YXJFdmVudFJvb21zwKlldmVudFR5cGUBqW9wZW5BcHBseQCrYXBwbHlTdGF0dXMBsWV4dGVybmFs\n"
        + "Um9vbXNUeXBlALRleHRlcm5hbFJvb21zRXZlbnRJZMCsYWRkVGNlbnRNZWV0AbFvcmdhbml6ZXJO\n"
        + "aWtlTmFtZdkw5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o\n"
        + "tmNhbGVuZGFyRXZlbnRBdHRlbmRlZXORjKJpZM4AGI1lr2NhbGVuZGFyRXZlbnRJZM4AAW6hpnVz\n"
        + "ZXJJZM0GxaVlbWFpbLVsaXV5YW5nQHZpc2lvbi1pb3QuY2+sYWNjZXB0U3RhdHVzAKtkaXNwbGF5\n"
        + "TmFtZdkw5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2o5YiY5p2oqHJl\n"
        + "c291cmNlAKpjcmVhdGVUaW1lszIwMjEtMTItMzEgMTc6MjE6MTirbW9kaWZpeVRpbWWzMjAyMS0x\n"
        + "Mi0zMSAxNzoyMToxOKVpc0RlbACnY2hlY2tpbgCmcGFnZUlkwK1yZW1vdGVVcGRhdGVkwKluZWVk\n"
        + "Q2hlY2vDr3VwZGF0ZVRpbWVTdGFtcM8AAAF+D8qZ+N4AOaJpZM4AAW9UqWNhbGVUaXRsZaR0ZXN0\n"
        + "p2NhbGVEZXOgqWJlZ2luVGltZbMyMDIyLTAzLTE0IDIzOjAwOjAxp2VuZFRpbWWzMjAyMi0wMy0x\n"
        + "NSAwMTowMDowMKhkZW1vRGF0YcKoZHVyYXRpb254pnJvb21JZM0YLKhyb29tTmFtZcCtc3luY1Jv\n"
        + "b21FbWFpbKCwc3luY1Jvb21JZGVudGl0eaCsc3luY1Jvb21OYW1loKljb21wYW55SWTMw6ttZWV0\n"
        + "aW5nVHlwZQSuYmVnaW5UaW1lU3RhbXDPAAABf4jxeWisZW5kVGltZVN0YW1wzwAAAX+JX1KAqmNy\n"
        + "ZWF0ZVRpbWWzMjAyMS0xMi0zMSAxNzoyODo0NaptZWV0aW5nRGF5zwAAAX+EAggAq21vZGlmaXlU\n"
        + "aW1lzwAAAX4P0WBYpWlzRGVsALBjYWxlbmRhcklkZW50aXR52Sc0N2EzZTJhYy1iNTNhLTQ0MTQt\n"
        + "OGQxNC0xNjY0ZmU5M2U3NzhfNzSudXNlckNhbGVuZGFySWSgsXJlcXVpcmVkQXR0ZW5kZWVz2cFb\n"
        + "eyJpZCI6MCwiY2FsZW5kYXJFdmVudElkIjowLCJ1c2VySWQiOjAsImVtYWlsIjoibGl1eWFuZ0B2\n"
        + "aXNpb24taW90LmNvIiwiYWNjZXB0U3RhdHVzIjowLCJkaXNwbGF5TmFtZSI6IiIsInJlc291cmNl\n"
        + "IjowLCJjcmVhdGVUaW1lIjpudWxsLCJtb2RpZml5VGltZSI6bnVsbCwiaXNEZWwiOjAsImNoZWNr\n"
        + "aW4iOjAsInBhZ2VJZCI6bnVsbH1dqW9yZ2FuaXplcrVsaXV5YW5nQHZpc2lvbi1pb3QuY2+mdXNl\n"
        + "cklkzQbFqGNoZWNrQWxsAK1tZWV0aW5nU3RhdHVzALFzZWxmQ2FsZW5kYXJFdmVudMKqZW5hYmxl\n"
        + "RWRpdACodGltZVpvbmWtQXNpYS9TaGFuZ2hhaapyb29tU3RhdHVzAahy";
    return s;
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
