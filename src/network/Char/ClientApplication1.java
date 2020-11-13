package network.Char;

import java.io.IOException;
import java.net.Socket;

/**
 * 聊天室多人聊天客户端王梦婷
 */
public class ClientApplication1 {
	public static void main(String[] args) throws IOException {
		int serverPort = 9999;
		String client1Name = "王梦婷";
		ChatClient charRoom1 = new ChatClient(serverPort, client1Name);

		charRoom1.start();
	}
}
