package Map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        //Map是抽象类父类，HashMap是其中最常见的实现子类 <数据类型，数据类型，...>
        Map <Integer,String> map = new HashMap<>();

        //put()方法：将数据添加入map对象中,根据定义的Map类的对象设置的添加数据类型
        map.put(1,"wmt1");
        map.put(2,"wmt2");
        map.put(3,"wmt3");
        map.put(4,"wmt4");

        //get()方法：获取Map对象
        System.out.println("键为2的数据："+map.get(2));

        //键不能重复，否则会覆盖原来的元素
        map.put(2,"SF");
        System.out.println("键为2的数据："+map.get(2));

    }
}
