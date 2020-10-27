package IO;

import java.io.*;

/**
 * 使用字符流实现文件的拷贝
 */
public class ReadWriteDemo1 {
    public static void main(String[] args) {
        //1.选择数据源头
        File readFile = new File("D:/github上传的文件/JavaTxtSet/2020_10_26Demo1.txt");
        File writeFile = new File("D:/github上传的文件/JavaTxtSet/2020_10_26Demo2.txt");

        try {
            //2.选择数据流
            Reader reader = new FileReader(readFile);
            Writer writer = new FileWriter(writeFile);

            //使用read()方法读取的是其祖父，故因此不能使用字节来当临时数据存储变量
            char[] flush = new char[2];
            int length = -1;  //存储成功读取到了多少个有效字符
            while ((length = reader.read(flush)) != -1){  //当未读取到数据的最后
                String data = new String(flush);  //将读取到的数据赋值到临时字符串变量
                System.out.print(data);
            }

            //使用write()方法写入数据
            String data = "天地不容又如何，若世间都要要阻我，我就将这天地一并毁去！\n";
            //将数据写入文件中的三种方法
            //一：将字符串数据存入字符数组当中去 (可以选择性截取部分传入数据)
            char[] data2 = data.toCharArray();  //字符串——>字符数组
            writer.write(data2,0,data2.length);

            //二：直接将字符串数据传参给write()方法中 (简洁)
            writer.write(data);

            //三：使用append()方法附加数据
            writer.append(data);

            //注意：写入数据时候要记得最后的刷新，否则将无法看到有效的数据显示
            writer.flush();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
