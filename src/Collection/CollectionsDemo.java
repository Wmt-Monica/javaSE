package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection 辅助类的使用
 * Collection是接口，但是Collections是工具类
 */
public class CollectionsDemo {
    public static void main(String[] args) {
       /*
            1.void sort(List):对List容器内部的元素排序，排序的规则是按照升序进行的排序
            2.void shuffle(List):对List容器中元素进行随机排序
            3.void reverse(List):对List容器中的元素进行逆序排序
            4.void fill(List,Object):用一个而特定的对象重写整个List容器
            5.int binarySearch(List,Object):对于顺序的List容器，使用折半法查找特定的对象
        */

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            list.add("wmt"+i);
        }

        //使用shuffle()方法随机排序List容器中的元素
        Collections.shuffle(list);
        System.out.println(list);

        //使用reverse()方法将容器中的元素逆序排序
        Collections.reverse(list);
        System.out.println(list);

        //使用sort()方法对List容器中的元素进行按照升序排序
        Collections.sort(list);
        System.out.println(list);

        //使用binarySearch()方法永续顺序的容器进行折半法查找
        int i = Collections.binarySearch(list,"wmt5");
        System.out.println("wmt5在容器List中的位置：" + i);

        //使用fill()对容器List中的元素进行覆盖填充
        String s = "SF";
        Collections.fill(list,s);
        System.out.println(list);
   }
}

