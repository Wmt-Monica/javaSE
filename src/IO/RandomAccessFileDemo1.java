package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 随即读取和写入的流
 * RandomAccessFile
 *
 * 利用该类分割的功能实现分割文件和合并文件的功能
 */
public class RandomAccessFileDemo1 {
    public static void main(String[] args) {
//        String s = "D:/github上传的文件/JavaTxtSet/2020_10_29Demo4.txt";
        String s = "D:/github上传的文件/JavaTxtSet/src/Collection/ArrayList_1.java";
        groupFile group = new groupFile(500,s);
        //分割数据
        group.groupSplit();

        String s2 = "D:/github上传的文件/JavaTxtSet/2020_10_29Demo5.txt";
        group.FileCombine(s2);

    }
}

//使用对象的思维去创造一个实现将文件按照要分成每块数据的大小来分组类
class groupFile{
    int moSize;  //要求分割文件的单个文件的大小
    String src;  //存储要被分割文件的路径字符串
    List<String> FileSrc = new ArrayList<>();  //用于存储被分割后的所有零碎文件的路径的List容器
    public groupFile(int moSize,String src){
        this.moSize = moSize;
        this.src = src;
    }
    public void groupSplit(){
        File file = new File(this.src);
        long length = file.length();  //获取文件的大小
        int count = (int) Math.ceil((length*1.0)/(this.moSize));  //计算一共要分成几块数据源

        try {
            RandomAccessFile reader = new RandomAccessFile(new File(this.src),"r");
            for (int i = 1; i <= count; i++){
                //创建分模块的文件对象
                String src = "D:/github上传的文件/JavaTxtSet/2020_10_29/2020_10_29Demo"+i+".txt";
                File file1 = new File(src);
                FileSrc.add(src);  //将所有被分割后的文件路径存储在List容器当中去
                if (!file1.exists()){
                    file1.createNewFile();
                }
                RandomAccessFile writer = new RandomAccessFile(file1,"rw");

                int len = -1;
                int size = this.moSize;
                byte[] flush = new byte[1];
                reader.seek((i-1)*(this.moSize));

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

    //创建FileCombine()方法，实现多个模块文件合并的功能
    public void FileCombine(String src){
        File file = new File(src);  //要求合并后的文件的路径
        if (!file.exists()){  //假如文件不存在，就创建文件
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        OutputStream output = null;
        InputStream input = null;
        for (int i = 0; i < FileSrc.size(); i++){
            try {
                output = new BufferedOutputStream(
                        new FileOutputStream(src,true));
                input = new BufferedInputStream(
                        new FileInputStream(FileSrc.get(i)));

                int length = -1;
                byte[] flush = new byte[20];
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
}
