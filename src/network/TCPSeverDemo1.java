package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP基本流程
 * 创建服务器：
 * 1.指定端口 使用SeverSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 *
 * 注意：客户端和服务端建立连接的端口要一致
 */
public class TCPSeverDemo1 {
    public static void main(String[] args) throws IOException {
        int severPort = 8888;
        System.out.println("服务器启动....");
        //1.指定端口 使用SeverSocket创建服务器
        ServerSocket sever = new ServerSocket(severPort);

        //2.阻塞式等待连接accept
        Socket client = sever.accept();
        System.out.println("客户端一号成功建立连接....");
/**
 * 服务器端上的使用
 * getInputStream方法得到的是一个输入流，服务端的Socket对象上的getInputStream方法得到的输入流其实就是从客户端发送给服务器端的数据流。
 * getOutputStream方法得到的是一个输出流，服务端的Socket对象上的getOutputStream方法得到的输出流其实就是发送给客户端的数据。
 */
        //3.操作：输入输出流操作
        DataInputStream input = new DataInputStream(client.getInputStream());
        //readUTF()的作用，是从输入流中读取UTF-8编码的数据，并以String字符串的形式返回
        String data = input.readUTF();
        System.out.println(data);

        //4.释放资源
        input.close();  //输出流的关闭
        client.close(); //客户端的关闭
        sever.close();  //服务端的关闭
    }
}
