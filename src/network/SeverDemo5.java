package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 将接收发送端进行对象的包装：
 *     接收端
 *     1.使用DatagramSocket 指定端口 创建接收端
 *     2.准备容器 封装成DatagramPacket包裹
 *     3.阻塞式接收包裹receive(DatagramPacket p)
 *     4.分析数据
 *          byte[] getData()
 *                 getLength()
 *     5.释放资源
 */
public class SeverDemo5 implements Runnable {
    private DatagramSocket sever;
    private int severPort;
    String name;

    //构造器
    public SeverDemo5(int severPort, String name) throws IOException {
        this.severPort = severPort;
        this.name = name;
    }

    @Override
    public void run() {

        //1.使用DatagramSocket 指定端口 创建接收端
        try {
            this.sever = new DatagramSocket(this.severPort);
            while (true){
                //2.准备容器 封装成DatagramPacket包裹
                byte[] datas = new byte[1024*50];
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length);
                //3.阻塞式接收包裹receive(DatagramPacket p)
                sever.receive(packet);
                //4.分析数据
                byte[] data = packet.getData();
                int length = packet.getLength();
                System.out.println(this.name+": "+new String(data,0,length));
                if (data.equals("bye")){  //字节数组也可以使用equals来和字符串相比较
                    break;
                }
            }
            //5.释放资源
            sever.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
