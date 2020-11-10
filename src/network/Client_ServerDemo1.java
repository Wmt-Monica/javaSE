package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 接收端：
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.准备容器 封装成DatagramPacket 包裹
 * 3.阻塞式接收包裹receive(DatagramPacket)
 * 4.分析数据
 *      byte[]  getData()
 *              getLength()
 * 5.释放资源
 */
class ClientDemo1{
    public ClientDemo1(String data,int ClientPort,int SeverPort) throws IOException {
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

/**
 * 发送端
 *      1.使用DatagramSocket 指定端口 创建发送端
 *      2.准备数据一定转成字节数组
 *      3.封装DatagramPacket包裹，需要指定目的地
 *      4.发送包裹send(DatagramPacket)
 *      5.释放资源
 */
class SeverDemo1{
    public SeverDemo1(int SeverPort) throws IOException {
        System.out.println("接收端启动中....");
        //1.使用DatagramSocket 指定端口，创建接收端
        DatagramSocket sever = new DatagramSocket(SeverPort);
        //2.准备好容器 封装成DatagramPacket包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //3.阻塞式接受包裹receive(DatagramPacket p)
        System.out.println("==========");
        sever.receive(packet); //阻塞式
        //4.分析数据
        //byte[] getData()
        //       getLength()
        byte[] datas = packet.getData();
        int length = packet.getLength();
        System.out.println(new String(datas,0,length));
        System.out.println("数据接收成功....");
        //5.释放资源
        sever.close();
    }
}

public class Client_ServerDemo1 {
    public static void main(String[] args) throws IOException {
        String data = "石燔大傻瓜";
        ClientDemo1 client = new ClientDemo1(data,8888,9999);
        SeverDemo1 sever = new SeverDemo1(8888);
    }
}
