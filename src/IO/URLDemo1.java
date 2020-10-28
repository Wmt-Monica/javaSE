package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 将网络资源的爬虫代码拷贝
 */
public class URLDemo1 {
    public static void main(String[] args) {
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new URL("http://www.dreamplume.cn").openStream(),"UTF-8"))){
            String s = "";
            while ((s = reader.readLine()) != null){
                System.out.println(s);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
