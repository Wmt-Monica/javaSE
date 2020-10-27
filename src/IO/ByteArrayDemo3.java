package IO;

import java.io.*;

/**
 * 将图片文件转换成字节数组，再将字节数组转换成图片文件
 */
public class ByteArrayDemo3 {
    public static void main(String[] args) {
        String src1 = "D:/github上传的文件/JavaTxtSet/5-1.png";
        String src2 = "D:/github上传的文件/JavaTxtSet/picture.png";
        byte[] data = fileToByteArray(src1);
        byteArrayToFile(data,src2);
    }

    //方法一：将图片转换成字节数组
    public static byte[] fileToByteArray(String src){
        //创建数据源
        File inputFile = new File(src);
        InputStream input = null;

        try {
            //选择数据流
            input = new FileInputStream(inputFile);
            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
            int length = -1;
            byte[] flush = new byte[1024];

            while ((length = input.read(flush)) != -1){
                byteOutput.write(flush,0,length);  //将图片的数据写入字节数据流中
            }
            byteOutput.flush();  //刷新数据
            System.out.println("size:"+byteOutput.size());
            return byteOutput.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //方法二：将字节数组转换成图片文件
    public static void byteArrayToFile(byte[] data,String src){
        //选择数据源
        File file = new File(src);
        OutputStream output = null;
        try {
            //选择数数据流
            output = new FileOutputStream(file);
            ByteArrayInputStream input = new ByteArrayInputStream(data);

            //读取数据
            int length = -1;
            byte[] flush = new byte[1024];
            while ((length = input.read(flush)) != -1){
                output.write(flush,0,length);
            }
            output.flush();  //刷新数据

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
