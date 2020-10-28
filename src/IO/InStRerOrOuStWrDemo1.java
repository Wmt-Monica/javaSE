package IO;

import java.io.*;

/**
 * 转换流：inputStreamReader / OutputStreamWrite
 * 1.以字符流的形式操作字节流
 * 2.指定字符集
 */
public class InStRerOrOuStWrDemo1 {
    public static void main(String[] args) {
        //在使用InputStreamReader/OutputStreamWriter类的同时，使用BufferedReader，利用缓存区来提高读取数据的速度，提高性能
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(System.out));
        String s = "";
        try{
          while (!s.equals("exit")){
              s = reader.readLine();  //读取一行的数据
              writer.write(s);  //写入数据
              writer.newLine();  //写一行数据后进行写入换行
              writer.flush();  //使用BufferedWriter类，其缓存区空间很大，故应此此处强制刷新
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
