package Abstarct;
/**
 *  抽放方法的意义：为子类提供统一的，规范的模板，通过抽象类，
 *  我们可以做到严格的限制子类的设计，使子类之间更加的通用
 *  1：有抽象方法的类只能定义成抽象类
 *  2：抽象类不能实例化，即不可以用new来实例化抽象类
 *  3：抽象类可以包含属性，方法，构造方法。但是构造方法不能用来new实例，只能用来被子类调用
 *  4：抽象类只能被继承
 *  5：抽象方法必须被子类实现
 * */
public class Animal {
    public static void main(String[] args) {
//        A a = new A();  此为抽象类不能用new来实例化
        A a = new B();  //抽象类只能通过其子类来实例化
        a.shout();
        B b = new B();
        System.out.println("num:"+b.Speak(19));
    }
}

abstract class A{
    abstract void shout();
    abstract int Speak(int num);
}

class B extends A{
    @Override
    void shout() {
        System.out.println("这里继承了抽象父类A，要实现其中的shout()方法，" +
                "且要按照父类的规范来，无参数，无返回值");
    }

    @Override
    int Speak(int num) {
        return num;
    }

}