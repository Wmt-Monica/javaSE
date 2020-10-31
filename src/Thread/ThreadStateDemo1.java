package Thread;

/**
 * 展先线程状态的
 */
public class ThreadStateDemo1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new StateDemo1(),"WMT");
        System.out.println("线程的状态1："+thread.getState()+"新生状态（new）");
        thread.start();

    }
}

class StateDemo1 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++){
            System.out.println(Thread.currentThread().getName()+"---->"+i);
            if (i > 10){
                try {
                    Thread.sleep(2000);
                    new Thread(new StateDemo2(),"SF").start();
                    new Thread(new StateDemo2(),"SF").join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("StateDemo1线程的状态："+Thread.currentThread().getState());

            }
        }
        System.out.println("=========================================");
    }
}

class StateDemo2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++){
            try {
                Thread.sleep(250);
                System.out.println(Thread.currentThread().getName()+"---->"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}