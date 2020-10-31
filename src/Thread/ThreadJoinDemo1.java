package Thread;

/**
 *  join:插队，在谁里面插队，就要等插队的线程先执行完毕才能在执行被插队的线程
 */
public class ThreadJoinDemo1 {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new JoinDemo1(),"WMT");
//        thread.start();
//
//        for (int i = 0; i <= 20; i++){
//            if (i == 10){
//                thread.join();  //线程JoinDemo1插队，堵塞了main方法中的循环语句
//            }
//            System.out.println("SF--->"+i);
//        }

        new Thread(new JoinFu(),"王梦婷").start();
    }
}

class JoinDemo1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 20; i++){
            System.out.println(Thread.currentThread().getName()+"---->"+i);
        }
    }
}


//案例：父亲叫儿子去买冰淇淋
class JoinFu implements Runnable{
    @Override
    public void run() {
        Thread thread = new Thread(new JoinEr(),"石燔");
        System.out.println(Thread.currentThread().getName()+
                "爸爸想吃冰淇淋,发现冰箱没有了,于是叫儿子"+thread.getName()+"去买冰淇淋...");
        thread.start();
        try {
            thread.join();  //父亲这条线程被堵塞，等待儿子买烟回来
            System.out.println(Thread.currentThread().getName()+"收到儿子"+
                    thread.getName()+"买回来的冰淇淋，并将零钱给"+thread.getName()+"儿子...");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("孩子走丢了，于是立马冲出门找孩子...");
        }
    }
}

class JoinEr implements Runnable{
    @Override
    public void run() {
        Thread thread = new Thread(new JoinFu(),"王梦婷");
        System.out.println("拿着"+thread.getName()+"爸爸给的钱，跑出门去买烟冰淇淋..");
        System.out.println(Thread.currentThread().getName()+"经过一家网吧，于是想玩一会...");
        for (int i = 1; i <= 10; i++){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"就这样呆在网吧里，于是"+i+"小时过去了...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"突然想起来要去买冰淇淋...");
        System.out.println(Thread.currentThread().getName()+"回到了家，将冰淇淋和零钱交给"+thread.getName()+"爸爸...");
    }
}