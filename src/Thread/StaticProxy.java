package Thread;

/**
 * 静态代理：
 *          当我们实现多线程的时候推荐使用的方法是实现Runnable接口，
 *          但是再启动start()方法的时候，我们这里需要创建一个Thread
 *          对象，来实现静态代理，启动线程
 */
public class StaticProxy {
    public static void main(String[] args) {
        new DaiLiPeople(new benPeople()).eat();
    }
}

//实际操作对象和静态代理对象必须要实现同样的接口
interface eat{
    void eat();
}

//实际吃饭的人
class benPeople implements eat{

    @Override
    public void eat() {
        System.out.println("吃饭...");
    }
}

//代理洗手，刷碗的人
class DaiLiPeople implements eat{

    benPeople people;
    public DaiLiPeople(benPeople people){  //像是创建了一个Thread对象
        this.people = people;
    }

    @Override
    public void eat() {
        beforeEat();
        this.people.eat();
        afterEat();
    }

    public void beforeEat(){
        System.out.println("吃饭前先洗手...");
    }

    public void afterEat(){
        System.out.println("吃完饭之后洗碗...");
    }
}