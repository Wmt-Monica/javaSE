package IO;

/**
 * File:文件类
 * InputStream:字节输入流
 * OutputStream:字节输出流
 * Reader:字符输入流
 * Write:字符输出流
 * Closeable:关闭流接口
 * Flushable:刷新流接口
 * Serializable:序列化接口
 *
 * 输入流：数据源到程序(InputStream,Reader读出来)
 * 输出流：程序到目的地(OutputStream,Write写出去)
 */









public class FileDemo1 {
    public static void main(String[] args) {
        //文件路径使用字符串来存储，其中文件路径分隔符使用'\'使用转义字符'\'进行转义
        String s1 = "D:\\github上传的文件\\JavaTxtSet\\2020_10_24.txt";
        //如果不使用转义字符转义，我们最常用的事反斜杠'/'
        String s2 = "D:/github上传的文件/JavaTxtSet/2020_10_24.txt";
    }
}
