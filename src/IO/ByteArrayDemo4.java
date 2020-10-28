package IO;
/**
 * 1.将文件和字节之前的方法来进行分装
 * 2.同时关闭流的方法使用两种方法进行试验的操作
 */

import java.io.*;

public class ByteArrayDemo4 {
    public static void main(String[] args) {
        String src1 = "D:/github上传的文件/JavaTxtSet/5-1.png";
        String src2 = "D:/github上传的文件/JavaTxtSet/picture.png";
        byte[] data = FileToByteArray(src1);
        byteArrayToFile(data,src2);
    }

    //方法一：将图片转换成字节数组储存
    public static byte[] FileToByteArray(String src){
        File file = new File(src);
        InputStream input = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            input = new FileInputStream(file);

            int length = -1;
            byte[] flush = new byte[1024];
            while ((length = input.read(flush)) != -1){
                output.write(flush,0,length);
            }
            output.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {  //关闭流的方法一：在最后finally里面使用分装后的close方法
            close(input);
        }
        return output.toByteArray();
    }

    //方法二：将字节数组数据转换成文件
    public static void byteArrayToFile(byte[] data,String src){
        File file = new File(src);
        ByteArrayInputStream input = null;

        try(OutputStream output = new FileOutputStream(file)) {  //关闭流的方法二：将要关闭的流的声明放在try()里面
            input = new ByteArrayInputStream(data);

            int length = -1;
            byte[] flush = new byte[1024];
            while ((length = input.read(flush)) != -1){
                output.write(flush,0,length);
            }
            output.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //将关闭流的操作进行分装
    public static void close(Closeable... io){  //...表示可以存放任意个的流类型，进行关闭流的操作
        for (Closeable i : io){
            if (i != null){
                try {
                    i.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
