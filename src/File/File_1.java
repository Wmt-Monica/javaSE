package File;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File_1 {
    public static void main(String[] args) throws IOException {

        //指定目录的文件对象,将目录的位置传入，如果使用反斜杠则要用两条，起到转义的作用，也可以受用单斜杠
        File file1 = new File("D:\\123");
        File file2 = new File("D:/123/JavaProgram");
        File file3 = new File("java.txt");  //当不指定路径则会默认在指定本目录下
        //打印文件对象只是将文件对象的指定地址打印出来,如果需要打印文件内容则需要用到IO流中的内容
        System.out.println("file1:"+file1);
        System.out.println("file2:"+file2);
        //可以对文件进行改文件名的操作
        file2.renameTo(new File("D:\\123\\JavaProgramTest"));

        //格式化时间：输出文件最后一次修改的时间的输出格式
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        Date date = new Date(file1.lastModified());  //file1.lastModified()输出file1文件最后一次修改的时间参数传入
        String str = simpleDateFormat.format(date);

        //除此之外File还有很多其他的方法
        System.out.println("File文件是否存在："+file1.exists());
        System.out.println("File文件是否为一个目录："+file1.isDirectory());
        System.out.println("File是否是一个文件："+file1.isFile());
        System.out.println("File最后修改的时间："+str);
        System.out.println("File的所占内存大小："+file1.length());
        System.out.println("File的文件名："+file1.getName());
        System.out.println("File的目录路径："+file3.getPath());//如果文件指向当前目录则用getPath()方法只是会打相对路径
        System.out.println("File的目录路径："+file3.getAbsolutePath());//用getAbsolutePath()则会打印出绝对路径

        //创建文件
        File file4 = new File("D:\\123\\JavaProgramTest\\one.txt");
        System.out.println("file4是否存在："+file4.exists());//创建前判断文件是否存在fault
        file4.createNewFile();  //此处需要抛出或者捕捉一下  IOException异常
        System.out.println("file4是否存在："+file4.exists());//创建后判断文件是否存在true
        //删除文件
        file4.delete();
        System.out.println("file4删除后是否存在："+file4.exists());

        /**
         *  mkdir()和mkdirs()方法的区别
         * */
        File file5 = new File("D:\\123\\JavaProgram\\two");
        System.out.println("file5是否存在："+file5.exists());
        //使用mkdir()方法创建树目录在中间除了最后文件夹之外只要有一个不存在则创建失败
        file5.mkdir();
        System.out.println("file5是否创建成功："+file5.exists());
        //使用mkdirs()方法创建树目录，假如目录中间不存在的目录就会创建一个完整的目录
        file5.mkdirs();
        System.out.println("file5是否创建成功："+file5.exists());
    }
}
