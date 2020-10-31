package Thread;

/**
 * Priority:线程调度器
 *      作用：根据优先级来调度进入就绪状态的所有线程
 *      1.线程的优先级有数字来表示：范围【1~10】
 *          Thread.MIN PRIORITY = 1 (最小)
 *          Thread.MAX PRIORITY = 10 (最大)
 *          Thread.NORM PRIORITY = 5 (默认)
 *      2.优先级的设定建议在start()调用前
 *      3.优先级的高低只是被调用的概率变大，不代表绝对的先后顺序
 */
public class ThreadPriorityDemo1 {
    public static void main(String[] args) {

        PriorityDemo1 p1 = new PriorityDemo1();
        PriorityDemo1 p2 = new PriorityDemo1();
        PriorityDemo1 p3 = new PriorityDemo1();
        PriorityDemo1 p4 = new PriorityDemo1();
        PriorityDemo1 p5 = new PriorityDemo1();
        PriorityDemo1 p6 = new PriorityDemo1();

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(p4);
        Thread t5 = new Thread(p5);
        Thread t6 = new Thread(p6);

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(3);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t5.setPriority(8);
        t6.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}

class PriorityDemo1 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---->");
    }
}