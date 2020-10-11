/**
 *  使用递归遍历文件目录
 * */
package File;

import java.io.File;

public class File_2 {
    public static void main(String[] args) {
        File file = new File("D:\\123\\JavaProgramTest");
        readFileName(file,0);
    }
    static void readFileName(File file,int num){
        for (int i = 0 ; i < num ; i++){
            System.out.print("----");
        }
        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] files = file.listFiles();  //File文件的集合存入File文件数组
            for (File file1: files
                 ) {
                readFileName(file1,num+1);
            }
        }
    }
}
