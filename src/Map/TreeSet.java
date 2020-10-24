package Map;

import java.util.Set;

/**
 * 相对于TreeMap不同的是，将其根据输入的值有序的添加数据
 */
public class TreeSet {
    public static void main(String[] args) {
        //创建TreeSet对象set
        Set<Node5> set = new java.util.TreeSet<>();
        //创建Node5对象
        Node5 a1 = new Node5(6,9,"wmt1");
        Node5 a2 = new Node5(4,5,"wmt2");
        Node5 a3 = new Node5(0,3,"wmt3");
        Node5 a4 = new Node5(1,5,"wmt4");
        //添加数据进set对象中去
        set.add(a1);
        set.add(a2);
        set.add(a3);
        set.add(a4);
        //遍历打印set对象中的数据
        for (Node5 stp: set){
            System.out.println("id:"+stp.id+"\tnum:"+stp.num+"\tname:"+stp.name);
        }
    }
}
