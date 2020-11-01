package Thread;
/**
 * 将线程经量做到三高：
 * 1.高性能
 * 2.高并发
 * 3.高可用
 *
 * 注意需要用到synchronized的情况：
 *      多个线程对象访问同一个对象时，并且某些线程还需要修改这个对象，这时我们需要用到线程同步
 *
 * 1.一个线程持有锁会导致其他所有需要此锁的线程挂起
 * 2.在多个线程竞争下，加锁，释放锁会导致比较多的上下切换和调度延时引起的性能问题
 * 3.如果一个优先级高的线程在等待一个优先级低的线程释放锁会导致优先级倒置，引起的性能问题
 *
 * synchronized关键字的两种使用方法：synchronized方法 和 synchronized块
 *
 * 案例二：取款
 *
 */
public class synchronizedDemo2 {
    public static void main(String[] args) {
        User user = new User(10000);

        Thread thread1 = new Thread(new DrawMoney(user,1000),"WMT");
        Thread thread2 = new Thread(new DrawMoney(user,1500),"SF");

        thread1.start();
        thread2.start();
    }
}

class User{
    private int Count;  //银行卡里面的总资金

    public User(int count) {
        this.Count = count;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

}

class DrawMoney implements Runnable{
    private int balance;  //本人手上所持有的资金
    User user;

    public DrawMoney(User user, int balance) {
        this.user = user;
        this.balance = balance;
    }

    @Override
    public void run() {
        boolean flag = true;
        for (int i = 0; i < 20; i++){
            if (Thread.currentThread().getName() == "WMT"){
                try {  //如果是王梦婷那么就开始取钱
                    QuMoney(1500);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if (Thread.currentThread().getName() == "SF"){  //如果是石燔就开始存钱
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.balance > 280){
                    CunMoney(280);
                }else if (this.balance > 0){
                    System.out.println(Thread.currentThread().getName()+
                            "手中余额不足280元，但是还是将剩下的"+this.balance+"元存入银行");
                    CunMoney(this.balance);
                }else {
                    System.out.println(Thread.currentThread().getName()+"没钱了....");
                    flag = false;
                }
            }
        }
    }

    //存钱方法
    public synchronized void CunMoney(int money){
        this.user.setCount(this.user.getCount()+money);
        this.balance -= money;
        System.out.println(Thread.currentThread().getName()+"用户存入"+money+"元，" +
                "卡中总余额："+this.user.getCount()+"\n"+Thread.currentThread().getName()+
                "手中持有金额"+this.balance+"\n============================\n");
    }

    //取钱方法
    public synchronized void QuMoney(int money) throws InterruptedException {
        if ((money > this.user.getCount()) && (this.user.getCount() > 0)){
            System.out.println("银行余额不足1500元....");
            Thread.sleep(500);
            System.out.println("于是"+Thread.currentThread().getName()+"取走了剩余银行卡里所有的钱");
            Thread.sleep(500);
            int step = this.user.getCount();
            this.user.setCount(this.user.getCount()-this.user.getCount());
            this.balance += this.user.getCount();
            System.out.println(Thread.currentThread().getName()+"用户取走"+step+"元，" +
                    "卡中总余额："+this.user.getCount()+"\n"+Thread.currentThread().getName()+
                    "手中持有金额"+this.balance+"\n============================\n");
        }else if ( this.user.getCount() > 0){
            this.user.setCount(this.user.getCount()-money);
            this.balance += money;
            System.out.println(Thread.currentThread().getName()+"用户取走"+money+"元，" +
                    "卡中总余额："+this.user.getCount()+"\n"+Thread.currentThread().getName()+
                    "手中持有金额"+this.balance+"\n============================\n");
        }
    }
}