package com.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 张闯
 * @create 2020-05-03 15:33
 */
public class Client {
    public static void main(String[] args) {
        try {
            //1.创造一个客户端对象Socket,构造方法绑定服务器IP地址和端口号
            Socket socket = new Socket("127.0.0.1", 8088);
            //2.使用socket 对象中的方法获取流
            OutputStream outputStream = socket.getOutputStream();
            //3.使用流向服务端发送数据
            outputStream.write("你好服务器".getBytes());
            InputStream inputStream = socket.getInputStream();
            byte[] b=new byte[1024];
            int read = inputStream.read(b);
            System.out.println(new String(b,0,read));

            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
