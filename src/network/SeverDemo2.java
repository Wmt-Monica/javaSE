package network;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 基本类型：接收端
 *          1.使用DatagramSocket 指定端口 创建接收端
 *          2.准备容器 分装成DatagramPacket包裹
 *          3.阻塞式接收包裹receive(DatagramPacket p)
 *          4.分析数据
 *              byte[] getData()
 *                     getLength()
 *          5.释放资源
 */
public class SeverDemo2{
    public static void main(String[] args) throws IOException {
        System.out.println("接收端启动....");
        int SeverPort = 9999;
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket sever = new DatagramSocket(SeverPort);

        //2.准备容器 分装成DatagramPacket包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);

        //3.阻塞式接受包裹receive(DatagramPacket p)
        sever.receive(packet);

        //4.分析数据
        byte[] data = packet.getData();
        int length = packet.getLength();
        DataInputStream input = new DataInputStream(
                new BufferedInputStream(
                        new ByteArrayInputStream(data)));
        float data1 = input.readFloat();
        double data2 = input.readDouble();
        char data3 = input.readChar();
        char data4 = input.readChar();
        char data5 = input.readChar();
        char data6 = input.readChar();
        char data7 = input.readChar();
        boolean data8 = input.readBoolean();
        char data9 = input.readChar();
        int data10 = input.readInt();
        System.out.println("data1:"+data1+"\tdata2:"+data2+"\tString:"+data3+
                data4+data5+data6+data7+"\tdata8:"+data8+"\tdata9:"+data9+"\tdata10:"+data10);

        //5.释放资源
        sever.close();

    }
}
