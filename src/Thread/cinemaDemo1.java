package Thread;

import java.util.ArrayList;
import java.util.List;

/**
 *  案例：模拟多线程购买电影票
 */
public class cinemaDemo1 {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(10);
        Thread thread = new Thread(new People(cinema,2,4,6));
        Thread thread1 = new Thread(new People(cinema,3,8));
        Thread thread2 = new Thread(new People(cinema,6));
        Thread thread3 = new Thread(new People(cinema,1,5,7,9,10));
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Cinema{
    int seatCount;  //电影院的座位的个数
    List<Integer> list = new ArrayList<>();  //电影院座位号的编号

    public Cinema(int seatCount) {
        this.seatCount = seatCount;
        for (int i = 1; i <= this.seatCount; i++){
            this.list.add(i);
        }
        System.out.println(list);
    }
}

//创建看电影的people类
class People implements Runnable{

    Cinema cinema;  //创建电影院对象
    List<Integer> peoples = new ArrayList<>();  //要购买票的人的座位号
    int peopleCount = 0;  //记录要购买票的电影票数

    //构造器
    public People(Cinema cinema,int...seat) {
        this.cinema = cinema;
        for (int i : seat){
//            System.out.println("要购买的座位号："+i);
            this.peoples.add(i);
            peopleCount++;
        }
    }

    @Override
    public void run() {
        int count = 0;
        for (int i : this.cinema.list){
            count++;
        }
        if (count > 0){
            Spend(this.peoples);
//            System.out.println("电影院的总座位数为："+count);
        }else {
            System.out.println("电影院已满，欢迎明天再来....");
            return;
        }
    }

    //传入要购买的座位号来进行买票
    public void Spend(List<Integer> peoples){  //使用...来表示多个参数传入

        synchronized (cinema){
            //计算要购买的座位的容器和电影院剩余座位号相交的个数
            List<Integer> step = new ArrayList<>();
            step.addAll(this.cinema.list);  //将电影院原先的剩余座位号暂时存入临时step容器中
            System.out.println("one====="+step);

            //只保留cinema.list(电影院所有座位号)中和要购买座位号的座位编号相同的交集保留
            this.cinema.list.retainAll(this.peoples);
            System.out.println("two====="+this.cinema.list);
//        System.out.println("交集保留后："+this.cinema.list);
            int count2 = 0;
            for (int i : this.cinema.list){  //计算电影院座位编号和要购买的电影座位编号的交集个数
                count2++;
            }
            if (this.peopleCount != count2){
                System.out.println("您要购买的座位号"+peoples+"中部分已经售出，请重新选择...");
                this.cinema.list.clear();  //清除所有的座位号
                this.cinema.list.addAll(step);  //将原先保留的电影院座位编号重新赋值
                System.out.println(this.cinema.list);
            }else {
                System.out.println("电影票购买成功...");
                step.removeAll(this.peoples);  //将原先保留的所有电影作为编号中移除要购买的座位编号
//            System.out.println("step:"+step);
//            System.out.println("=======================");
                this.cinema.list.clear();  //清除所有的座位号
                this.cinema.list.addAll(step);  //再将此赋值给电影院座位编号
                System.out.println("剩余电影院的座位号"+this.cinema.list);
            }
        }
    }
}