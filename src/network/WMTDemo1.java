package network;

import java.io.IOException;

/**
 * 1.创建王梦婷对象
 * 2.使用多线程
 * 3.实现发送接收两个线程
 * 4.实现简单的聊天功能：
 */
public class WMTDemo1 {
    public static void main(String[] args) throws IOException {
        //发送端属性
        int clientPort1 = 8889;
        int severPort1 =7777;
        String name1 = "王梦婷";
        //接收端属性
        int severPort2 = 9999;
        String name2 = "石燔";
        //创建石燔发送者的发送端对象
        ClientDemo5 client = new ClientDemo5(clientPort1,severPort1,name1);
        //创建石燔接收者的接收端对象
        SeverDemo5 sever = new SeverDemo5(severPort2,name2);
        //创建发送线程并启动启程
        new Thread(client).start();
        //创建接收线程并启动启程
        new Thread(sever).start();
    }
}
