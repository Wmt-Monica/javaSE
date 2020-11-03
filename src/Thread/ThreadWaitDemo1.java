package Thread;

import java.util.LinkedList;
import java.util.List;

/**
 * Java提供了三个方法用于解决线程之间的通信问题
 * wait:线程在等待
 * notifiy:唤醒一个处于等待状态的线程
 * notifyAll:唤醒同一个对象上所有调用wait()方法的线程，优先级高的优先被调用
 *  注意：以上三种方法调用必须在 synchronized 语句块中才能被执行
 *        且锁住的对象与我们控制等待或者是释放的对象保持一致
 *
 * 案例：生产汉堡的店面（管道法）
 *      注意：这里商家和顾客是根据汉堡容器来进行交流的
 */
public class ThreadWaitDemo1 {
    public static void main(String[] args) {
        //创建公共的汉堡对象
        Hamburger hamburger = new Hamburger(0);

        //创建生产商对象
        Business business = new Business(hamburger);
        new Thread(business).start();

        //创建顾客对象
        new Thread(new Customer("WMT",hamburger)).start();
        new Thread(new Customer("SF",hamburger)).start();

    }
}

//创建汉堡对象
class Hamburger{
    int id;  //给汉堡进行编号
    List<Hamburger> hamburgers = new LinkedList<Hamburger>();  //创建汉堡容器对象

    //构造器
    public Hamburger(int id) {
        this.id = id;
    }

    //创建对汉堡容器中汉堡数量计算的方法
    public int Count(){
        int count = 0;
        for (Hamburger h : hamburgers){
            count++;
        }
        return count;
    }
}

//创建一个商家类
class Business implements Runnable{
    int id = 0;  //用于计算生产商一共生产的汉堡个数，同时为汉堡编号
    Hamburger hamburger = new Hamburger(this.id);  //创建汉堡对象

    //构造器
    public Business(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            /*synchronized (this.hamburger)*/{
                if (!ProduceJudge()){
                    try {
                        synchronized (this.hamburger){
                            this.hamburger.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    synchronized (this.hamburger){
                        this.hamburger.notifyAll();
                        Produce();
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //生产汉堡的方法
    public void Produce() throws InterruptedException {

        /*if (!ProduceJudge()){  //如果汉堡容器未滞留10个就继续生产
            this.wait();  //当汉堡容器已经滞留了10个汉堡时，将线程停止(停止生产汉堡)
        }
        notify();  //将之前设置为等待的线程全部启动*/
        Hamburger h = new Hamburger(id++);
        System.out.println("生产了第"+id+"个汉堡....");
        hamburger.hamburgers.add(h);  //将制作好的汉堡存入容器当中
    }

    //创建是否要继续生产汉堡的判断
    public boolean ProduceJudge(){
        //当生产汉堡的容器中已经滞留了10个汉堡时，返回false,通知停止生产
        if (hamburger.Count() == 10){
            return false;
        }
        return true;
    }

}

//创建一个顾客类
class Customer implements Runnable{
    String name;  //用于记录顾客的姓名
    int id = 0;  //用于记录该顾客消费了多少个汉堡
    Hamburger hamburger = new Hamburger(this.id);

    //构造器
    public Customer(String name, Hamburger hamburger) {
        this.name = name;
        this.hamburger = hamburger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++){
            /*synchronized (this.hamburger)*/{
                if (!ConsumeJudge()){
                    try {
                        synchronized (this.hamburger){
                            this.hamburger.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    synchronized (this.hamburger){
                        this.hamburger.notifyAll();
                        Consume();
                    }
                    Thread.sleep(1000);
                    System.out.println(this.name+"消费了第"+(++id)+"个汉堡");
                    System.out.println("汉堡店还剩"+hamburger.Count()+"个汉堡\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费汉堡的方法
    public void Consume() throws InterruptedException {
        /*if (!ConsumeJudge()){
            this.wait();  //当汉堡容器没有汉堡时，将该线程停止
        }
        notify();  //当汉堡容器有汉堡时，将原先暂停的顾客线程全部启动*/
        //从汉堡容器的第一个(0)开始移除Hamburger对象
        hamburger.hamburgers.remove(hamburger.hamburgers.get(0));
    }

    //创建方法判断汉堡容器中有汉堡可以消费
    public boolean ConsumeJudge(){
        if (hamburger.Count() == 0){
            return false;
        }
        return true;
    }

}























