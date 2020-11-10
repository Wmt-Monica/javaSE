package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 发送端
 *      1.使用DatagramSocket 指定端口 创建发送端
 *      2.准备数据一定转成字节数组
 *      3.封装DatagramPacket包裹，需要指定目的地
 *      4.发送包裹send(DatagramPacket)
 *      5.释放资源
 */
public class SeverDemo1 {
    public static void main(String[] args) throws IOException {
        int SeverPort = 9999;
        System.out.println("接收端启动中....");
        //1.使用DatagramSocket 指定端口，创建接收端
        DatagramSocket sever = new DatagramSocket(SeverPort);
        //2.准备好容器 封装成DatagramPacket包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //3.阻塞式接受包裹receive(DatagramPacket p)
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
