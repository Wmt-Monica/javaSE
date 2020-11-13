package network;

/**
 * 创建聊天室：
 * 创建聊天室服务器类：
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 多个用户端请求
 * 创建服务器
 * 1.指定端口 使用SeverSocket创建服务器
 * 2.阻塞等待连接 accept
 * 3.操作：输入输出流操作
 */
public class ChatRoomSeverClass {
    private ServerSocket sever;
    private int severPort;


    //构造器
    public ChatRoomSeverClass(ServerSocket sever, int severPort) throws IOException {
        this.severPort = severPort;
        this.sever = new ServerSocket(this.severPort);  //1.使用SeverSocket创建服务器
    }

    //一个完整服务器的功能
    public void CharSeverAll() throws IOException {
        System.out.println("--------服务端启动--------");
        boolean flag = true;
        while (flag){
            Socket client = sever.accept();
            new Thread(new CharSever(client)).start();
        }

    }


}


//完整服务器功能的多线程类
class CharSever implements Runnable {

    private DataInputStream input = null;
    private DataOutputStream output = null;
    private Socket client;
    static int clientNum = 0;

    //构造器
    public CharSever(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        clientNum++;  //客户端数量加一
        System.out.println("--------第"+clientNum+"个客户端成功建立连接--------");
        try {
            boolean flag = true;
            while (flag){
                String data = receive();  //接收数据
                send(data);  //发送数据
                if (data.equals("bye")){
                    Close();  //释放资源
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //3.输入输出流的操作
    //接收客户端发来的数据
    public String receive() throws IOException{
        input = new DataInputStream(client.getInputStream());  //获取客户端发来的数据
        String data = input.readUTF();
        System.out.println("--------数据接收成功-------");
        String[] ClientData = data.split(" & ");
        System.out.println("客户"+ClientData[0]+"："+ClientData[1]);
        return ClientData[1];
    }

    //发送数据给客户端
    public void send(String data) throws IOException{
        output = new DataOutputStream(client.getOutputStream());  //写入数据给客户端
        output.writeUTF(data);
        System.out.println("--------数据发送成功-------");
    }

    //4.释放资源
    public void Close() throws IOException {
        if (input != null){
            input.close();
        }
        if (output != null){
            output.close();
        }
        if (client != null){
            client.close();
        }
        System.out.println("--------资源释放完毕--------");
    }
}
