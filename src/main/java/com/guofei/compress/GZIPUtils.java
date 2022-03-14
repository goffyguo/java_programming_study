package com.guofei.compress;

import com.guofei.JsonUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Encoder;

/**
 * @author: GuoFei
 * @date: 2022-03-14 10:17
 */
@Slf4j
public class GZIPUtils {
  public static final String GZIP_ENCODE_UTF_8 = "UTF-8";
  public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";


  public static byte[] compress(String str, String encoding) {
    if (str == null || str.length() == 0) {
      return null;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    GZIPOutputStream gzip;
    try {
      gzip = new GZIPOutputStream(out);
      gzip.write(str.getBytes(encoding));
      gzip.close();
    } catch ( Exception e) {
      e.printStackTrace();
    }
    return out.toByteArray();
  }

  public static byte[] compress(String str) throws IOException {
    return compress(str, GZIP_ENCODE_UTF_8);
  }

  public static byte[] uncompress(byte[] bytes) {
    if (bytes == null || bytes.length == 0) {
      return null;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ByteArrayInputStream in = new ByteArrayInputStream(bytes);
    try {
      GZIPInputStream ungzip = new GZIPInputStream(in);
      byte[] buffer = new byte[256];
      int n;
      while ((n = ungzip.read(buffer)) >= 0) {
        out.write(buffer, 0, n);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return out.toByteArray();
  }

  public static String uncompressToString(byte[] bytes, String encoding) {
    if (bytes == null || bytes.length == 0) {
      return null;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ByteArrayInputStream in = new ByteArrayInputStream(bytes);
    try {
      GZIPInputStream ungzip = new GZIPInputStream(in);
      byte[] buffer = new byte[256];
      int n;
      while ((n = ungzip.read(buffer)) >= 0) {
        out.write(buffer, 0, n);
      }
      return out.toString(encoding);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String uncompressToString(byte[] bytes) {
    return uncompressToString(bytes, GZIP_ENCODE_UTF_8);
  }

  public static void main(String[] args) throws IOException {
    String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    System.out.println("字符串长度："+s.length());
    System.out.println("压缩后：："+compress(s).length);
    System.out.println("解压后："+uncompress(compress(s)).length);
    System.out.println("解压字符串后：："+uncompressToString(compress(s)).length());
  }


  public static String gzip(String data) throws Exception {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    GZIPOutputStream gzip = new GZIPOutputStream(out);
    gzip.write(data.getBytes());
    gzip.close();
    byte[] bytes = out.toByteArray();
    return new BASE64Encoder().encodeBuffer(bytes);
  }

  public static String gzip2(Object data) throws Exception {
    System.out.println("JsonUtils"+JsonUtils.toString(data));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    GZIPOutputStream gzip = new GZIPOutputStream(out);
    gzip.write(JsonUtils.toString(data).getBytes());
    gzip.close();
    byte[] bytes = out.toByteArray();
    return new BASE64Encoder().encodeBuffer(bytes);
  }

  public static String gunzip(String compressedStr) {
    String str = null;
    if (!StringUtils.isEmpty(compressedStr)) {
      try (
          ByteArrayOutputStream out = new ByteArrayOutputStream();

          ByteArrayInputStream in = new ByteArrayInputStream(Base64.decodeBase64(compressedStr));

          GZIPInputStream ginzip = new GZIPInputStream(in)
      ) {
        byte[] buf = new byte[1024];
        int offset = -1;
        while (-1 != (offset = ginzip.read(buf))) {
          out.write(buf, 0, offset);
        }
        out.flush();
        str = out.toString();
      } catch (IOException e) {
        log.error("gzip解压失败，原因如下：{}", e.getMessage(), e);
      }
    }
    return str;
  }
}
