package Thread;

/**
 *  其他方法：
 *  isAlive:线程是否还活着
 *  Thread.currentThread():获得当前线程对象
 *  setName(),getName():设置和获得线程对象的代理名称
 *
 *  注意：在计算线程有几个处于活跃状态的Thread.activeCount()方法计算时，
 *  这里除了线程thread1和thread2还有main线程（主线程），同时idea用的是反射，还有一个monitor监控线程。
 *  故因此在运行时回显示有四个线程，并且在除非main(主线程)停止运行，监控线程才会停止
 */
public class ThreadQiTaFangFaDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1;
        Thread thread2;

        thread1 = new Thread(new QiTaDemo1("WMT"));
        thread2 = new Thread(new QiTaDemo1("SF"),"SB");

        thread1.start();
        thread2.start();

        int num = Thread.activeCount();
        while (num != 2){
            num = Thread.activeCount();
            Thread.sleep(250);
            System.out.println("还有几个线程运行状态："+num);
            Thread.sleep(250);
            System.out.println("thread1线程是否还活着："+thread1.isAlive());
            Thread.sleep(250);
            System.out.println("thread2线程是否还活着："+thread2.isAlive());
            Thread.sleep(250);
        }
    }
}

class QiTaDemo1 implements Runnable{

    String name;

    public QiTaDemo1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++){
            try {
                Thread.sleep(1000);
                System.out.println(this.name+"---->"+Thread.currentThread().getName()+"---->"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}