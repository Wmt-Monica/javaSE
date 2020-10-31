package Thread;

/**
 * lambda+推导
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        //调用静态内部类
        new Thread(new LeiDemo1.NeiBuLeiDemo1()).start();
        System.out.println("===========================================\n");

        //匿名内部类，必须借助接口或者父类来实现，例如这里的借助Runnable接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("借助实现接口来写匿名内部类");
            }
        }).start();
        System.out.println("===========================================\n");

        //jdk8 简化 lambda
        new Thread(()->{  //如果要实现的接口只有一个方法可以实现就可以使用jdk8 的简化版
            System.out.println("简化版lambda...");
        }).start();
        System.out.println("===========================================\n");

        //局部内部类
        class JuBuNeiBuLei implements Runnable{
            @Override
            public void run() {
                System.out.println("局部内部类...");
            }
        }

        new Thread(new JuBuNeiBuLei()).start();
        System.out.println("===========================================\n");
    }
}
class LeiDemo1{
    static class NeiBuLeiDemo1 implements Runnable{

        //重写run()方法
        @Override
        public void run() {
            System.out.println("静态内部类只有在外部类被调用的时候才会被加载，否则不被编译");
        }
    }


}
