package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 双向
 * 创建服务器
 * 1.指定端口 使用SeverSocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 */
public class TCPSeverDemo3 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动....");
        int severPort = 8888;
        //1.指定端口 使用SeverSocket创建服务器
        ServerSocket sever = new ServerSocket(severPort);

        //2.阻塞式等待连接
        Socket client = sever.accept();
        System.out.println("客户端一号成功建立连接....");

        //3.操作：输入输出流操作
        DataInputStream input = new DataInputStream(client.getInputStream());
        String data = input.readUTF();
        String[] UserData = data.split(" & ");
        String[] user = new String[2];
        int i = 0;
        for (String s : UserData){
            String[] d = s.split(" = ");
            user[i++] = d[1];
            System.out.println(d[0]+"---->"+d[1]);
        }
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        //对客户端的用户信息进行判断
        if (user[0].equals("王梦婷") && user[1].equals("mengmengmeng0501")){
            output.writeUTF("登录成功，欢迎回来....");
        }else {
            output.writeUTF("用户名或者密码错误，请确认后重新登录....");
        }
        output.flush();

        //4.释放资源
        input.close();
        output.close();
        client.close();
        sever.close();
    }
}
