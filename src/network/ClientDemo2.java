package network;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 基本类型：发送端
 *          1.使用DatagramSocket 指定端口 创建发送端
 *          2.将基本类型 转成字节数组
 *          3.封装成DatagramPacket包裹，需要指定目的地
 *          4.发送包裹send(DatagramPacket p)*
 *          5.释放资源
 */
public class ClientDemo2 {
    public static void main(String[] args) throws IOException {
        int ClientPort = 8888;
        int SeverPort = 9999;
        System.out.println("发送端启动....");
        //1.使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(ClientPort);

        //2.准备数据，将基本数据类型转成字节数组
        ByteArrayOutputStream array = new ByteArrayOutputStream();  //存储字节数据
        DataOutputStream data = new DataOutputStream(new BufferedOutputStream(array));  //基本数据类型的写入类
        //将各类数据类型写入 array
        data.writeFloat((float)3.14);
        data.writeDouble(5.123);
        data.writeChars("石燔大傻瓜");
        data.writeBoolean(true);
        data.writeChar('M');
        data.writeInt(22);
        data.flush();  //写完数据后最后一定要记得刷新数据
        byte[] datas = array.toByteArray();  //将获取的基本数据类型存入字节数组中

        //3.封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",SeverPort));

        //4.发送包裹send (DatagramPacket p)*
        client.send(packet);
        System.out.println("数据发送成功....");

        //5.释放数据
        client.close();
    }
}
