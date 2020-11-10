package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * 发送端
 *      1.使用DatagramSocket 指定端口 创建发送端
 *      2.准备数据一定转成字节数组
 *      3.封装DatagramPacket包裹，需要指定目的地
 *      4.发送包裹send(DatagramPacket)
 *      5.释放资源
 */
public class ClientDemo1 {
    public static void main(String[] args) throws IOException {
        String data = "石燔大傻瓜";
        int ClientPort = 8888;
        int SeverPort = 9999;
        System.out.println("发送方启动中....");
        //1.使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(ClientPort);
        //2.准备数据 一定转成字节数组
        byte[] datas = data.getBytes();
        //3.封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",SeverPort));
        //4.发送包裹send(DatagramPacket p)*
        client.send(packet);
        System.out.println("数据发送成功....");
        //5.释放资源
        client.close();
    }
}
