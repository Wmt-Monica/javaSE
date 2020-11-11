package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 实现发送端和接收端多次交流
 *      接收端：
 *      1.使用DatagramSocket 指定端口 创建接收端
 *      2.准备容器 封装成 DatagramPacket包裹
 *      3.阻塞式接受包裹 receive(DatagramPacket p)
 *      4.分析数据
 *          byte[] getData()
 *                 getLength()
 *      5.释放资源
 */
public class SeverDemo4 {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端启动....");
        int severPort = 8888;
        String name = "王梦婷";
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket sever = new DatagramSocket(severPort);
        while (true){
            //2.准备容器 封装成 DatagramPacket包裹
            byte[] datas = new byte[1024*50];
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length);
            //3.阻塞式接收包裹receive(DatagramPacket p)
            sever.receive(packet);
            //4.分析数据
            byte[] data = packet.getData();
            int length = packet.getLength();
            System.out.println("石燔："+new String(data,0,length));
            if (data.equals("bye")){
                break;
            }
        }

        System.out.println("聊天结束....");
        //5.释放资源
        sever.close();
    }
}
