package IO;

import java.io.UnsupportedEncodingException;

public class characterDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //getBytes()：使用字符集的方法
        String s1 = "王梦婷";
        //编码：字节数组
        byte[] data = s1.getBytes(); //使用工程默认的字符集UTF-8
        System.out.println("\nUTF-8的字节长度："+data.length);

        //设置其他字符集   例如：UTF-16LE
        //此处会有编码失败的异常，所以要将其抛出
        byte[] data2 = s1.getBytes("UTF-16LE");
        System.out.println("\nUTF-16LE的字节数："+data2.length);

        //解码
        //乱码的两种情况：
        //1):字节数不够
        // String 类中有很多种重载方法,一下使用有设置起点和终点的其中一种重载方法
        s1 = new String(data,0,data.length,"utf-8");
        System.out.println("\n全部将编码后的data数据使用utf-8节码："+s1);
        //当缩短解码的长度，就会出现乱码的现象
        s1 = new String(data,0,data.length-1,"utf-8");
        System.out.println("\n缩短解码长度后data解码后的数据："+s1);

        //2):字符集不统一
        //data数据使用utf-8进行编码的，当我使用别的字符集进行解码会出现乱码现象
        s1 = new String(data,0,data.length,"utf-16le");
        System.out.println("\n使用别的字符集将data解码后："+s1);

    }
}
