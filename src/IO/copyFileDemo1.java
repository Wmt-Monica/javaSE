package IO;
/**
 * 复制文件
 */

import java.io.*;

public class copyFileDemo1 {
    public static void main(String[] args) {
        //1.创建输入/输出流源头
        File inputFile = new File("D:/github上传的文件/JavaTxtSet/2020_10_25Demo1.txt");
        File outputFile = new File("D:/github上传的文件/JavaTxtSet/2020_10_25Demo2.txt");

        //2.选择输入/输出流
        InputStream input = null;
        OutputStream output = null;

        //3.复制文件操作
        byte[] flush = new byte[4];  //输入流读取数据的暂时缓存字节数组
        int length = -1;  //设置读取数据的有效长度变量
        try {
            input = new BufferedInputStream( new FileInputStream(inputFile));  //创建输入流对象
            output = new BufferedOutputStream( new FileOutputStream(outputFile,true));  //创建输出流对象

            while ((length = input.read(flush)) != -1){  //当未读取到数据的最后
//                String data1 = new String(flush,0,length);  //将读取到的数据的字节码解码成字符串
//
//                byte[] data2 = data1.getBytes(); //将获取到的字符串数据进行编码
//                //注意：写入数据前要刷新
//                output.flush();
//                output.write(data2);

                //以下是最简易的操作，上面是为了重温解码和编码的过程
                output.flush();
                output.write(flush);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.释放缓存
            //注意：为了避免输入流或者输出流对象未能创建成功而导致关闭流操作异常，所以在释放资源前要加上判断
            //注意：为了放置数据传输过程出现异常：采用先打开的数据流后关闭
            if (output != null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
