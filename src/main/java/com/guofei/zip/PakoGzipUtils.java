package com.guofei.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author: GuoFei
 * @date: 2022-03-11 15:09
 */
public class PakoGzipUtils {

  public static String compress(String str)throws IOException {
    if (str ==null || str.length() ==0) {
      return str;
    }
    ByteArrayOutputStream out =new ByteArrayOutputStream();
    GZIPOutputStream gzip =new GZIPOutputStream(out);
    gzip.write(str.getBytes());
    gzip.close();
    return out.toString("ISO-8859-1");
  }


  public static String compress2(String primStr) {
    if (primStr == null || primStr.length() == 0) {
      return primStr;
    }

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    GZIPOutputStream gzip=null;
    try {
      gzip = new GZIPOutputStream(out);
      gzip.write(primStr.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }finally{
      if(gzip!=null){
        try {
          gzip.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return new sun.misc.BASE64Encoder().encode(out.toByteArray());
  }
  public static final String compress3(String str) {
    if (str == null) {
      return null;
    }
    byte[] compressed;
    ByteArrayOutputStream out = null;
    ZipOutputStream zout = null;
    String compressedStr = null;
    try {
      out = new ByteArrayOutputStream();
      zout = new ZipOutputStream(out);
      zout.putNextEntry(new ZipEntry("0"));
      zout.write(str.getBytes());
      zout.closeEntry();
      compressed = out.toByteArray();
      compressedStr = new sun.misc.BASE64Encoder().encodeBuffer(compressed);
    } catch (IOException e) {
      compressed = null;
    } finally {
      if (zout != null) {
        try {
          zout.close();
        } catch (IOException e) {
        }
      }
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
        }
      }
    }
    return compressedStr;
  }


}
