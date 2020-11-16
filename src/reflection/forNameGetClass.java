package reflection;

import annotation.MetaAnnotationException;

/**
 * 反射机制
 * 指的是可以在运行时加载，探知，使用编译期间完全未知的类
 * 程序在运行状态中，可以动态加载一个只有名称的类，对于任意一个已加载的类，
 * 都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；
 *
 * Class c = Class.forName("path");
 * 加载完类之后，在堆内存中，就产生了一个Class类型的对象（一个类只有一个Class对象)
 * ,这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类的结构，这个对象
 * 就像一面镜子，透过这个镜子看到类的结构，所以，我们形象的称之为：反射。
 */
public class forNameGetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        //测试java.lang.Class对象的获取方式
        String path1 = "Date.Calendar_1";
        String path2 = "DuoTai.Animal";
        Class c1 = Class.forName(path1);
        Class c2 = Class.forName(path1);
        Class c3 = Class.forName(path2);  //此处要抛出类Class找不到的异常 (ClassNotFoundException)

        //相同的类的哈希值是相同的，通过反射机制可以同时获得相同对象的类
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        System.out.println(c3.hashCode());

        //通过getClass()方法可以获取到这个属性属于的类的对象
        int[] array1 = new int[1];
        int[] array2 = new int[3];
        String[] array3 = new String[1];
        int[][] array4 = new int[1][];
        System.out.println("===========================");
        //像同类型的属性的类的对象的哈希值是相同的，只和类型有关
        System.out.println("array1："+array1.getClass().hashCode());
        System.out.println("array2："+array2.getClass().hashCode());
        System.out.println("array3："+array3.getClass().hashCode());
        System.out.println("array4："+array4.getClass().hashCode());

        //测试各种类型(class,interface,enum,annotation,primitive type,void)对应的java.lang.Class对象的获取方式
        System.out.println(MetaAnnotationException.class.hashCode());
    }
}
