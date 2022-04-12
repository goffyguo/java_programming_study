package com.guofei.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author guofei
 * @date 2022/4/12 5:39 PM
 */
public class Client {

  public static void main(String[] args) {
    try {
      Socket socket = new Socket("127.0.0.1", 10000);
      //socket.getOutputStream().write("向服务器发数据".getBytes());
      String message = null;
      Scanner scanner = new Scanner(System.in);
      message = scanner.next();
      socket.getOutputStream().write(message.getBytes());
      socket.close();
      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
