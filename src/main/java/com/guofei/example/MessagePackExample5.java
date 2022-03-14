package com.guofei.example;

import cn.hutool.json.JSONUtil;
import com.guofei.JsonUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import sun.misc.BASE64Decoder;

/**
 * @author: GuoFei
 * @date: 2022-03-14 16:39
 */
public class MessagePackExample5 {

  public static void main(String[] args) throws IOException {
    MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
    String s = JsonUtils.toString(getMap2());
    final byte[] bytes = stringToBytes(s);
    packer.packBinaryHeader(bytes.length);
    packer.writePayload(bytes);
    packer.close();
    //packer.



  }


  public static byte [] stringToBytes(String  string) throws IOException {
    return new BASE64Decoder().decodeBuffer(string);
  }

  private static Object getMap2(){
    Map<String,Object> map =new HashMap();
    map.put("k1",11);
    map.put("k2",22);
    return map;
  }
}
