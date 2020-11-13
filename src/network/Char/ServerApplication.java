package network.Char;

import java.io.IOException;

/**
 * 多人聊天室：服务器端实现类
 */
public class ServerApplication {
	public static void main(String[] args) throws IOException {
		int severPort = 9999;
		ChatServer CharSever = new ChatServer(severPort);
		CharSever.start();
	}
}
