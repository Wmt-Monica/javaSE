package network;

import java.net.InetSocketAddress;

/**
 * InetSocketAddress
 * 1.构造器
 *      new InetSocketAddress(地址|域名，端口)
 * 2.方法
 * getAddress()  获得InetAddress
 * getPort()  获得端口号
 * getHostName()  获得主机名
 */
public class InetSocketAddressDemo1 {
    public static void main(String[] args) {
        InetSocketAddress socketAddress1 = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost",8081);
        InetSocketAddress socketAddress3 = new InetSocketAddress("www.dreamplume.cn",8082);

        System.out.println(socketAddress1.getHostName());
        System.out.println(socketAddress1.getAddress());
        System.out.println(socketAddress1.getPort());
        System.out.println("=======================================");

        System.out.println(socketAddress2.getHostName());
        System.out.println(socketAddress2.getAddress());
        System.out.println(socketAddress2.getPort());
        System.out.println("=======================================");

        System.out.println(socketAddress3.getAddress());
        System.out.println(socketAddress3.getPort());

    }
}
