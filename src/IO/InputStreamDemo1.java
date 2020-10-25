package IO;

import java.io.*;

/**
 * 理解IO流的操作步骤
 * 1）：创建源
 * 2）：选择流
 * 3）：操作
 * 4）：释放资源
 */
public class InputStreamDemo1 {
    public static void main(String[] args) {
        //1.创建数据源
        File file = new File("D:/github上传的文件/JavaTxtSet/2020_10_25Demo1.txt");

        InputStream input = null;
        try {
            //2.选择流（例如：选择InputStream字节流）
            input = new FileInputStream(file); //数据可能会读取失败，故应此要用try/catch或者throw抛出异常

            //3.操作（例如：使用read()方法读取数据）注意：read()方法返回的是int型数据类型
            //当读取数据时，读到数据的最后read()时返回-1
//            //1):一个字节一个字节读取
//            int data;
//            while((data = input.read()) != -1){
//                System.out.print((char) data);
//            }

            System.out.println("\n========================================");
            //2):存入一个字节缓冲区，进行一块数据一块数据读取
            byte[] flush = new byte[3];  //三个字节的数据缓冲byte数组
            //注意：使用read()方法可以返回一共有效读取了多少个字节的数据
            int length = -1;  //接收长度
            while ((length = input.read(flush)) != -1){
                //将字节数据流进行解码
                String s1 = new String(flush,0,length);
                System.out.print(s1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //无论是否成功读取数据，始终会完成finally语句，来进行关闭流的操作
            //4.释放资源
            //为了避免未能成功创建InputStream对象而导致无法正常的进行关闭流释放资源的操作，故因此此处进行一个判断
            if (input != null){//如果成功创建InputStream对象就能进行下面关闭流释放资源的操作
                try {
                    input.close();  //关闭流释放资源可能会出现无啊正常释放的异常故应此此处需要捕获IOException异常
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
