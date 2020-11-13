package network.Char;

/**
 * 创建聊天室：
 * 创建聊天室客户端类：
 */

import java.io.*;
import java.net.Socket;

/**
 * 模拟登录 多个客户端请求 (使用面向对象的方法，将客户端四年包装成一个类)
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端+服务地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 */
public class ChatClient {

    private Socket client;


    private DataOutputStream output = null;

    private DataInputStream input = null;

    private String name;


    //构造器
    public ChatClient(int serverPort, String name) throws IOException {
        this.name = name;
        //1.使用Socket创建客户端+服务地址和端口
        this.client = new Socket("localhost", serverPort);
    }

    //完整客户端功能的方法
    public void start() {
        System.out.println("--------客户端启动--------");

        // 写入数据
        new Thread(new Send(client,name)).start();

        // 接收数据
        new Thread(new Receive(client)).start();

    }

    //4.释放资源
    public void Close() throws IOException{
        //使用封装的思想创建工具类实现资源的释放
        ChatUtils.close(input,output,client);
        System.out.println("--------资源释放完毕--------");
    }

}
