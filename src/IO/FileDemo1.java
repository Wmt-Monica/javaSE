package IO;

import java.io.File;
import java.io.IOException;

/**
 * File:文件类
 * InputStream:字节输入流
 * OutputStream:字节输出流
 * Reader:字符输入流
 * Write:字符输出流
 * Closeable:关闭流接口
 * Flushable:刷新流接口
 * Serializable:序列化接口
 *
 * 输入流：数据源到程序(InputStream,Reader读出来)
 * 输出流：程序到目的地(OutputStream,Write写出去)
 */

public class FileDemo1 {

    public static void main(String[] args) throws IOException {
        //文件路径使用字符串来存储，其中文件路径分隔符使用'\'使用转义字符'\'进行转义
        String s1 = "D:\\github上传的文件\\JavaTxtSet\\2020_10_24.txt";
        //如果不使用转义字符转义，我们最常用的事反斜杠'/'
        String s2 = "D:/github上传的文件/JavaTxtSet/2020_10_24.txt";
        //除此之外还可以使用常量来进行拼接，使用File.separator获取文件路径的分隔符
        String s3 = "D:"+ File.separator+"github上传的文件"+File.separator+"JavaTxtSet"+File.separator+"2020_10_24.txt";
        System.out.println("\n使用File.separator获取文件分隔符定义文件路径字符串\n"+s3);

        /**
         * 一：
         * 构造文件对象的构造方法
         *
         * 相对路径与绝对路径
         * 1):存在盘符：绝对路径
         * 2):不存在盘符：相对路径
         */
        //1.构造File对象
        File src = new File(s1);
        System.out.println("\n2020_10_24.txt文件的字节长度："+s1.length());//返回文本的长度

        //2.构造对象 (父路径，子路径)/(父文件，子路径) 无特殊要求，就是两个字符串拼接成为一个完整的文件路径
        src = new File("D:/github上传的文件/JavaTxtSet","2020_10_24.txt");
        src = new File("D:/github上传的文件","JavaTxtSet/2020_10_24.txt");
        src = new File(new File("D:/github上传的文件/JavaTxtSet"),"2020_10_24.txt");

        //文件名，路径名
        /**
         * 二：
         * getName()：名称
         * getPath(): 相对，绝对
         * getAbsolutePath()：绝对
         * getParent()：上路径 没有上路径就返回null
         */
        System.out.println("\n文件名"+src.getName());//获取文件名
        System.out.println("\n获取文件的路径："+src.getPath());  //存入的相对/绝对路径就输出相对/绝对路径
        File src1 = new File("2020_10_24.txt");
        System.out.println("\n获取文件的路径："+src1.getPath());
        System.out.println("\n使用getAbsolutePath()返回绝对路径："+src1.getAbsolutePath());

        //文件状态
        /**
         * 三：
         * 1.判断文件是否存在：exists()
         *
         * 2.当存在时，
         *      1）：文件 isFile()
         *      2）：文件夹 isDirectory
         */
        System.out.println("\n该目录下2020_10_24.txt文件是否存在："+src.exists());
        System.out.println("\n判断2020_10_24.txt是否为一个文件："+src.isFile());
        System.out.println("\n判断2020_10_24.txt是否为一个文件夹："+src.isDirectory());

        //创造与删除文件
        /**
         * 四：
         * createNewFile()创建文件 补充：con,com3...操作系统的设备名，不能被成功创建
         * delete()删除文件
         */
        File file = new File("D:/github上传的文件/JavaTxtSet/2020_10_24Demo1.txt");
        //创建文件时可能会有创建失败的错误，所以此处方法体需要抛出IOException错误
        boolean flag = file.createNewFile();
        System.out.println("\n2020_10_24Demo1文件是否创建成功："+flag);
        //使用createNewFile()创建的都是文件不是文件夹
        System.out.println("\n2020_10_24Demo1.txt是否为一个文件："+file.isFile());
        System.out.println("\n2020_10_24Demo1.txt是否为一个文件夹："+file.isDirectory());

        /**
         * 五：
         * 创建目录：
         *      1):mkdir():确保上级目录存在，否则创建失败
         *      2):mkdirs():上级目录可以不存在，假如不存在就一同创建
         * 下级：
         *      1):list() 返回下级名称
         *      2):listFiles() 返回下级File对象
         *      3):listRoots() 返回根路径
         */
        File file1 = new File("D:/github上传的文件/JavaTxtSet/mkd/2020_10_24Demo2");
        File file2 = file1.getParentFile();  //getParentFile()方法时返回上级File对象
        System.out.println("\n使用mkdir()创建2020_10_24Demo2是否成功："+file1.mkdir()); //使用mkdir()方法创建对象
        System.out.println("\n使用mkdirs()创建2020_10_24Demo2是否成功："+file1.mkdirs()); //使用mkdirs()方法创建对象
        System.out.println("\n2020_10_24Demo是否为一个目录："+file2.isDirectory());

        /**
         * 六：
         * 文件夹统计：遍历文件夹
         */
        File file3 = new File("D:/github上传的文件/Wmtprogram2/javaSE/src");
        listFilesDemo(file3); //遍历文件夹里面的文件夹目录里面的文件，并打印文件名
        System.out.println("\nsrc目录下所有文件的大小："+countFileSize(file3));

        /**
         * 七：
         * 使用对象的方式获取文件的大小和文件夹的个数和文件的个数
         */
        CountFilesSize filesSize = new CountFilesSize("D:/github上传的文件/Wmtprogram2/javaSE/src");
        System.out.println("\n文件的大小:"+filesSize.getSize());
        System.out.println("\n文件夹的个数："+filesSize.getFileDirectory());
        System.out.println("\n文件的个数："+filesSize.getFiles());

    }

    //========================打印目录=============================
    public static void listFilesDemo(File file){
        if (!file.exists()){
            return;
        }else{
            if (file.isFile()){ //如果是文件不是文件夹就直接输出文件名
                System.out.println("------"+file.getName());
            }else {
                System.out.println("---"+file.getName());
                for (File f : file.listFiles()){
                    listFilesDemo(f);
                }
            }
        }
    }

    //=========================使用方法的方式计算文件的大小========================
    static int Size = 0;
    public static int  countFileSize(File file){
        if (file.exists()){
            if (file.isFile()){
                Size += file.length();
            }else{
                for (File f : file.listFiles()){
                    countFileSize(f);
                }
            }
        }
        return Size;
    }

}

//================使用面向对象的方式计算文件夹的大小和计算文件夹的个数和文件个数=================
class CountFilesSize{
    private long size = 0;  //目录的总大小
    private int FileDirectory = 0; //文件夹的个数
    private int Files = 0;  //文件个数
    private String s;  //文件路径

    //遍历文件夹计算文件大和文件个数
    private void Count(File file){
        if (!file.exists()){
            System.out.println("文件不存在！");
        }else {
            for (File file1 : file.listFiles()){
                if (file1.isFile()){
                    size += file1.length();
                    Files++;
                }else {
                    FileDirectory++;
                    Count(file1);
                }
            }
        }
    }

    public CountFilesSize(String s){
        this.s = s;
        File file = new File(this.s);
        if (!file.exists()){
            throw new RuntimeException("该文件不存在！");
        }else {
            Count(file);
        }
    }

    public long getSize() {
        return size;
    }

    public int getFileDirectory() {
        return FileDirectory;
    }

    public int getFiles() {
        return Files;
    }

}














