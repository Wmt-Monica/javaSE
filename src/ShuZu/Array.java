package ShuZu;

/**
 *  数组：
 *  1.长度是确定的，数组一旦被创建，它的大小就是不可以改变的
 *  2.其元素必须是相同类型，不允许出现混合类型
 *  3.数组的类型可以是任何数据类型，包括基本类型和引用类型
 */
public class Array {
    public static void main(String[] args) {
        int[] array;  //创建了一个数组对象(在栈里面有了array这个栈，但是没有分配空间)
        int[] array2 = new int[10];  //创建了一个int型数组对象，并分配了十个int类型的空间
        User[] array3 = new User[10];  //创建了一个User类型的数组对象，并分配了10个User类型的空间

        /** 静态初始化（不给数组的空间大小，直接赋值）*/
        int[] array4 = {1,2,3};
        /** 默认初始化（不进行赋值，直接非陪数组空间）*/
        int[] array5 = new int[10];
        /** 动态初始化（先分配数组的空间，在对数组进行赋值）*/
        int[] array6 = new int [10];
        for(int i=0;i<array6.length;i++){
            array6[i]=i;
        }

        /** 自定义类型的赋值*/
        //静态初始化
        User[] users = {new User(18,"wmt"),new User(19,"WMT")};
        //默认初始化
        User[] users1 = new User[10];
        //动态初始化
        User[] users2 = new User[2];
        users2[0] = new User(20,"sf");
        users2[1] = new User(21,"SF");
    }
}
class User{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    User(int age , String name){
        System.out.println("User构造器");
    }
}
