package com.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张闯
 * @create 2020-05-03 15:48
 */
public class TcpServer {
    public static void main(String[] args) {
        try {


            //1.创建服务器对象，指定端口
            ServerSocket serverSocket = new ServerSocket(8088);
            //2.使用serverSocket对象中的方法accent 获取请求的socket 对象
            Socket accept = serverSocket.accept();
            //3.使用套接字对象获取流
            InputStream inputStream = accept.getInputStream();
            //4.读取流
            byte[] b = new byte[1024];
            int read = inputStream.read(b);
            System.out.println(new String(b, 0, read));
            //5.将数据回写到客户端
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("收到谢谢!!!".getBytes());
            accept.close();
            serverSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
