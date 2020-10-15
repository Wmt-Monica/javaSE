package Map;

import java.util.Arrays;

/**
 * HashMap的底层实现
 */
public class HashMapDemo {
    public static void main(String[] args) {
        NodeManage<Integer,String> manage = new NodeManage();
        System.out.println("=============添加数据============");
        manage.put(3,"wmt3");
        manage.put(6,"wmt6");
        manage.put(9,"wmt9");
        manage.put(2,"wmt2");
        manage.put(35,"wmt35");
        manage.put(19,"wmt19");

        System.out.println("\n=============打印table===========");
        System.out.println(manage);
        System.out.println("键为19的value值为："+manage.get(19));

    }
}

//创建管理节点类对象
class NodeManage<K, V> {
    //创建存放Node4类对象的table数组对象,大小为二的幂,初始化大小为16
    Node4<K,V>[] table = new Node4[16];

    //添加数据的方法
    public void put(K key,V value){
        Node4 newNode = new Node4(key,value);
        newNode.hash = MyHash(key.hashCode(),16);
        newNode.next = null;
        if (table[newNode.hash] == null){  //当table数组中不为空直接存入
            table[newNode.hash] = newNode;
            System.out.println("table["+(newNode.hash)+"]:"+newNode);
        }else {
            //当数组当中这个位置已经有了数据，就将其处于该数组的next位置
            Node4 stp = table[newNode.hash];
            while (stp.next != null){
                stp = stp.next;
            }
            stp.next = newNode;
            System.out.println("table["+(newNode.hash)+"]:"+newNode);
        }
    }

    //根据key的值来获取Node4节点对象的数据
    public V get(K key){
        int hash = MyHash(key.hashCode(),16);
        Node4 stp = table[hash];
        if (stp == null){
            System.out.println("未查找到该键对应的数据");
        }else {
            while (stp.key != key){
                stp = stp.next;
            }
        }
        return (V) stp.value;
    }

    //自定义一个Hash值算法
    public int MyHash(int hashCode,int maxSize){
        return (hashCode&(maxSize-1));
    }

    //重写toString()方法
    @Override
    public String toString() {
        for (int i = 0; i < table.length; i++){
            if (table[i] != null){
                System.out.println("table["+i+"]="+table[i]);
                Node4 stp = table[i].next;
                while (stp != null){
                    System.out.println("table["+i+"]="+stp);
                    stp = stp.next;
                }
            }
        }
        return "";
    }
}

//创建节点对象(增加泛型)
class Node4<K,V>{
    int hash;
    K key;
    V value;
    Node4<K,V> next;

    //构造器
    public Node4(K key, V value) {
        this.key = key;
        this.value = value;
    }

    //重写toString()方法

    @Override
    public String toString() {
        return "Node4{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}