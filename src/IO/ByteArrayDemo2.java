package IO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 字节数组输出流
 * 1.创建数据源：内部维护,不需要创建数据源
 * 2.选择数据流：不用关联源
 * 3.操作：写出内容
 * 4.释放资源：可以不用，此为一个空方法
 */
public class ByteArrayDemo2 {
    public static void main(String[] args) {
        //1.创建数据源
        byte[] src = null;  //不需要创建数据源

        //2.选择数据流
        OutputStream output = null;
        //选择ByteArrayOutputStream
        output = new ByteArrayOutputStream();

        //3.操作
        String s = "WMT is very beauty!";
        byte[] data1 = s.getBytes();
        try {
            //1):写入数据
            output.write(data1,0,data1.length);
            output.flush();  //刷新数据

            //2):获取数据
            String data2 = output.toString();
            System.out.println("获取的数据data2："+data2);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
