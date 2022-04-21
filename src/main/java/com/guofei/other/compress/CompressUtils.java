package com.guofei.other.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author: GuoFei
 * @date: 2022-03-13 19:18
 */
public class CompressUtils {


  /**
   * 压缩
   * @param str
   * @return
   * @throws IOException
   */
  public static String compress(String str) throws IOException {
    if (str == null || str.length() == 0) {
      return str;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    GZIPOutputStream gzip = new GZIPOutputStream(out);
    gzip.write(str.getBytes());
    gzip.close();
    return out.toString("ISO-8859-1");
  }



  /**
   * 压缩
   * @param bytes
   * @return
   * @throws IOException
   */
  public static byte[] compressByte(byte[] bytes) throws IOException {
    if (bytes == null || bytes.length == 0) {
      return bytes;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    GZIPOutputStream gzip = new GZIPOutputStream(out);
    gzip.write(bytes);
    gzip.close();
    return out.toByteArray();
  }

  /**
   * 解压缩
   * @param bytes
   * @return
   * @throws IOException
   */
  public static byte[] uncompressByte(byte[] bytes) throws IOException {
    if (bytes == null || bytes.length == 0) {
      return bytes;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ByteArrayInputStream in = new ByteArrayInputStream(bytes);
    GZIPInputStream gunzip = new GZIPInputStream(in);
    byte[] buffer = new byte[256];
    int n;
    while ((n = gunzip.read(buffer)) >= 0) {
      out.write(buffer, 0, n);
    }
    // toString()使用平台默认编码，也可以显式的指定如toString(&quot;GBK&quot;)
    return out.toByteArray();
  }

  /**
   * 解压缩
   * @param str
   * @return
   * @throws IOException
   */
  public static String uncompress(String str) throws IOException {
    if (str == null || str.length() == 0) {
      return str;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ByteArrayInputStream in = new ByteArrayInputStream(str
        .getBytes("ISO-8859-1"));
    GZIPInputStream gunzip = new GZIPInputStream(in);
    byte[] buffer = new byte[256];
    int n;
    while ((n = gunzip.read(buffer)) >= 0) {
      out.write(buffer, 0, n);
    }
    // toString()使用平台默认编码，也可以显式的指定如toString(&quot;GBK&quot;)
    return out.toString();
  }


}
