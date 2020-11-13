package network;

import java.io.IOException;
import java.net.Socket;

/**
 * 聊天室多人聊天客户端王梦婷
 */
public class CharClientDemo1 {
    public static void main(String[] args) throws IOException {
        Socket client = null;
        int clientPort = 8888;
        String name = "王梦婷";
        CharRoomClientClass charRoom = new CharRoomClientClass(client,clientPort,name);
        charRoom.CharClient();
    }
}
