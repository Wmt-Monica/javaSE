package Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 使用多线程来下载网络图片
 * 1.创建多个线程
 * 2.使用commons里面包装好的IO包
 * 注意：可以使用该方法对网上收费的网络图片资源进行拷贝，实现免费获取资源
 */
public class DownloadPicture {
    public static void main(String[] args) {
        //创建URL路径
        String url1 = "https://img.zcool.cn/community/01ebc25e212f6aa801216518fdf0ba.jpg@1280w_1l_2o_100sh.jpg";
        String url2 = "https://img.zcool.cn/community/016c285e212f6aa80120a895b761d8.jpg@1280w_1l_2o_100sh.jpg";
        String url3 = "https://img.zcool.cn/community/019aff5e212f6ba801216518020272.jpg@1280w_1l_2o_100sh.jpg";
        String url4 = "https://img.zcool.cn/community/01d1e85e212f6ba80120a895fec87c.jpg@1280w_1l_2o_100sh.jpg";
        String url5 = "https://img.zcool.cn/community/0116185e212f6ba80121651889e1e4.jpg@1280w_1l_2o_100sh.jpg";

        //创建下载文件的路径
        String fileSrc1 = "D:/github上传的文件/JavaTxtSet/2020_10_30/1.png";
        String fileSrc2 = "D:/github上传的文件/JavaTxtSet/2020_10_30/2.png";
        String fileSrc3 = "D:/github上传的文件/JavaTxtSet/2020_10_30/3.png";
        String fileSrc4 = "D:/github上传的文件/JavaTxtSet/2020_10_30/4.png";
        String fileSrc5 = "D:/github上传的文件/JavaTxtSet/2020_10_30/5.png";

        //创建多个线程对象
        download load1 = new download(url1,fileSrc1);
        download load2 = new download(url2,fileSrc2);
        download load3 = new download(url3,fileSrc3);
        download load4 = new download(url4,fileSrc4);
        download load5 = new download(url5,fileSrc5);

        //启动线程
        load1.start();
        load2.start();
        load3.start();
        load4.start();
        load5.start();
    }
}

//创建一个利用多线程下载图片的对象
class download extends Thread{
    private String url;
    private String fileSrc;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileSrc() {
        return fileSrc;
    }

    public void setFileSrc(String fileSrc) {
        this.fileSrc = fileSrc;
    }

    //构造器
    public download(String url, String fileSrc) {
        this.url = url;
        this.fileSrc = fileSrc;
    }

    public void downloadURL(){  //拷贝URL 文件的方法
        try {
            File file = new File(fileSrc);  //创建文件对象
            if (!file.exists()){  //假如文件不存在就创建按照文件的路径创建文件
                file.createNewFile();
            }
            FileUtils.copyURLToFile(new URL(this.url),file);  //使用commons包装好的FileUtils的拷贝网络资源
            System.out.println("图片拷贝成功...");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载失败");
        }
    }

    //创建使用多线程来下载文件的方法
    //重写run()方法
    @Override
    public void run() {
        downloadURL();  //调用拷贝URL文件的方法
    }

}
