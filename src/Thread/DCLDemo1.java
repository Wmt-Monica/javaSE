package Thread;


/**
 * DCL单例模式：懒汉式套路基础上加上并发控制，保证多线程环境下，对外存在一个对象
 * 1.构造器私有化---->避免外部new构造器
 * 2.提供私有地静态属性---->存储对象地址
 * 3.提供公共地静态方法---->获取属性
 */
public class DCLDemo1 {
    public static void main(String[] args) throws InterruptedException {
        //用过以下方式创建的对象的地址是一样，创建的都是同一个对象
        Thread t = new Thread(()->{
            System.out.println(new DCLObject(2000).CreateDCLObject());
        });
        t.start();
        System.out.println(new DCLObject(0).CreateDCLObject());
    }
}

class DCLObject{
    //2.提供私有地静态属性---->存储对象地址
    //没有volatile其他线程可能访问一个没有初始化的对象
    private volatile static DCLObject address;  //创建静态的属性存放创建新的对象的地址

    //1.构造器私有化---->避免外部new构造器
    public DCLObject(int time){
        try {
            Thread.sleep(time);  //创建对象进行休眠等待1秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //3.提供公共地静态方法---->获取属性
    public DCLObject CreateDCLObject(){
        //为了避免synchronized锁住的时间，在已经存在对象的情况仍要继续等待
        // 进行判断是否创建创建对象，所以在synchronized前面就进行一次判断
        if (address != null){
            return address;
        }else {
            synchronized (DCLObject.class){
                if (address == null){
                    //在创建对象的时候一共有三个步骤
                    //1.开辟空间，2.初始化对象信息，3.返回对象的地址给引用
                    address = new DCLObject(1000);
                }
                return address;
            }
        }
    }
}
