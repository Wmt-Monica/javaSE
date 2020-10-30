package Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 实现多线程出来而的方法：
 * 1.继承Thread （常用）
 * 2.实现Runnable接口 （常用）（推荐）
 * 3.实现Callable接口（不常用）
 *
 * 案例：实现下载网络图片资源
 * (会按照其中的方法会用即可， 现在不用过于深入)
 */
public class implementsCallableDemo1 {
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

        //创建目标对象
        downPicture down1 = new downPicture(url1,fileSrc1);
        downPicture down2 = new downPicture(url2,fileSrc2);
        downPicture down3 = new downPicture(url3,fileSrc3);
        downPicture down4 = new downPicture(url4,fileSrc4);
        downPicture down5 = new downPicture(url5,fileSrc5);

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(5);  //开辟五个服务

        //提交执行
        Future<Boolean> result1 = service.submit(down1);
        Future<Boolean> result2 = service.submit(down2);
        Future<Boolean> result3 = service.submit(down3);
        Future<Boolean> result4 = service.submit(down4);
        Future<Boolean> result5 = service.submit(down5);

        //获取结果
        try {
            System.out.println("图片1是否下载成功："+result1.get());
            System.out.println("图片2是否下载成功："+result2.get());
            System.out.println("图片3是否下载成功："+result3.get());
            System.out.println("图片4是否下载成功："+result4.get());
            System.out.println("图片5是否下载成功："+result5.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //关闭服务
        service.shutdownNow();
    }
}

class downPicture implements Callable {

    String url;
    String fileSrc;

    public downPicture(String url, String fileSrc) {
        this.url = url;
        this.fileSrc = fileSrc;
    }

    @Override
    public Object call() throws Exception {  //实现Callable接口，重写call方法，有返回值，可以抛出异常
        File file = new File(fileSrc);
        if (!file.exists()){  //如果文件不存在就根据路径创建文件
            file.createNewFile();
        }

        FileUtils.copyURLToFile(new URL(url),file);  //拷贝文件
        System.out.println("拷贝成功...");
        return true;
    }
}