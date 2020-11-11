package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 将接收发送端进行对象的包装：
 *      发送端
 *      1.使用DatagramSocket 指定端口 创建发送端
 *      2.准备数据  一定转成字节数组
 *      3.封装成DatagramPacket包裹，需要指定目的地
 *      4.发送包裹send(DatagramPacket p)*
 *      5.释放资源
 */
public class ClientDemo5 implements Runnable {
    private DatagramSocket client;
    private int clientPort;
    private int severPort;
    private String name;

    //构造器
    public ClientDemo5(int clientPort,int severPort,String name) throws IOException {
        this.clientPort = clientPort;
        this.severPort = severPort;
        this.name = name;
    }

    @Override
    public void run() {

        //1.使用DatagramSocket 指定端口 创建发送端
        try {
            this.client = new DatagramSocket(this.clientPort);
            while (true){
                //2.准备数据
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String data = reader.readLine();
                byte[] datas = data.getBytes();

                //3.封装成DatagramPacket包裹，需要指定目的地
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                        new InetSocketAddress("localhost",severPort));

                //4.发送包裹send(DatagramPacket p)*
                client.send(packet);
                if (data.equals("bye")){
                    break;
                }
            }
            //5.释放资源
            client.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
