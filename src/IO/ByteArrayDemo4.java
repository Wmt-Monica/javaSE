package IO;

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
        }finally {
            if (input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return output.toByteArray();
    }

    //方法二：将字节数组数据转换成文件
    public static void byteArrayToFile(byte[] data,String src){
        File file = new File(src);
        OutputStream output = null;
        ByteArrayInputStream input = null;

        try {
            output = new FileOutputStream(file);
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
        }finally {
            if (output != null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
