package DuoTai;

/**
 *  多态的要点：
 *  1.多态是方法的多态，不是属性的多态（多态与属性无关）
 *  2.多态的存在要有三个必要的条件：继承，方法重写，父类引用指向子类对象
 *  3.父类引用指向子类对象之后，用该父类引用调用子类重写的对象，此时多态就出现了
 */
public class DongWu {
    public static void main(String[] argst) {
        Animal animal = new Animal();
        JiaoSheng(animal);
        /**
         * （父类引用调用子类对象）向上转型
         *   Dog和Cat都是Animal的子类，这里将Animal的多态对象传入，这里就分别调用其中被重写的方法
         *   如果没有多态，就要因为传入的对象不同而创建不同的方法，有了多态之后，只需要传入父类的对象
        * */
        Dog dog = new Dog();
        JiaoSheng(dog);
        Cat cat = new Cat();
        JiaoSheng(cat);
//        Dog dog1 = (Dog) animal;  //??????父类对象强制转换成子类对象（向下转型）不属于自动类型转换，需要强制转换
        Animal animal1 = new Dog();  //父类引用引用子类对象（向上转型）属于自动类型转换
//        animal1.SeeDoor();  再次已经被转换成了Animal对象不能调用Dog特有的方法SeekDoor()方法，除非强制强制类型转换
        Dog animal2 = (Dog) animal1;   //此处强制类型转换了animal1
        animal2.SeeDoor();
    }
    static void JiaoSheng(Animal animal){  //在main方法中设置静态方法引用Animal对象调用shout方法
        animal.shout();
    }
}
class Animal{
    void shout(){
        System.out.println("调用动物类父类shout方法");
    }
}

class Dog extends Animal{
    void shout(){
        System.out.println("Dog类继承Animal父类重写的shout方法:汪汪汪~");
    }
    void SeeDoor(){
        System.out.println("属于Dog类特有的方法：看门~");
    }
}

class Cat extends Animal{
    void shout(){
        System.out.println("Cat类继承Animal父类重写的shout方法：喵喵喵~");
    }
}