package com.guofei.zip;

import java.io.IOException;

/**
 * @author: GuoFei
 * @date: 2022-03-11 15:10
 */
public class ZipTestMain {

  public static void main(String[] args) throws IOException {
      pakoGzipTest();
  }

  public static String pakoGzipTest()throws IOException {

    // 字符串超过一定的长度

     StringBuilder sb =new StringBuilder();

    sb.append("<section style=\"box-sizing: border-box; text-align: justify;\"><section style=\"position: static; box-sizing: border-box;\" powered-by=\"xiumi.us\">");

    sb.append("<section style=\"text-align: center; margin: -10px 0% 10px; position: static; box-sizing: border-box;\"><section style=\"max-width: 100%; vertical-align: middle; display: ");

    sb.append("inline-block; line-height: 0; width: 95%; box-sizing: border-box;\">");

    sb.append("测试Java的GZIP压缩字符串，在前端js中使用pako解压还原</span></p>");

    String str=sb.toString();

    System.out.println("原始字符串长度："+str.length());

    String zip = PakoGzipUtils.compress3(str);

    System.out.println("压缩之后的字符串前100："+zip.substring(0,100));

    System.out.println("压缩编码后字符串长度："+zip.length());

    System.out.println("压缩比："+(float)zip.length()/(float)str.length());

    return zip;
  }

}
