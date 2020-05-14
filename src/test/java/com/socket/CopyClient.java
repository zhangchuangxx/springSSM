package com.socket;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 张闯
 * @create 2020-05-03 17:53
 */
 /*
    文件上传：
    实现步骤：
    1.创建一个本地输入字节流FileInputStream对象，构造方法填入数据源
    2.创建一个客户端Socket对象，绑定服务端IP地址端口号
    3.使用Socket对象获取流，输出outputStream对象
    4.使用本地字节流FileInputStream中的read方法，读取文件数据。
    5.使用网络输出流outputStream,使用write方法把数据写到服务端
    6.用于Socket对象获取输入流对象
    7.使用网络输入流InputStream对象，read方法读取服务端回写数据
    8.释放资源
     */
public class CopyClient {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Downloads\\2.mp4");
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream outputStream = socket.getOutputStream();
            int leng=0;
            byte[] b=new byte[1024];
            while ((leng=fileInputStream.read(b))!=-1){
                outputStream.write(b,0,leng);
            }
           /* InputStream inputStream = socket.getInputStream();
            int l=inputStream.read(b);
                System.out.println(new String(b, 0, l));
            System.out.println("上传成功");*/
            InputStream inputStream = socket.getInputStream();
            byte[] b1=new byte[1024];
            System.out.println("上传成功");
            int read =0;
            while ((read=inputStream.read(b1))!=-1) {
                System.out.println(new String(b1, 0, read));
            }

         fileInputStream.close();
            socket.close();
        }catch (Exception e){

        }
    }
}
