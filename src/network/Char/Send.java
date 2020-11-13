package network.Char;

import java.io.*;
import java.net.Socket;

/**
 * 使用多线程封装发送数据类
 */
public class Send implements Runnable {
    private BufferedReader reader;
    private DataOutputStream output;
    private Socket client;
    private String name;
    private String data = "";

    //构造器
    public Send(Socket client, String name) {
        this.client = client;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                data = reader.readLine();
                System.out.println(String.format("%s:%s", "发送数据", data));
                if (data != "") {
                    send(data);
                } else {
                    Thread.yield(); //如果没有发送消息就礼让
                }
                data = "";
            }
        } catch (IOException e) {
            System.out.println("============1============");
            ChatUtils.close();
        }
    }

    //发送数据
    public void send(String data1) throws IOException {
//        output = new DataOutputStream(client.getOutputStream());  //如果从客户端获取信息出现异常就直接释放资源
        String data2 = name+ " & "+data1;
        output = new DataOutputStream(client.getOutputStream());  //写入的方向指向服务端
        output.flush();  //写入数据前，进行刷新
        output.writeUTF(data2);  //将写入控制台的数据发送给服务器
    }
}
