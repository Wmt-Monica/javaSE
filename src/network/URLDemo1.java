package network;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *  URI:统一资源标志符，用于标识抽象或者物理资源的紧凑字符串
 *  URL:统一资源定位符，一种定位资源的主要访问机制的字符串，一个标准的URL必须包括
 *  URN:统一资源名称，通过特定命名空间中的唯一名称或ID来标识资源
 *
 *  在www上，每一个信息资源都有统一且唯一的地址，即统一资源定位符
 *  如：http://www.google.com:80/index.html，由四个部分组成：
 *      1.协议  http协议
 *      2.存放资源的主机域名  www.google.com
 *      3.端口号  80
 *      4.资源文件名  index.html
 *
 *  网络三大基石：html,http,url
 *
 *
 *  URL:统一资源定位器，互联网三大基石之一，区分资源
 *  1.协议
 *  2.域名，计算机
 *  3.端口：默认80
 *  4.请求资源
 */
public class URLDemo1 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://dreamplume.cn/ChildrenHtml/two.html");
        //获取四种值
        System.out.println("协议："+url.getProtocol());
        System.out.println("域名|IP："+url.getHost());
        System.out.println("端口："+url.getPort());
        System.out.println("请求资源1："+url.getFile());
        System.out.println("请求资源2："+url.getPath());
        System.out.println("参数："+url.getRef());
        System.out.println("锚点："+url.getRef());
    }
}
