package Thread;

/**
 * 当锁住的对象太多了，导致多线程中每个线程对象都占有着一个锁，
 * 但是获取对方线程中释放的锁，导致造成了死锁的现象
 *
 * 案例：WMT占用着口红，SF占用着镜子，双方偶不释放自己所占有的资源，
 *      导致双方都不能完成化妆
 */
public class deadlockDemo1 {
    public static void main(String[] args) {
        //创建公用的口红和镜子资源
        Lipstick lipstick = new Lipstick();
        Mirror mirror = new Mirror();

        //创建两个需要化妆的两个对象（WMT）（SF）
        MakeUpPeople people1 = new MakeUpPeople("WMT",lipstick,mirror);
        MakeUpPeople people2 = new MakeUpPeople("SF",lipstick,mirror);

        //启动化妆线程
        new Thread(people1).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(people2).start();

    }
}

//创建一个口红对象
class Lipstick{
    String name = "口红";  //实例口红对象的名字属性
    volatile boolean flag = false;  //用于判断是否占有口红资源的判断
}

//创建一个镜子对象
class Mirror{
    String name = "镜子";  //实例镜子对象的名字属性
    volatile boolean flag = false;  //用于判断是否占有镜子资源的判断
}

//创建一个需要化妆的人的对象
class MakeUpPeople implements Runnable{
    String name;  //设置需要化妆的人的名字
    int choice = 0;  //设置已经获得资源个数
    boolean flag = false;  //创建一个是否化好妆的判断
    Lipstick lipstick = new Lipstick();  //获得一个口红对象
    Mirror mirror = new Mirror();  //创建一个口红的对象

    //构造器
    public MakeUpPeople(String name,Lipstick lipstick,Mirror mirror) {
        this.name = name;
        this.lipstick = lipstick;
        this.mirror = mirror;
    }

    //重写run()方法
    @Override
    public void run() {

        while (this.flag != true){

            if (this.choice == 0){  //当需要化妆对象什么资源都没有占有的时候，就先尝试占有口红对象

                if (this.lipstick.flag == false){  //当口红资源未被占有时，尝试获取口红资源

                    synchronized (this.lipstick){
                        System.out.println(this.name+"占有了"+this.lipstick.name);
                        choice++;  //获得资源加1
                        this.lipstick.flag = true;  //确认已经占用了口红资源

                        try {  //休眠1秒
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        synchronized (this.mirror){  //当口红资源已经获得时尝试去占有镜子资源
                            System.out.println(this.name+"占有了"+this.mirror.name);
                            choice++;  //获得资源加1
                            this.mirror.flag = true;  //确认已经占用了镜子资源
                        }

                    }
                }else {  //如果当口红资源已经被占有，那么先尝试占有镜子资源

                    if (this.mirror.flag == false){  //当镜子资源未被占用时

                        synchronized (this.mirror){
                            System.out.println(this.name+"占有了"+this.mirror.name);
                            choice++;  //获得资源加1
                            this.mirror.flag = true;  //确认已经占用了镜子资源

                            try {  //休眠1秒
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            synchronized (this.lipstick){
                                System.out.println(this.name+"占有了"+this.lipstick.name);
                                choice++;  //获得资源加1
                                this.lipstick.flag = true;  //确认已经占用了口红资源
                            }

                        }
                    }
                }

            }else if (this.choice == 2){

                System.out.println(this.name+"已经化好妆了");
                try {  //休眠5秒
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.lipstick.flag = false;
                this.mirror.flag = false;
                flag = true;
            }
        }
    }
}
















