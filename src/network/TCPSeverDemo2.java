package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 单向
 * 创建服务器
 * 1.指定端口 使用ServerSocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 */
public class TCPSeverDemo2 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动....");
        int severPort = 8888;
        //1.指定端口 使用SeverSocket创建服务器
        ServerSocket sever = new ServerSocket(severPort);

        //2.阻塞式等待连接 accept
        Socket client = sever.accept();
        System.out.println("客户端一号成功建立连接....");

        //3.操作：输入输出流操作
        DataInputStream input = new DataInputStream(client.getInputStream());
        String data = input.readUTF();  //获取从客户端读取到的数据
        String[] UserData = data.split(" & ");  //将从客户端获取到的用户信息通过 & 分隔符分开存入字符串数组中
        for (String s : UserData){
            //在对获取的数据进行分割
            String[] d = s.split(" = ");
            System.out.println(d[0]+"---->"+d[1]);
        }

        //4.释放资源
        input.close();
        client.close();
        sever.close();
    }
}
