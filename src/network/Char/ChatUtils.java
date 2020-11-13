package network.Char;

import java.io.Closeable;
import java.io.IOException;

/**
 * 工具类：用于资源的释放
 */
public class ChatUtils {
    public static void close(Closeable... targets){
        for (Closeable target : targets){
            if (target != null){
                try {
                    target.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
