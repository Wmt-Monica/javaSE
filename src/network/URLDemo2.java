package network;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 利用URL爬虫来获取网络资源
 */
public class URLDemo2 {
    public static void main(String[] args) throws IOException {
        /**
         * 有些网站不设置权限，我们可以铜鼓资源定位器URL来获取资源
         * 但是有些网站资源是设置了权限的，我们无法通过URL直接获取资源
         * 这是我们需要使用浏览器的打开方式获取资源：HttpURLConnection类
         */
        //获取URL
        URL url_1 = new URL("http://dreamplume.cn/js/shou-ye.js");
        //创建存放资源的
        File file1 = new File("D:/github上传的文件/JavaTxtSet/2020_11_9Demo1.txt");
        //下载资源
        FileUtils.copyURLToFile(url_1,file1);

        //http://dianping.cn设置了权限，我们需要使用浏览器的方式打开
        URL url_2 = new URL("http://dianping.com");
        File file2 = new File("D:/github上传的文件/JavaTxtSet/2020_11_9Demo2.txt");
        HttpURLConnection conn = (HttpURLConnection) url_2.openConnection();  //这里使用强制转换以下类型
        conn.setRequestMethod("GET");  //这里是选择操作方法：获取（GET）
        //以下的资源是 1.点击F12    2.找到Headers     3.找到Request Headers     4.找到User_Agent
        //注意：此处复制的Request Headers中的User-Agent后面不要使用冒号:.使用逗号隔开
        conn.setRequestProperty("Mozilla/5.0","(Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.113 Safari/537.36");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        String flush = null;
        while ((flush = reader.readLine()) != null){
            writer.write(flush);
        }

        System.out.println("获取资源成功....");
    }
}





























