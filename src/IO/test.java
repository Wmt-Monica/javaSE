package IO;

import java.io.File;

public class test {
    public static void main(String[] args) {
        File file = new File("D:/github上传的文件/JavaTxtSet/mkd/2020_10_24Demo2");
        File file2 = new File("D:/github上传的文件/JavaTxtSet");
        String name = file.getName();
        File file1 = new File(file2,name);
        file1.mkdirs();
    }
}
