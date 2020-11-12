package network;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 模拟登录 多客户请求
 * 服务端：WMT
 */
public class WMTDemo2 {
    public static void main(String[] args) throws IOException {
        //1.创建服务器
        ServerSocket severSocket = null;
        int severPort = 8888;
        System.out.println("服务器启动....");
        TCPSeverDemo6 sever = new TCPSeverDemo6(severSocket,severPort);
        sever.TCPSever();
    }
}
