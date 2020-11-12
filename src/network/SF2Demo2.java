package network;

import java.io.IOException;
import java.net.Socket;

/**
 * 模拟登录 多客户请求
 * 客户端：SF
 */
public class SF2Demo2 {
    public static void main(String[] args) throws IOException {
        //创建客户端
        Socket clientSocket = null;
        int clientPort = 8888;
        TCPClientDemo6 client = new TCPClientDemo6(clientSocket,clientPort);
        client.TCPClient();
    }
}
