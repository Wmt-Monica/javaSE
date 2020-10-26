package IO;

import java.io.*;

/**
 * 练习：使用递归，实现文件夹的拷贝
 */
public class copyDirectory {

    //创建一个方法用于遍历目录并Copy目录整个目录树
    public static void CopyDirectory(File inputFile , File outputFile){

        if (inputFile.isFile()){  //如果是文件就在要Copy的目的文件中创建新的文件
            File newOutputFile = new File(outputFile,inputFile.getName());
            try {
                newOutputFile.createNewFile();
                CopyFileData(inputFile,newOutputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {  //如果是文件夹就遍历文件夹
            //1.首先创建目录
            File newOutputFile = new File(outputFile,inputFile.getName());
            newOutputFile.mkdirs();
            //2.遍历目录，再重新调用自身，进行文件和文件夹的判断
            for (File file : inputFile.listFiles()){
                CopyDirectory(file,newOutputFile);
            }
        }
    }

    //创建一个方法用于文件的内容的拷贝
    public static void CopyFileData(File inputFile,File outputFile){
        try {
            //1.数据源的选择
            InputStream input = new FileInputStream(inputFile);
            OutputStream output = new FileOutputStream(outputFile);

            //2.拷贝的操作
            byte[] flush = new byte[20];  //写入数据的中间缓存字节数组（20字节）
            int length = -1;  //用于存储读取到了多少字节的数据
            while ((length = input.read(flush)) != -1){  //未到数据的末尾
                output.flush();  //写入数据前的刷新
                output.write(flush,0,length);  //写入数据
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("D:/github上传的文件/Wmtprogram2/javaSE/src");
        File outputFile = new File("D:/github上传的文件/JavaTxtSet");
        CopyDirectory(inputFile,outputFile);
    }
}
