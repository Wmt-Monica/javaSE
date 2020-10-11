package Collection;
/**
 *  Collection容器包含两种:1.List 2.Set
 * */
import java.util.*;

public class List_1 {
    public static void main(String[] args) {
        //Collection容器是可以定义泛型的
        Collection <String> c = new ArrayList<>();
        /*
            size()方法获取容器的大小
            isEmpty()方法是用来判断容器是否为空
            add()方法是用于为容器添加数据的
            contains()方法是用于该对象是否存在容器中
        */
        c.add("wmt");
        c.add("sf");
        c.add("WMT");
        c.add("SF");
        System.out.println("Collection容器中的大小："+c.size());
        System.out.println("容器是否为空："+c.isEmpty());
        System.out.println("WMT是否存在容器当中："+c.contains("WMT"));
        /**
            remove()方法是用于从容器中一处某个对象
            但是对象本身并没有删除，容器内部实质装的是各个对象的地址，
            remove的是放进容器对象的地址
         */
        c.remove("sf");
        System.out.println("Collection容器打印实质是调用toString()方法："+c);

        Object object = c.toArray();
        System.out.println("object:"+object);

        //clear()方法是用于容器内全部的对象
        c.clear();
        System.out.println("容器是否为空："+c.isEmpty());
    }
}
