package IO;

import java.io.*;

/**
 * 文件自己而输出流
 * 1.创建源
 * 2.选择流
 * 3.操作（写内容）
 * 4.释放资源
 */
public class OutStreamDemo1 {
    public static void main(String[] args) {
        //1.创建源
        File file = new File("D:/github上传的文件/JavaTxtSet/2020_10_25Demo2.txt");

        //2.选择流
        OutputStream output = null;
        try {
            //创建outStream的子类FileOutputStream对象
            //注意：使用OutputStream输出流创建的文件对象即使不存在也会帮你重新按照该路径创建新的文件
            //注意：此处创建对象中有一个重载方法，可以在其后面田家庵布尔参数，用于选择是否在文件后面追加（true），或者是覆盖（false）
            output = new BufferedOutputStream( new FileOutputStream(file,true));

            //3.操作（写内容）
            String s = "WMT IS VERY BEAUTY\n";
            byte[] data = s.getBytes();  //对写入的字符串进行编码操作
            try {  //此处写入数据可能会有异常，需要捕获或者抛出
                //写如数据之前先要进行刷新
                output.flush();
                output.write(data,0,data.length);  //使用write()将编码后的字节数据写入文件中
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            //4.释放资源（关闭流）
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
