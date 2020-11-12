package network;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/**
 * 文件上传
 * 创建客户端
 * 1.建立连接 ：使用Socket创建客户端+服务的地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 */
public class TCPClientDemo4 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动....");
        int clientPort = 8888;
        //1.建立连接：使用Socket创建客户端+服务地址和端口
        Socket client = new Socket("localhost",clientPort);

        //2.操作：输入输出流操作
        InputStream input = new BufferedInputStream(
                new URL("https://img.zcool.cn/community/0173585fa" +
                        "902c811013ee04d85abf9.jpg@1280w_1l_2o_100sh.jpg").openStream());
        OutputStream output = new BufferedOutputStream(client.getOutputStream());
        byte[] flush = new byte[1024];
        int length = -1;
        while ((length = input.read(flush)) != -1){
            output.write(flush,0,length);
        }
        output.flush();
        System.out.println("文件上传成功.....");

        //3.释放资源
        input.close();
        output.close();
        client.close();
    }
}
