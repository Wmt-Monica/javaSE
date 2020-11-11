package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 实现发送端和接收端多次交流：
 *      发送端：
 *      1.使用DatagramSocket 指定端口 创建发送端
 *      2.准备数据一定转成字节数组
 *      3.封装成DatagramPacket包裹，需要指定目的地
 *      4.发送包裹send(DatagramPacket p)*
 *      5.释放资源
 */
public class ClientDemo4 {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动....");
        int clientPort = 9999;
        int severPort = 8888;
        String name = "石燔";
        //1.使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(clientPort);
        //2.准备数据
        while (true){
            System.out.print(name+"：");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String data = reader.readLine();
            byte[] datas = data.getBytes();  //将获取的数据转换成字节数组存储到 datas

            //3.封装成DatagramPacket包裹，需要指定目的地
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                    new InetSocketAddress("localhost",severPort));

            //4.发送包裹send(DatagramPacket p)
            client.send(packet);
            if (data.equals("bye")){
                break;
            }
        }

        System.out.println("聊天结束....");
        //5.释放资源
        client.close();
    }
}
