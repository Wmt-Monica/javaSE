package extence;
class People extends people{
    int age;
    String name;
    void rest(){
        System.out.println("人需要休息");
    }
    void PrivateFangFa(){
        System.out.println("与父类在同一包下不同一类下的子类重写父类的私有private方法");
    }
}
class Student extends People{
    String Class;
    void study(){
        System.out.println("学生需要学习");
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "wmt";
        student.age = 19;
        student.Class = "B190108";
        student.rest();
        student.study();
        System.out.println(student instanceof Student);
        System.out.println(student instanceof People);
        System.out.println(student instanceof Object);
//      people1.PrivateFangFa();  PrivateFangFa()方法是在父类私有化的方法不能在另外的类中调用
    }
}