package network;

import java.io.*;
import java.net.Socket;

/**
 * 模拟登录 多个客户端请求 (使用面向对象的方法，将客户端四年包装成一个类)
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端+服务地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 */
public class TCPClientDemo6 {
    Socket client;
    int clientPort;
    DataOutputStream output;
    DataInputStream input;

    //构造器
    public TCPClientDemo6(Socket client, int clientPort) {
        this.client = client;
        this.clientPort = clientPort;
    }

    //创建一个完整的客户端的方法
    public void TCPClient() throws IOException{
        System.out.println("客户端启动....");

        //1.建立连接：使用Socket创建客户端+服务地址和端口
        client = new Socket("localhost",this.clientPort);

        //2.登录操作，写入用户名密码
        String UserData = User();

        //3.发送数据
        send(UserData);

        //4.接收数据
        System.out.print(receive());

        //5.释放资源
        ClientClose();
    }

    //登录操作，写入用户名密码
    public String User() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名：");
        String UserName = reader.readLine();
        System.out.print("请输入用户密码：");
        String UserPassword = reader.readLine();
        String UserData = "UserName = "+UserName+" & "+"UserPassword = "+UserPassword;
        return UserData;
    }

    //发送数据的方法
    public void send(String UserData) throws IOException {
        this.output = new DataOutputStream(this.client.getOutputStream());
        this.output.flush();
        this.output.writeUTF(UserData);
    }

    //接收数据
    public String receive() throws IOException {
        this.input = new DataInputStream(this.client.getInputStream());
        return this.input.readUTF();
    }

    //释放资源
    public void ClientClose() throws IOException {
        this.input.close();
        this.output.close();
        this.client.close();
    }
}
