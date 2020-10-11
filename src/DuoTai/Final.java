package DuoTai;

/**
 * final 常量：
 *  1.final修饰的变量都变成常量，且一旦被赋予了初值就不能在被赋值
 *  2.final修饰的方法和类不能被重写但是能被重载
 *      （重写和重载的区别）：重写是父类和子类多态性的表现
 *                          重载是类之间的多态性的表现
 *  3.final修饰的类不能继承，没有子类
 */
public class Final {
    final int a = 1;
//    a = 2;  final 常量一旦被复制不能二次赋值
}


final class A{
}

/*
class B extends A{
    //final修饰的类没有子类，不能被继承
}
 */
class C{
    final void  CFangFa(){
        System.out.println("此为C类中的final方法");
    }
}

class D extends C{
    /* 继承C类中的CFangFa()方法被final修饰不能在子类被重写，只能被重载
    void CFangFa(){

    }
     */
    void CFangFa(String s){
        System.out.println("final修饰的方法不能被重写但是可以被重载");
    }
}