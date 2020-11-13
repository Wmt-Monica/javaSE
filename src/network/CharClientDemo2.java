package network;

import java.io.IOException;
import java.net.Socket;
/**
 * 聊天室多人聊天客户端石燔
 */
public class CharClientDemo2{
    public static void main(String[] args) throws IOException{
        Socket client = null;
        int clientPort = 8888;
        String name = "石燔";
        CharRoomClientClass charRoom = new CharRoomClientClass(client,clientPort,name);
        charRoom.CharClient();
    }
}
