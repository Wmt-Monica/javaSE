package Thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务定时调度
 * java.util.Timer :类似一个闹钟的功能，本身实现的就是一个线程
 * java.util.TimerTask :是一个抽象类。改类实现了Runnable接口，所以该线程具备多线程的能力
 */
public class TimerTaskDemo1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();  //获取当前时间
        alarmClock clock = new alarmClock();
        Timer timer = new Timer();  //定义一个计时器

        //timer 定时器，clock我们继承TimerTask的线程类，此为过了1秒之后再执行clock中的run()方法
//        timer.schedule(clock,1000);
        System.out.println("=========================================");
        //三秒之后每隔一秒就执行一次
        timer.schedule(clock,3000,1000);

        for (int i = 0; i < 10; i++){
        }
    }
}

//创建一个闹钟类
class alarmClock extends TimerTask {

    @Override
    public void run() {
        System.out.println("当前时间："+System.currentTimeMillis());
    }
}