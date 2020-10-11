package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class List_2 {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();
        c1.add("A");
        c1.add("B");
        c1.add("C");

        Collection<String> c2 = new ArrayList<>();
        c2.add("A");
        c2.add("D");
        c2.add("E");

        Collection<String> c3 = new ArrayList<>();
        c3.add("A");

        System.out.println("c1:"+c1);
        /**
         *  containAll(Collection c):判断本容器是否包含c容器中所有的元素
         *  addAll(Collection c):将容器c中的所有元素全部增加到本容器中去
         *  removeAll(Collection c):将本容器中和容器c都包含的元素移除
         *  retainAll(Collection c):只保留本容器中与c容器相交的元素
         * */
        System.out.println("容器c1是否包含所有容器c2所有元素："+c1.containsAll(c2));
        System.out.println("容器c1是否包含所有容器c3所有元素："+c1.containsAll(c3));
        c1.addAll(c3);
        System.out.println("将容器c3中的元素添加到c1后，c1中所有的元素："+c1);
        c1.removeAll(c2);
        System.out.println("将c1中c1与c2都包含的元素删除后c1的的元素："+c1);
        c2.retainAll(c3);
        System.out.println("只保留c2中与c3相交的元素后，c2的所有元素："+c2);
    }
}
