package Thread;

/**
 * 利用线程来模拟龟兔赛跑
 */
public class runGameDemo1 {
    public static void main(String[] args) {
        game gamer = new game();
        new Thread(gamer,"tortoise").start();
        new Thread(gamer,"rabbit").start();
    }
}

class game implements Runnable{
    String win = null;
    @Override
    public void run() {
        for (int step = 0; step <= 100; step++){
            //使用Thread.currentThread().getName()获取线程名称
            System.out.println(Thread.currentThread().getName()+"————>"+step+"米");

            //如果是兔子再赛跑，她不再懈怠，没有偷懒，一直在奔跑中...
            if ((Thread.currentThread().getName() == "rabbit") && (step % 10 == 0)){
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //每走一步进行一下胜利者的判断
            if (compare(step)){
                System.out.println("win————>"+win+"---"+Thread.currentThread().getName());
                break;
            }
        }
    }

    public boolean compare(int step){
        if (win != null){
            return true;
        }else {
            if (step == 100){
                win = Thread.currentThread().getName();
            }
            return false;
        }
    }
}