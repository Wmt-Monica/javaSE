package Thread;

/**
 * Java提供了三个方法用于解决线程之间的通信问题
 * wait:线程在等待
 * notifiy:唤醒一个处于等待状态的线程
 * notifyAll:唤醒同一个对象上所有调用wait()方法的线程，优先级高的优先被调用
 *  注意：以上三种方法调用必须在 synchronized 语句块中才能被执行
 *        且锁住的对象与我们控制等待或者是释放的对象保持一致
 *
 * 案例：过马路（信号灯法）
 *      根据每一个属性的值来判断是哪一个线程对象执行
 *
 */
public class ThreadWaitDemo2 {
    public static void main(String[] args) throws InterruptedException {

        //创建马路对象
        Rode rode = new Rode("紫阳路");

        //创建行人对象
        String name = "WMT";
        String name2 = "SF";
        for (int time = 0; time < 100; time++){
            rode.Change();
            new Thread(new PassersBy((name+(rode.PeopleCount)),rode)).start();
            new Thread(new CarBy((name2+(rode.CarCount)),rode)).start();
        }
    }
}

//创建马路对象
class Rode{
    String name;  //创建马路对象的路名属性
    //创建红绿灯对象：false:表示红灯 true:表示绿灯
    boolean trafficLights = false;
    int PeopleCount = 0;  //用于记录马路一共走过的行人的数量
    int CarCount = 0;  //用于记录马路一共走过的车辆的数量

    //构造器
    public Rode(String name) throws InterruptedException {
        this.name = name;
    }

    public void Change() throws InterruptedException {
        Thread.sleep(1000);
        this.trafficLights = (!this.trafficLights);
    }

}

//创建行人对象
class PassersBy implements Runnable{
    String name;  //行人姓名属性
    Rode rode;  //创造公共对象马路

    //构造器
    public PassersBy(String name,Rode rode) {
        this.name = name;
        this.rode = rode;
    }

    @Override
    public void run() {
        synchronized (rode){
            while (rode.trafficLights == true){
                try {
                    Thread.sleep(600);  //行人过马路的时间耗时600ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rode.notifyAll();
                PasserDemo();
            }
            try {
                rode.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //创建行人过马路的方法
    public void PasserDemo(){
        System.out.println(this.name+"是第"+(++rode.PeopleCount)+"个成功穿过马路的行人");
    }
}

//创建车辆对象
class CarBy implements Runnable{
    String name;  //车辆名字
    Rode rode;  //创造公共对象马路

    //构造器
    public CarBy(String name,Rode rode) {
        this.name = name;
        this.rode = rode;
    }


    @Override
    public void run() {
        synchronized (rode){
            while (rode.trafficLights == false){
                try {
                    Thread.sleep(200);  //车辆过马路的时间耗时200ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rode.notifyAll();
                CarDemo();
            }
            try {
                rode.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //创建车辆过马路的方法
    public void CarDemo(){
        System.out.println(this.name+"是第"+(++rode.CarCount)+"个成功穿过马路的驾驶员");
    }
}