package Thread;

import java.util.Random;

/**
 * 在多线程环境下，每个线程都会有自己的数据，一个线程使用自己的局部变量
 * 比使用局部变量好，因为局部变量只有线程自己能看见，不会影响其他线程
 *
 * ThreadLocal: 能够放一个线程级别的变量，其本身能够被多个线程共享
 *              在多线程环境下去保证成员变量的安全，常用的方法就是
 *              get / set / initialValue 方法
 *
 * ThreadLocal: 每个线程滋生的数据，更改不会影响其他的线程
 *
 * InheritableThreadLocal: 继承上下文环境的数据，然后拷贝一份给子线程
 */
public class ThreadLocalDemo1 {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){

        //设置为protected ：只有自己或者时子类可以访问
        //以下时设置ThreadLocal对象的Integer的默认值 (20)
        protected Integer initialValue(){
            return 20;
        }
    };

    //InheritableThreadLocal: 继承上下文环境的数据，然后拷贝一份给子线程
    private static InheritableThreadLocal<Integer> integer = new InheritableThreadLocal<>(){
        //设置默认值 44
        protected Integer initialValue(){
            return 44;
        }
    };

    public static void main(String[] args) {
        //主线程使用ThreadLocal类开辟属于主线程的局部变量储存空间
        threadLocal.set(22);  //在主线程里面设置了值，为22，但是其他线程调用get()方法获取值得时候不会受到影响
        System.out.println(Thread.currentThread().getName()+"---->"+threadLocal.get());

        //在主线程创建一个新的线程开辟一个属于自己得ThreadLocal类对象得属性存储空间，与主线程得互不影响
        /**
         * 以下中，在main方法中，创建一个线程，创建ThreadDemo类对象，其中构造方法的调用室友main线程调用的，
         * 所以以下的threadLocal的属性值是从main线程中获取的，而之后的线程启动使用start()方法调用的是ThreadDemo对象的
         * run()方法，不是main线程调用的，所以输出的threadLocal的属性值是从ThreadDemo对象中被创建后属于自己的局部变量存储空间
         */
        new Thread(new ThreadDemo(),"ThreadDemo1").start();

        //即使同一个线程类创建的不同的线程对象都会有自己的ThreadLocal存储空间，两个线程对象之间互不影响
        new Thread(new ThreadDemo2(),"ThreadDemo2").start();
        new Thread(new ThreadDemo2(),"ThreadDemo3").start();

        System.out.println(Thread.currentThread().getName()+"---->"+integer.get());

        /**
         * 以下的main线程中的integer对象的值在未被赋值为 22 前默认还是44
         * 之后主线程中的integer被重新覆盖赋值为 44
         * 而之后创建的ThreadDemo3对象：线程ThreadDemo4 和 ThreadDemo5
         * 是在主线程中被创建的，属于main线程中的子线程所以会将main线程中的局部变量存储器中的integer的值进行一次拷贝
         */
        System.out.println(Thread.currentThread().getName()+"======="+integer.get());
        integer.set(22);
        new Thread(new ThreadDemo3(),"ThreadDemo4").start();
        new Thread(new ThreadDemo3(),"ThreadDemo5").start();


    }

    static class ThreadDemo implements Runnable{

        //在线程里面创建一个线程的构造器中的方法，由主线程，
        // 看其threadLocal的值使用哪个线程的存储中的属性值
        public ThreadDemo(){
            System.out.println("此处调用的是ThreadDemo的构造方法");
            System.out.println(Thread.currentThread().getName()+"---->"+threadLocal.get());
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"---->"+threadLocal.get());
        }
    }

    static class ThreadDemo2 implements Runnable{
        @Override
        public void run() {

            //获取1 ~ 100 的随机数有两种方法：
            /**
             *  方法一：使用Math类中的random()函数获取[0 , 1 之间的小数，我们将其乘以 100 最后在加 1 即可
             *  方法二：可以通过Random类中的nextInt方法获取随机数
             */
//            threadLocal.set((int)(Math.random()*100+1));  //使得ThreadLocal对象的Integer值是随机的【0 ~ 100】
            threadLocal.set((int)(new Random().nextInt(100)+1));

            System.out.println(Thread.currentThread().getName()+"---->"+threadLocal.get());
        }
    }

    static class ThreadDemo3 implements Runnable{
        @Override
        public void run() {
//            integer.set((int)(Math.random()*100+1));
            System.out.println(Thread.currentThread().getName()+"======"+integer.get());
        }
    }

     

}






















