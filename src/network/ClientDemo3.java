package network;

import java.io.*;
import java.net.*;

/**
 * 文件传输：发送端
 *      1.使用DatagramSocket 自定端口 创建发送端
 *      2.将文件转成字节数组
 *      3.封装成DatagramPacket包裹，需要指定目的地
 *      4.发送包裹send(DatagramPacket p)*
 *      5.释放资源
 */
public class ClientDemo3 {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动....");
        int ClientPort = 8888;
        int SeverPort = 9999;
        //1.使用DatagramSocket 自定义端口 创建发送端
        DatagramSocket client = new DatagramSocket(ClientPort);

        //2.将文件图片转成字节数组
//        BufferedInputStream reader = new BufferedInputStream(
//                        new URL("https://img.zcool.cn/community/0130325f" +
//                                "a8c4af11013ee04dd3398f.jpg@1280w_1l_2o_100sh.jpg").openStream()
//        );

        BufferedInputStream reader = new BufferedInputStream(new FileInputStream("D:/github上传的文件/JavaTxtSet/2020_11_10Demo1.txt"));

        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        byte[] flush = new byte[1024];
        byte[] datas;
        int length = -1;
        while((length = reader.read(flush)) != -1){
            byteOutput.write(flush);
        }
        datas = byteOutput.toByteArray();  //将图片的数据转换成字节数组赋值给 datas

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
