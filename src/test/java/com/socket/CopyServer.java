package com.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张闯
 * @create 2020-05-03 17:53
 */
public class CopyServer {
    /*
    文件上传：
    实现步骤：
    1.创建一个ServerSocket服务对象，明确端口号
    2.使用accept方法，获取客户端socket对象
    3.使用Socket对象获取流，输出InputStream对象
    4.判断c:\\upload是否存在，如果没有就创建
    5.创建本地字节流FileOutputStream，构造方法中明确目标数据源。
    6.用于Socket对象获取输出流对象，inputStream read方法
    7.使用本地字节流FileOutStream，write方法把流数据持久化到硬盘上
    7.使用网络输入流InputStream对象，read方法读取服务端回写数据
    8.释放资源
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            File file=new File("c:\\upload");
            if(!file.exists()){
                file.mkdir();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file+"\\2.mp4");
            int l=0;
            byte[] b=new byte[1024];
            while ((l=inputStream.read(b))!=-1){
                fileOutputStream.write(b,0,l);
            }
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("上传成功".getBytes());
            fileOutputStream.close();
            accept.close();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
