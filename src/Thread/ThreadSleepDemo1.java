package Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep(时间)指定当前线程阻塞的毫秒数；
 * sleep存在异常InterruptedException
 * sleep时间达到后线程重新进入就绪状态
 * sleep可以模拟网络延迟，倒计时等
 * 每个对象都有一个锁，sleep不会释放锁，相对于wait()的区别
 *
 * 案例：倒计时
 */
public class ThreadSleepDemo1 {
    public static void main(String[] args) {
        new Thread(new SleepDemo1()).start();
    }
}

//案例：十秒倒计时
class SleepDemo1 implements Runnable{

    //重写run()方法
    @Override
    public void run() {
        Date startTime = new Date(System.currentTimeMillis());  //定义起始时间
        long end = startTime.getTime()+1000*10;  //标好倒计时后十秒后的结尾时间
        while (startTime.getTime() <= end){  //当在该十秒时间以内输出时间
            System.out.println(new SimpleDateFormat("hh:mm:ss").format(startTime));
            try {
                Thread.sleep(1000);  //每打印一次时间就休眠1秒
                startTime = new Date(startTime.getTime()+1000);  //将开始时间重新向后移1秒,重新定义
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}