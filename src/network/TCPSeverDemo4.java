package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件接收
 * 创建服务器
 * 1.指定端口 使用SeverSocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 */
public class TCPSeverDemo4 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动....");
        int severPort = 8888;
        //1.指定端口 使用SeverSocket创建服务器
        ServerSocket sever = new ServerSocket(severPort);

        //2.阻塞式等待连接 accept
        Socket client = sever.accept();
        System.out.println("客户端一号成功连接....");

        //3.操作：输入输出流操作
        OutputStream output = new BufferedOutputStream(
                new FileOutputStream("D:/github上传的文件/JavaTxtSet/2020_11_12.png"));
        InputStream input = new BufferedInputStream(client.getInputStream());
        byte[] flush = new byte[1024];
        int length = -1;
        while ((length = input.read(flush)) != -1){
            output.write(flush,0,length);
        }
        output.flush();
        System.out.println("文件接收成功....");

        //4.释放资源
        input.close();
        output.close();
        client.close();
        sever.close();

    }
}
