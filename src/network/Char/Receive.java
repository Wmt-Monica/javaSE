package network.Char;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 使用多线程封装接收数据类
 */
public class Receive implements Runnable {

    private DataInputStream input;

    private Socket client;

    private String data = "";

    public String getData() {
        return data;
    }

    //构造器
    public Receive(Socket client) {
        this.client = client;
        try {
            this.input = new DataInputStream(this.client.getInputStream());
        } catch (IOException e) {
            System.out.println("============7============");
            ChatUtils.close();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                data = input.readUTF();
                if (!data.equals("")){
                    System.out.println(String.format("%s:%s", "接受数据", data));
                }
                if (data.equals("bye")){
                    //释放资源
                    ChatUtils.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
