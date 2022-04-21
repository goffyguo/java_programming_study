package com.guofei.base.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author guofei
 * @date 2022/4/12 5:37 PM
 */
public class Server {

  public static void main(String[] args) {
    byte[] buffer = new byte[2014];
    try {
      ServerSocket serverSocket = new ServerSocket(10000);
      while (true) {
        System.out.println();
        System.out.println("服务器正在等待连接...");
        //阻塞1：等待连接时阻塞
        Socket socket = serverSocket.accept();
        System.out.println("服务器已接收到连接请求...");
        System.out.println();
        System.out.println("服务器正在等待数据...");
        //阻塞2：等待数据时阻塞
        socket.getInputStream().read(buffer);
        System.out.println("服务器已经接收到数据");
        System.out.println();
        String content = new String(buffer);
        System.out.println("接收到的数据:" + content);
      }
    } catch (IOException e) {
    }
  }
}
