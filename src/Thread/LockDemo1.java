package Thread;

/**
 * 可重入锁的概念理解：就是在类中再在创建一个自己的类
 *
 * 不可重入锁：就是在自己的类中不允许自己这个类
 */
public class LockDemo1 {
    public static void main(String[] args) throws InterruptedException {
        //1.多次调用自身
//        new LockDemo1().LockTest1();

        //2.调用不可重入锁
        LockTest1 test1 = new LockTest1();

        //前者获取到锁的资源后释放后者才能机会获取到锁的资源
        /*test1.UseLock();
        test1.releaseLock();
        test1.UseLock();*/

        //前者获取到锁的资源后未等释放就再次试图重入获取锁的资源使得线程一直处于等待状态，进入死循环
        /*test1.UseLock();
        test1.UseLock();
        test1.releaseLock();*/

        //可重入锁的调用
        LockTest2 lockTest2 = new LockTest2();  //创建LockTest2 类对象
        lockTest2.UseLock();  //可重入获取四次锁
        lockTest2.UseLock();
        lockTest2.UseLock();
        lockTest2.UseLock();
        new Thread(new ThreadDemo(lockTest2),"wmt").start();  //创建一个新的线程尝试和main线程争取获得锁
        System.out.println("==================================");
        new LockTest2().UseLock();
        lockTest2.releaseLock();
        lockTest2.releaseLock();
        lockTest2.releaseLock();
        lockTest2.releaseLock();

    }

    public void LockTest1() throws InterruptedException {
        //第一次获得自身的锁

        synchronized (this){
            while (true){
                //第二次获得相同的自身的锁
                synchronized (this){
                    System.out.println("获得相同的锁");
                }
                Thread.sleep(1000);
            }
        }
    }
}

//不可重入锁
class LockTest1{
    boolean isLock = false;  //判断所是否被占用

    //获取锁
    public synchronized void UseLock(){

        if (!isLock){
            isLock = true;
            System.out.println("成功获取锁....");
        }else {
            while (isLock){  //如果锁被占用就使线程处于等待状态
                try {
                    System.out.println("该锁已经被占用，请等待....");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    //释放锁
    public synchronized void releaseLock(){
        if (isLock){  //如果锁被占用，调用释放锁的方法，就将锁isLock = false 释放掉，同时启动被处于等待的线程
            isLock = false;
            System.out.println("成功释放锁资源....");
            notify();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


//可重入锁
class LockTest2{
    boolean isLock = false;  //判断锁是否被占用
    int count = 0;  //记录一个线程一共被累加调用自身的次数
    Thread thread = null;  //存储上一层线程对象

    //创建获取锁的方法
    public synchronized void UseLock(){
        Thread t = Thread.currentThread();

        if (isLock && ((t != thread) || t == null)){  //如果当要调用锁未被释放且上一层线程和这次试图获取锁的线程对象不一致就处于等待
            System.out.println("锁已经被占有，请等待....");
            System.out.println("isLock---->"+isLock+"\tt---->"+t.getName()+"\tthread---->"+thread.getName()+"\n");
            try {
                Thread.sleep(1000);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //使得线程休眠1秒
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread = t;
        count++;
        isLock = true;
        System.out.println(t.getName()+"第"+count+"获取锁....\n");
    }

    //创建释放锁的方法
    public synchronized void releaseLock(){
        if (Thread.currentThread() == thread){
            System.out.println("已经释放了第"+count+"层锁....\n");
            count--;  //如果还未到达最高层获取对象的类时，获取锁的次数减一
            if (count == 0){  //如果已经将所有的锁减去，为零
                isLock = false;  //就释放锁资源，
                notify();  //将之前想要获取锁的其他被处于等待的对象处于等待状态
                thread = null;  //并将之前获取的当前线程对象初始化为null
                System.out.println("已经将该对象的所有获取到的锁释放....\n");
            }
        }
    }

}

//创建一个新的线程尝试与main线程争取锁
class ThreadDemo implements Runnable{

    LockTest2 lockTest2 = null;

    public ThreadDemo(LockTest2 lockTest2) {
        this.lockTest2 = lockTest2;
    }

    @Override
    public void run() {
        this.lockTest2.UseLock();
    }
}





















