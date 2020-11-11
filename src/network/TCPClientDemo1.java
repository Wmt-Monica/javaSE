package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * TCP基本流程;
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端+服务的地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 *
 * 注意：客户端和服务端建立连接的端口要一致
 */
public class TCPClientDemo1 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动....");
        int clientPort = 8888;
        //1.建立连接：使用Socket创建客户端+服务的地址和端口
        Socket client = new Socket("localhost",clientPort);
/**
 * 客户端上的使用
 * getInputStream方法可以得到一个输入流，客户端的Socket对象上的getInputStream方法得到输入流其实就是从服务器端发回的数据。
 * getOutputStream方法得到的是一个输出流，客户端的Socket对象上的getOutputStream方法得到的输出流其实就是发送给服务器端的数据。
 */
        //2.操作：输入输出流操作
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        //writeUTF()方法的作用是将字符串转成UTF-8编码的数据
        output.writeUTF(data);
        output.flush();  //写完数据后一定要记得刷新

        //3.释放资源
        output.close();  //输出流的关闭
        client.close();  //客户端释放资源
    }
}
