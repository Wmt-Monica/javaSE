package network;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 多人聊天室：服务器端实现类
 */
public class CharSeverDemo1 {
    public static void main(String[] args) throws IOException {
        ServerSocket sever = null;
        int severPort = 8888;
        ChatRoomSeverClass chatRoom = new ChatRoomSeverClass(sever,severPort);
        chatRoom.CharSeverAll();
    }
}
