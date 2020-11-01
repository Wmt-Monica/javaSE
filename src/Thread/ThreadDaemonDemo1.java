package Thread;

/**
 * Daemon:守护线程
 * 守护线程是为用户线程服务的，jvm停止不用等待守护线程执行完毕
 * 默认：用户线程jvm等待用户线程执行完毕才会停止（当不指定时，所有的线程都为用户线程）
 */
public class ThreadDaemonDemo1 {
    public static void main(String[] args) {
        DaemonDemo1 user = new DaemonDemo1();
        DaemonDemo2 daemon = new DaemonDemo2();
        Thread t = new Thread(daemon,"WMT");
        t.setDaemon(true);  //传入参数true表示该线程对象被赋予守护线程
        new Thread(user,"SF").start();  //凡是没有设没有设定守护线程的线程对象默认是用户线程
        t.start();

    }
}

class DaemonDemo1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++){
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("用户线程："+Thread.currentThread().getName()+"---->"+i);
        }
    }
}

class DaemonDemo2 implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("守护线程："+Thread.currentThread().getName()+i++);
        }
    }
}