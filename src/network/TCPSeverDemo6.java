package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 多个用户端请求
 * 创建服务器
 * 1.指定端口 使用SeverSocket创建服务器
 * 2.阻塞等待连接 accept
 * 3.操作：输入输出流操作
 */
public class TCPSeverDemo6 {
    ServerSocket sever;
    int severPort;

    //构造器
    public TCPSeverDemo6(ServerSocket sever, int severPort) {
        this.sever = sever;
        this.severPort = severPort;
    }

    //创建一个完整的服务器
    public void TCPSever() throws IOException {
        //1.指定端口 使用SeverSocket创建服务器
        sever = new ServerSocket(severPort);

        boolean flag = true;
        while (flag){
            //2.阻塞式等待连接 accept
            Socket client = sever.accept();
            new Thread(new TCPClient(client)).start();
        }
    }

    //创建一个服务器中的客户端类
    static class TCPClient implements Runnable{
        private Socket client;
        private DataInputStream input = null;
        private DataOutputStream output = null;
        private String[] User = new String[2];  //存数用户的用户名和用户密码字符串数组

        //构造器
        public TCPClient(Socket client) {
            this.client = client;
        }

        //重写run()方法
        @Override
        public void run() {
            System.out.print("客户端成功建立连接....");

            try {
                //接收数据
                System.out.println("====================");
                System.out.print(receive());
                //发送数据
                send();
                //释放资源
                SeverClose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //接收数据
        public String receive() throws IOException{
            input = new DataInputStream(this.client.getInputStream());
            String data = input.readUTF();
            String[] UserData = data.split(" & ");
            int i = 0;
            for (String s : UserData){
                String[] d = s.split(" = ");
                User[i++] = d[1];
            }
            System.out.println("UserName"+"---->"+User[0]+"\nUserPassword"+"---->"+User[1]);
            return("UserName"+"---->"+User[0]+"\nUserPassword"+"---->"+User[1]);
        }

        //发送数据
        public void send() throws IOException{
            this.output = new DataOutputStream(this.client.getOutputStream());
            //对用户的信息进行简单的判断
            if (User[0].equals("王梦婷") && User[1].equals("mengmengmeng0501")){
                this.output.writeUTF("登录成功，欢迎回来....");
                this.output.flush();
                System.out.println("登录成功，欢迎回来....");
            }else {
                this.output.writeUTF("用户名或者密码错误，请确认后重新登录....");
            }
        }

        //释放资源
        public void SeverClose() throws IOException {
            if (this.input != null){
                this.input.close();
            }
            if (this.output != null){
                this.output.close();
            }
            this.client.close();
        }
    }
}
