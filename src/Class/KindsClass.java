package Class;

public class KindsClass {
    public static void main(String[] args) {
        A.A_1 a1 = new A().new A_1();  //创建内部类的对象
        a1.A_2();
    }
}

//内部类
class A{
    int age = 21;
    String name = "sf";
    /**
     *  非静态内部类：
     *      1.非静态内部类必须寄存在外部类对象里面，非静态内部类单独属于外部类的某个对象
     *      2.静态内部类可以直接访问外部类的成员，而外部类不能直接访问非静态内部类的成员
     *      3.非静态内部类不能有静态语句块，静态方法，静态属性
     *      4.外部类的静态方法，静态语句块不能访问非静态内部类，
     *        包括非静态内部类的方法，和在非静态内部类定义得变量，和创建实例
     * */
    class A_1{
        int age;
        String name;
        void A_2(){
            int age = 10;
            String name = "wmt";
            /*
            *   访问三种变量的方法：
            *   内部类变量：this.变量名
            *   内部类方法中的局部变量：变量名
            *   外部类中的变量：外部类类名.this.变量名
            * */
            System.out.println("内部类变量age:"+this.age);
            System.out.println("内部类变量name:"+this.name);
            System.out.println("内部类中的方法中的局部变量age:"+age);
            System.out.println("内部类中的方法中的局部变量name:"+name);
            System.out.println("外部类的变量age:"+A.this.age);
            System.out.println("外部类的变量name:"+A.this.name);
        }
    }
}

abstract class B{
    abstract void B();
    class B_2{
        B b = new B(){
            @Override
            void B() {
               System.out.println("匿名内部类实现少创建一个子对象");
            }
        };
    }
}

