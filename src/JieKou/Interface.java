package JieKou;
/**
 * 面向接口是面向对象的一部分：
 *      接口就是规范，是项目中最稳定的，使得复杂可变的需求变成可能
 *      通过面向接口的编程，而不是面向类的编程，可以大大降低程序模块的耦合性，
 *      提高震哥哥形同的可扩展性和可维护性
 * */
public class Interface {
    public static void main(String[] args) {
        A_1 a1 = new A_1();
        a1.FangFaA();
        A_B a_b = new A_B();
        a_b.FangFaA();
        a_b.FangFaB();
    }
}
interface A{
    int A = 1;  //接口内部除了抽象的方法就只有不变的常量  默认前面被 public abstract final 修饰
    void FangFaA();  //接口的方法默认前面都是 public abstract 来修饰
}
interface B{
    int B = 2;
    void FangFaB();
}
interface C extends A,B{  //java中类是单继承的，但是接口是可以多继承的
    void FangFaC();
}

class A_1 implements A{  //implements(实现)接口

    @Override
    public void FangFaA() {
        System.out.println("类A_1实现接口A");
    }
}
class B_1 implements B{

    @Override
    public void FangFaB() {
        System.out.println("类B_1实现接口B");
    }
}
class C_1 implements C{//因为接口C继承了接口A，和接口B所有，类C_1实现接口C的时候要同时实现接口A，B的抽象方法

    @Override
    public void FangFaA() {
        System.out.println("类C_1实现方法A");
    }

    @Override
    public void FangFaB() {
        System.out.println("类C_1实方法B");
    }

    @Override
    public void FangFaC() {
        System.out.println("类C_1实现方法C");
    }
}

class A_B implements A,B{  //实现接口的方式也可以一次实现多个接口

    @Override
    public void FangFaA() {
        System.out.println("类A_B实现接口A");
    }

    @Override
    public void FangFaB() {
        System.out.println("类A_B实现接口B");
   }
}