package Thread;

/**
 * yield礼让线程，暂停线程，直接进入就绪状态不是阻塞状态
 * 之后能否礼让成功，还是要看CPU如何分配
 */
public class ThreadYieldDemo1 {
    public static void main(String[] args) {
//        YieldDemo1 y = new YieldDemo1();
//        new Thread(y,"WMT").start();
//        new Thread(y,"SF").start();
//        System.out.println("========================================");

       Thread thread = new Thread(new YieldDemo2(),"WMT");
       thread.start();
       for (int i = 0; i <= 100; i++){
           System.out.println("main--->"+i);
           if (i % 5 == 0){
               thread.yield();
               System.out.println("===========线程thread尝试礼让main主方法==========");
           }
       }
    }
}

//案例一
class YieldDemo1 implements Runnable{

    private int i;

    public int getI() {
        return i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---->"+"start");
        System.out.println(Thread.currentThread().getName()+"---->"+this.i++);
        System.out.println(Thread.currentThread().getName()+"---->"+"end");
        if (Thread.currentThread().getName() == "WMT"){  //当线程名字为WMT时，尝试礼让SF线程
            Thread.yield();  //礼让线程
            System.out.println("线程WMT尝试礼让线程SF");
        }

    }
}


//案例二
class YieldDemo2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++){
            System.out.println(Thread.currentThread().getName()+"---->"+i);
        }
    }
}