package extence;

public class override {
    public static void main(String[] args) {
        student stu = new student();
        stu.study();
        stu.age = 21;
        stu.name = "sf";
        stu.chongXie().age = 19;  //chongXie返回的是新的student对象，不影响前面stu对象的属性
        stu.chongXie().name = "wmt";
        stu.chongXie().study();
        System.out.println("age:" + stu.age + "\t" + "name:" + stu.name);
        stu.fangFa();
        stu.PrivateFangFa();
        people people = new people();
    }
}
 class people{
    int age;
    String name;
    void study(){
        System.out.println("人需要读书");
    }
    people chongXie(){  //创建一个chongXie方法返回people对象
        return new people();
    }
    public static void fangFa(){
        System.out.println("static方法");
    }
    final void FinalFangFa(String s){
        System.out.println("s:"+s);
    }
    private void PrivateFangFa(){
        System.out.println("父类私有的方法不能在子类被重写");
    }
   public people(){
        System.out.println("people构造方法");
   }
}
class student extends people{
    /*
    * 1."==":方法名，形参列表相同
    * 2."<=":返回值的类型和声明异常类型，子类小于等于父类
    * 3.">=":访问权限，子类大于等于父类
    * */
    void study(){ //形参列表要相同
        System.out.println("程序员需要敲代码");
    }
    student chongXie(){
        return new student();  //重写父类的chongXie方法，修改返回值（因为student是people的子类，所以可以返回该类型）
    }
    public static void fangFa(){  //static方法不能被重写，但是能够重新被定义
        System.out.println("重新定义static方法");
    }
    void PrivateFangFa(){  //父类的 PrivateFangFa方法是私有的对于子类是看不见的，此处不算是重写了该方法
        super.study();
//        super.PrivateFangFa();  父类的private(私有)方法不能呗super调用
        System.out.println("重新定义父类私有的方法");
    }
    /*  父类中final修饰的方法不能被重写
    void FinalFangFa(String s){
        System.out.println("s:"+s);
    }
    */
    /*  子类不能重写父类的构造方法
    public people(){
        System.out.println("子类不能重写父类的构造方法");
    }
    */
}

