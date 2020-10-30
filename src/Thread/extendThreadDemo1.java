package Thread;

/**
 * 初次使用Thread线程
 * 1.继承Thread,重写Run()方法
 * 2.实现Runnable接口，重写Run()方法，然后创建一个多线程使用start()方法启动多线程
 * 注意：因为实现接口的方式并没有start()方法可以调用，所以这里要自主创建一个多线程对象来启动start()方法
 */
public class extendThreadDemo1 extends Thread {  //继承多线程父类Thread

    //重写Rnn()方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("Run方法的调用");
        }
    }

    public static void main(String[] args) {
        extendThreadDemo1 thread = new extendThreadDemo1();  //创建一个多线程对象
//        thread.start();  //多线程的启动，这里并不会立即调用Run()方法，而是交给CPU来分配运行
//        for (int i = 0; i < 10; i++){
//            System.out.println("普通方法1的调用");
//        }

        //注意：如果启动线程对象start()方法实在普通方法之后，是不会有多线程的效果
        //      而是先将普通方法执行完毕之后，仍然使用一个线程来执行线程的run()方法中的执行语句
        System.out.println("\n\n========================================================\n");
        for (int i = 0; i < 10; i++){
            System.out.println("普通方法2的调用");
        }
        thread.start();
        System.out.println("\n\n========================================================\n");
    }
}
