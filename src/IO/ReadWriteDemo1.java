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
            //注意：此处使用了修饰类BufferedReader/BufferedWriter，可以很大程度上提高程序的性能
            BufferedReader reader = new BufferedReader( new FileReader(readFile));
            BufferedWriter writer = new BufferedWriter( new FileWriter(writeFile));

            //使用read()方法读取的是其祖父，故因此不能使用字节来当临时数据存储变量
            /**
             * 注意，在使用BufferedReader/BufferedWriter修饰类读取和写入数据都是一行一行的进行的
             */
            //故因此一下的内容需要进行调整
            String line = ""; //不再使用字符数组来储存数据，而是字符串
            while ((line = reader.readLine()) != null){
                //使用write写入数据，注意，此处数据是一行一行的写入，因为读取得到的data就是一整行的数据
                writer.write(line);

                //注意：每次写入一行数据后，就要使用Buffered 类里面的一个换行的方法，就可以不用在后面追加换行符
                writer.newLine();
                System.out.println(line);
            }
            writer.flush();  //读取完数据后，最后一定要进行刷新数据

            /*char[] flush = new char[2];
            int length = -1;  //存储成功读取到了多少个有效字符
            while ((length = reader.read(flush)) != -1){  //当未读取到数据的最后
                String data = new String(flush,0,length);  //将读取到的数据赋值到临时字符串变量
                System.out.print(data);
            }*/

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
