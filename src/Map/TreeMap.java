package Map;

import java.util.Map;

/**
 * TreeMap相对于Map不同的在于，可以通过某个属性自增来有序的添加数据
 */
public class TreeMap {
    public static void main(String[] args) {
        Map<Node5,String> map = new java.util.TreeMap<>();
        Node5 node1 = new Node5(6,2,"wmt1");
        Node5 node2 = new Node5(6,9,"wmt2");
        Node5 node3 = new Node5(5,1,"wmt3");
        Node5 node4 = new Node5(8,3,"wmt4");
        map.put(node1,"ewr");
        map.put(node2,"wr");
        map.put(node3,"sfd");
        map.put(node4,"sf");
        for (Node5 key: map.keySet()){
            System.out.println("id:"+key.id+"\tnum:"+key.num+"\t"+map.get(key));
        }
    }
}

//创建节点对象类
class Node5 implements Comparable<Node5>{
    int id;
    int num;
    String name;

    //构造器
    public Node5(int id,int num, String name) {
        this.id = id;
        this.num = num;
        this.name = name;
    }

    //重写自定义排序的比较
    @Override
    public int compareTo(Node5 o) {  //大于：正数，小于：负数，等于：零
        if (this.id > o.id){
            return 1;
        }else if (this.id < o.id){
            return -1;
        }else {
            if (this.num > o.num){
                return 1;
            }else if (this.num < o.num){
                return -1;
            }else {
                return 0;
            }
        }
    }
}