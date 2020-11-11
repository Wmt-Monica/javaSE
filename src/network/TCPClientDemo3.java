package network;

import java.io.*;
import java.net.Socket;

/**
 * 模拟登录 双向
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端+服务的地址和端口
 * 2.操作：输入输出流操作
 * 3.登入前的输入用户名和用户密码的操作
 * 4.释放资源
 */
public class TCPClientDemo3 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动....");
        int clientPort = 8888;

        //3.登入前的输入用户名和用户密码的操作
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名：");
        String UserName = reader.readLine();
        System.out.print("请输入用户密码：");
        String UserPassword = reader.readLine();

        //1.建立连接：使用Socket创建客户端+服务的地址和端口
        Socket client = new Socket("localhost",clientPort);

        //2.操作：输入输出流操作
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        String UserData = "UserData = "+UserName+" & "+"UserPassword = "+UserPassword;
        output.writeUTF(UserData);

        DataInputStream input = new DataInputStream(client.getInputStream());
        String data = input.readUTF();
        System.out.println(data);

        //4.释放资源
        output.close();
        client.close();
    }
}
