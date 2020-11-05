package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress: 多个静态方法
 * 1.getLocalHost: 本机
 * 2.getByName: 根据域名DNS|IP地址---->IP
 *
 * 两个成员方法
 * 1.getHostAddress: 返回地址
 * 2.getHostName: 返回计算机名
 */
public class InetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();  //获取本机对象
        System.out.println("本机的IP地址："+address.getHostAddress());
        System.out.println("返回计算机名："+address.getHostName());

        //根据域名得到InetAddress对象
        address = InetAddress.getByName("www.dreamplume.cn");
        System.out.println("返回www.dreamplume.cn的服务器的IP： "+address.getHostAddress());
        System.out.println("输出www.dreamplume.cn的名字："+address.getHostAddress());

        //根据IP得到InetAddress对象
        address = InetAddress.getByName("39.107.141.213");
        System.out.println("返回39.107.141.213的服务器的IP： "+address.getHostAddress());
        System.out.println("输出39.107.141.213的名字："+address.getHostAddress());

    }
}
