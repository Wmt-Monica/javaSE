package network;

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
public class CharRoomClientClass {
    private Socket client;
    private int clientPort;
    private DataOutputStream output = null;
    private DataInputStream input = null;
    private String name;


    //构造器
    public CharRoomClientClass(Socket client, int clientPort,String name) throws IOException {
        this.name = name;
        this.clientPort = clientPort;
        //1.使用Socket创建客户端+服务地址和端口
        this.client = new Socket("localhost",clientPort);
    }

    //完整客户端功能的方法
    public void CharClient() throws IOException {
        System.out.println("--------客户端启动--------");
        boolean flag = true;
        while (flag){
            //写入数据发送
            send();

            //接收数据
            String data = receive();

            if (data.equals("bye")){
                //释放资源
                Close();
                break;
            }
        }
    }

    //2.操作：输入输出流操作
    //发送数据
    public void send() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data1 = reader.readLine();  //从控制台写入数据
        String data2 = name+ " & "+data1;
        output = new DataOutputStream(client.getOutputStream());  //写入的方向指向服务端
        output.flush();  //写入数据前，进行刷新
        output.writeUTF(data2);  //将写入控制台的数据发送给服务器
    }

    //接收数据
    public String receive() throws IOException{
        input = new DataInputStream(client.getInputStream());  //从服务端接收数据
        String data = input.readUTF();
        System.out.println(data);
        return data;
    }

    //4.释放资源
    public void Close() throws IOException{
        if (input != null){
            input.close();
        }
        if (output != null){
            output.close();
        }
        if (client != null){
            client.close();
        }
    }


}
