package Collection;

import java.util.ArrayList;
import java.util.List;
/**
 *  List是有序，可重复的容器
 *  有序：List中的每一个元素都由索引标记。可以根据元素的索引标记(List中的位置)
 *      访问元素，从而精准的控制这些元素。
 *  可重复性：List允许加入重复的元素，更确切地说，List通常满足e1.equals(e2)的元素重复加入容器
 * */
public class List_3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //按照
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println("list:"+list);
        /**
         *  list中add()方法中可以按照索引添加数据但是索引的范围不能超过list的大小范围
         *  当原来索引位置已有元素时，添加不是覆盖而是插入，其之后的元素包括原来索引位置的元素同意向后移一位
         * */
        list.add(2,"E");
        list.add("F");
        System.out.println("list:"+list);

        //同时remove()也有重载的方法，可以根据索引来删除元素
        list.remove(0);
        System.out.println("list:"+list);

        //如果不是添加数据，而是要覆盖每个位置的元素，则用set(int index,Object object)方法
        list.set(0,"A");
        System.out.println("list:"+list);

        //打印list对象是默认使用toString()方法，如果想单独打印某个元素，可以使用get(int index)方法
        System.out.println("list容器中序列为3的元素："+list.get(3));

        //indexOf(object)方法用于根据某个元素在容器中寻找，返回从容器前开始寻找第一个元素的索引位置，
        // 假如容器中没有找到则返回-1，lastIndexOf(object)方法用于寻找该元素在容器中最后出现的位置
        list.add("B");
        list.add("B");
        System.out.println("list:"+list);
        System.out.println("元素B在list容器中第一次出现的位置："+list.indexOf("B"));
        System.out.println("元素B在list容器中最后一次出现的位置："+list.lastIndexOf("B"));
        System.out.println("元素G不存在list容器给中寻找返回-1:"+list.indexOf("G"));

    }
}
