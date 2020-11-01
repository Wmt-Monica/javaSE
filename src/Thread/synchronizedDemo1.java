package Thread;

/**
 * 将线程经量做到三高：
 * 1.高性能
 * 2.高并发
 * 3.高可用
 *
 * 注意需要用到synchronized的情况：
 *      多个线程对象访问同一个对象时，并且某些线程还需要修改这个对象，这时我们需要用到线程同步
 *
 * 1.一个线程持有锁会导致其他所有需要此锁的线程挂起
 * 2.在多个线程竞争下，加锁，释放锁会导致比较多的上下切换和调度延时引起的性能问题
 * 3.如果一个优先级高的线程在等待一个优先级低的线程释放锁会导致优先级倒置，引起的性能问题
 *
 * synchronized关键字的两种使用方法：synchronized方法 和 synchronized块
 *
 * 案例一：售票
 *
 */
public class synchronizedDemo1 {
    public static void main(String[] args) {

        sellTicket huangNiu = new sellTicket();
        //创建一个三个线程对象
       Thread thread1 = new Thread(huangNiu,"WMT");
       Thread thread2 = new Thread(huangNiu,"SF");
       Thread thread3 = new Thread(huangNiu,"SF_SB");

       //对线程进行优先级的调度
        thread1.setPriority(Thread.MAX_PRIORITY);  //优先级最高（10）
        thread2.setPriority(Thread.MIN_PRIORITY);  //优先级最低（0）
        thread3.setPriority(Thread.NORM_PRIORITY);  //优先级中等（5）

        //启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

//售票
class sellTicket implements Runnable {
    int ticket = 100;  //初始化票数，一共一百张门票
    boolean flag = true;

    @Override
    public void run() {

        while (flag){

            if (ticket <= 0){
                flag = false;
                System.out.println("票已经售空，欢迎下次光临...");
            }else {
                try {
                    Thread.yield();  //线程进行礼让
                    Sell();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"---->"+"剩余票数："+ticket);
            }
        }


        //以下售票方法，会导致线程不安全，需要借助 synchronized关键字
    /*    while (true){
            if (ticket <= 0){
                System.out.println("门票已经售空，欢迎下次光临....");
                return;
            }else {
                ticket--;
                System.out.println(Thread.currentThread().getName()+"---->剩余门票"+ticket+"\n");
            }
        }
    */

    }

    /**
     *  锁住的不是方法，是一个对象里面的属性
     *  例如：这里锁着的是 sellTicket 对象中的 ticket 属性的值
     */
    public synchronized void Sell() throws InterruptedException {
        Thread.sleep(500);
        ticket--;
    }
}




















