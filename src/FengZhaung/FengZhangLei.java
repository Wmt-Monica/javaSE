package FengZhaung;

public class FengZhangLei {
    public static void main(String[] args) {
        User_A user = new User_A();
        /*
        父类age属性已经私有化，不能通过（对象.age）方式引用，只能通过SetAge方法初始化对象的属性
        user.age = 19;
        */
        user.SetAge(19);
        System.out.println("age:"+user.GetAge());
    }
}
class User_A{
    private int age;  //将这些属性都设置私有化，其他类不能访问

    //将父类的age属性设置私有化之后，创建SetAge方法有判断的存入数据，起到对程序数据维护的作用
    public void SetAge(int age){
        if(age>0&&age<130){
            this.age=age;
        }else {
            System.out.println("请输入正确的年龄");
        }
    }

    public int GetAge(){
        return this.age;
    }
}
