package network;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 文件类型：接收端
 *      1.使用DatagramSocket 指定端口 创建接收端
 *      2.准备容器 封装成DatagramPacket 包裹
 *      3.阻塞式接收包裹receive(DatagramPacket p)
 *      4.分析数据 将字节数组还原为对应的类型
 *          byte[] getData()
 *                 getLength()
 *      5.释放资源
 */
public class SeverDemo3 {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端启动....");
        int SeverPort = 9999;
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket sever = new DatagramSocket(SeverPort);

        //2.准备容器 封装成DatagramPacket 包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);

        //3.阻塞式接收包裹receive(DatagramPacket p)
        sever.receive(packet);

        //4.分析数据 将字节数组中的数据写入文件中，还原图片，完成涂片的拷贝
       byte[] datas = packet.getData();
       int length = packet.getLength();
       BufferedOutputStream output = new BufferedOutputStream(
               new FileOutputStream(
                       new File("D:/github上传的文件/JavaTxtSet/2020_11_10Demo2.txt")));
       output.write(datas,0,length);
       output.flush();
       System.out.println("数据接收完成....");

       //5.释放资源
        sever.close();
    }
}
