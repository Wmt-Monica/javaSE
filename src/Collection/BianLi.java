package Collection;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * 使用迭代器遍历List,Set,Map中的数据
 */
public class BianLi {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("wmt1");
        list.add("wmt2");
        list.add("wmt3");
        list.add("wmt4");

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"WMT1");
        map.put(2,"WMT2");
        map.put(3,"WMT3");
        map.put(4,"WMT4");

        Set<String> set = new HashSet<>();
        set.add("sf1");
        set.add("sf2");
        set.add("sf3");
        set.add("sf4");

        /**
         * 用迭代器遍历List容器
         */
        //使用Iterator迭代器遍历List容器，list要使用iterator()方法，
        // 其中hashNext()方法，是判断下移后是否为空
        for (Iterator<String> t = list.iterator();t.hasNext();){
            //next()方法不仅是将其数据返回，并将下移一位
            System.out.println(t.next());
        }

        /**
         * 用迭代器遍历Set容器
         */
        for (Iterator<String> t = set.iterator(); t.hasNext();){
            System.out.println(t.next());
        }

        /**
         * 用迭代器遍历Map容器
         * 不同于List和Set的是事先要用Set和entrySet()方法来实现遍历
         */
        //使用原本的toString()方法
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        for (Iterator t = entrySet.iterator(); t.hasNext();){
            System.out.println(t.next());
        }

        //遍历Map对象本身来获取其中的值
        Set<Map.Entry<Integer,String>> entrySet1 = map.entrySet();
        for (Iterator<Map.Entry<Integer,String>> mapStp = entrySet1.iterator();mapStp.hasNext();){
            Map.Entry<Integer,String> stp = mapStp.next();
            System.out.println("key:"+stp.getKey()+"\tvalue"+stp.getValue());
        }

        //遍历Map中的key值
        Set<Integer> set1 = map.keySet();
        for (Iterator<Integer> iterator = set1.iterator();iterator.hasNext();){
            Integer key = iterator.next();
            System.out.println(key+"---"+map.get(key));
        }
    }
}
