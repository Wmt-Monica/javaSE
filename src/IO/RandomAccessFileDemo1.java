package IO;

import java.io.*;
import java.util.Random;
import java.util.RandomAccess;

/**
 * 随即读取和写入的流
 * RandomAccessFile
 *
 * 利用该类分割的功能实现分割文件的功能
 */
public class RandomAccessFileDemo1 {
    public static void main(String[] args) {
//        String s = "D:/github上传的文件/JavaTxtSet/2020_10_29Demo4.txt";
        String s = "D:/github上传的文件/JavaTxtSet/src/Collection/ArrayList_1.java";
        groupFile group = new groupFile(500,s);

    }
}

//使用对象的思维去创造一个实现将文件按照要分成每块数据的大小来分组类
class groupFile{
    public groupFile(int moSize,String src){
        File file = new File(src);
        long length = file.length();  //获取文件的大小
        int count = (int) Math.ceil((length*1.0)/moSize);  //计算一共要分成几块数据源

        try {
            RandomAccessFile reader = new RandomAccessFile(new File(src),"r");
            for (int i = 1; i <= count; i++){
                //创建分模块的文件对象
                File file1 = new File("D:/github上传的文件/JavaTxtSet/2020_10_29/2020_10_29Demo"+i+".txt");
                if (!file1.exists()){
                    file1.createNewFile();
                }
                RandomAccessFile writer = new RandomAccessFile(file1,"rw");

                int len = -1;
                int size = moSize;
                byte[] flush = new byte[1];
                reader.seek((i-1)*moSize);

                System.out.println("\n\n================================================模块"+i+"================================================\n");
                if (i != count){
                    while ((len = reader.read(flush)) != -1){
                        if (size > len){
                            writer.write(flush,0,len);
                            System.out.print(new String(flush,0,len));
                            size -= len;
                        }else {
                            writer.write(flush,0,size);
                            System.out.print(new String(flush,0,size));
                            break;
                        }
                    }
                }else {
                    while ((len = reader.read(flush)) != -1){
                        writer.write(flush,0,len);
                        System.out.print(new String(flush,0,len));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
