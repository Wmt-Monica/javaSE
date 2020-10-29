package IO;

import java.io.*;

/**
 * 打印流：
 * PrintStream / PrintWriter
 */
public class PrintDemo1 {
    public static void main(String[] args) {
        //打印流：System.out
        PrintStream print = System.out;
        //使用此方法可以同样的实现将数据打印在控制台上（可以有着打印简化的作用）
        print.println("王梦婷和石燔");
        print.println("LOVE");

        //除了打印在控制台上，还可以写入在文件中
        try {
            print = new PrintStream(
                    new BufferedOutputStream(
                            new FileOutputStream
                                    ("D:/github上传的文件/JavaTxtSet/2020_10_29Demo2.txt")),true);
            print.println("王梦婷和石燔");
            print.println("LOVE");
//            print.flush();  //如果不使用在BufferedOutputStream后面添加布尔参数true,可以使用执行flush()方法来达到刷新效果
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //重新定义输入端
        System.setOut(print);  //将打印后的结果的输出重新定义到print所指向的2020_10_29Demo2.txt文件中
        System.out.println("I love java");

        //如果想将输出端重新定义到控制台中 就将输出的文件指定为FileDescriptor.out
        System.setOut(
                new PrintStream(
                        new BufferedOutputStream(
                                new FileOutputStream
                                        (FileDescriptor.out)),true));
        System.out.println("输出到控制台");

        //使用PrintWriter
        try {
            PrintWriter writer =
                    new PrintWriter(
                            new BufferedOutputStream(
                                    new FileOutputStream
                                            ("D:/github上传的文件/JavaTxtSet/2020_10_29Demo3.txt")),true);
            writer.write("I Love SF SB!");
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
