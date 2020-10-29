package IO;

import java.io.*;

/**
 * 对象流：
 * ObjectInputStream / ObjectOutputStream
 *
 * 在ObjectStreamDemo1的基础上将数据写入到文件中去，并读取到文件中去
 */
public class ObjectStreamDemo2 {
    public static void main(String[] args) {
        try {
            //写入数据到2020_10_29Demo1.txt中
            ObjectOutputStream output =
                    new ObjectOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream
                                            ("D:/github上传的文件/JavaTxtSet/2020_10_29Demo1.txt")));
            Employ e = new Employ("王梦婷",23000);
            output.writeObject(e);  //写入Employ数据对象
            output.flush();  //刷新数据
            output.close();  //关闭流

            //读取2020_10_29Demo1.txt文件中的数据
            ObjectInputStream input =
                    new ObjectInputStream(
                            new BufferedInputStream(
                                    new FileInputStream
                                            ("D:/github上传的文件/JavaTxtSet/2020_10_29Demo1.txt")));
            Object o = input.readObject();
            if (o instanceof  Employ){
                Employ employ = (Employ) o;
                System.out.println(employ);
            }

            input.close();  //关闭流
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
