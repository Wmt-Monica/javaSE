package network.Char;

import java.io.IOException;
import java.net.Socket;

/**
 * 聊天室多人聊天客户端王梦婷
 */
public class ClientApplication2 {
	public static void main(String[] args) throws IOException {
		int serverPort = 9999;
		String client2Name = "石燔傻逼";
		ChatClient charRoom2 = new ChatClient(serverPort, client2Name);
		charRoom2.start();
	}
}
