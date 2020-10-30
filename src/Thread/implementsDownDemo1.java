package Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 使用implements实现接口的方法来实现多线程的下载URL案例
 * 推荐使用实现接口的方式实现多线程，这样可以避免了Java中的单继承的局限性
 * 1.避免单继承的局限性
 * 2.方便共享资源
 */
public class implementsDownDemo1 {
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

        //如果我们只对该对象只调用一次，我们就可以采用匿名常见类来实现start()方法
        new Thread(new download2(url1,fileSrc1)).start();
        new Thread(new download2(url2,fileSrc2)).start();
        new Thread(new download2(url3,fileSrc3)).start();
        new Thread(new download2(url4,fileSrc4)).start();
        new Thread(new download2(url5,fileSrc5)).start();
    }
}

class download2 implements Runnable{  //实现Runnable接口

    private String url;
    private String fileSrc;

    public download2(String url, String fileSrc) {
        this.url = url;
        this.fileSrc = fileSrc;
    }

    @Override
    public void run() {
        try {
            File file = new File(fileSrc);
            if (!file.exists()){
                file.createNewFile();
            }
            FileUtils.copyURLToFile(new URL(this.url),new File(fileSrc));
            System.out.println("拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载失败");
        }
    }
}