package homework;

import java.util.Stack;

//创建管理节点的类
class NodeManage{

    //创建双向链表的头节点，无实际数据意义
    Node head = new Node(0,"",0);

    //=====================================重写toSting方法=================================
    @Override
    public String toString() {
        Node node = head.next;
        while (node != null){
            System.out.println(node);
            node = node.next;
        }
        return "";
    }

    //=====================================判断链表是否为空=================================
    public boolean isEmpty(){
        if (head.next == null){
            return true;
        }else {
            return false;
        }
    }

    //====================================有序添加节点的方法================================
    public void add(Node NewNode){

        //判断是否有重复的no序号
        boolean flag = false;
        //创建临时变量存放头节点
        Node node = head;

        if (isEmpty()){  //当链表为空是，直接将该节点位置返回
            head.next = NewNode;
            NewNode.previous = head;
            System.out.println("节点数据添加成功....");
        }else {
            //寻找节点插入位置
            while (true){
                if (node.next == null){
                    break;
                }else if (node.next.no > NewNode.no){
                    break;
                }else if (node.next.no == NewNode.no){  //有重复的no序号节点
                    flag = true;  //flag 返回true
                    break;
                }else {
                    node = node.next;  //将节点下移
                }
            }

            //插入节点
            if (flag){
                System.out.println("添加节点数据的no序号重复，数据添加失败....");
            }else {
                NewNode.next = node.next;
                NewNode.previous = node;
                node.next = NewNode;
                node.next.previous = NewNode;
                System.out.println("节点数据添加成功....");
            }
        }

    }

    //============================删除节点(三种不同的传入的参数，删除节点=============================
    public void delete(){
        //清空链表
        head.next = null;
    }
    public void delete(int no){
        //根据序号，删除节点
        Node node = head.next;
        while (node != null){
            if (node.no == no){
                node.previous.next = node.next;
                node.next.previous = node.previous;
            }else {
                node = node.next;
            }
        }
    }
    public void delete(String name){
        //根据名字，删除节点
        Node node = head;
        while (node != null){
            if (node.name == name){
                node.previous.next = node.next;
                node.next.previous = node.previous;
            }else {
                node = node.next;
            }
        }
    }
    public void delete(Node OldNode){
        //根据节点，删除节点
        Node node = head;
        while (node != null){
            if (node.no == OldNode.no){
                node.previous.next = node.next;
                node.next.previous = node.previous;
            }else {
                node = node.next;
            }
        }
    }

    //==================================返回链表总节点数=================================
    public int getSize(){
        Node node = head;
        int size = 0;
      while (node.next != null){
          size++;
          node = node.next;
      }
      return size;
    }

    //=================================获取链表倒数第n个节点===================================
    public Node getLastNode(){
        //不传入参数，返回链表最后一个节点
        Node node = head.next;
        while (node != null){
            node = node.next;
        }
        return node;
    }
    public Node getLastNode(int n){
        //传入参数，返回链表倒数第n个节点
        Node node = head;
        //判断传入参数n是否合法
        if (n <= 0 || n > getSize()){
            System.out.println("传入的n超过链表长度，获取节点失败....");
        }else{
            for (int i = 0; i != ((getSize()-n)+1); i++){
                node = node.next;
            }
        }
        return node;
    }

    //==================================反转链表========================================
    public void Reverse(){
        Node node = head.next;
        Node next;
        Node NewNode = new Node(0,"",0);
        while (node != null){
            next = node.next;
            node.next = NewNode.next;
            NewNode.next = node;
            node = next;
        }
        head.next = NewNode.next;
    }

    //从尾部开始遍历链表，要求：反向遍历，运用栈
    public void ReversePrint(){
        //创建栈对象
        Stack<Node> stack = new Stack<>();
        Node node = head.next;
        while (node != null){
            stack.add(node);
            node = node.next;
        }

        //将节点从栈中取出，出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    //将两个有序链表合并，合并之后的链表任然为有序
    public NodeManage MergeLink(NodeManage OtherNode){

        //创建两个空Node节点对象指向两个NodeManage对象head.next
        Node node1 = head.next;
        Node node2 = OtherNode.head.next;
        //创建一个新的NodeManage对象存放，合并后新的链表
        NodeManage NewNodeManage = new NodeManage();
        Node node3 = NewNodeManage.head;
        //创建布尔值flag，用来判断链表是否合并中断
        boolean flag = false;

        while (node1 != null && node2 != null){  //用过两个链表之间的对比，有序的将节点存放入新的链表当中去
            if (node1.no < node2.no){
                node3.next = node1;
                node1 = node1.next;
                System.out.println("node1.no < node2.no");
            }else if (node2.no < node1.no){
                node3.next = node2;
                node2 = node2.next;
                System.out.println("node1.no > node2.no");
            }else if (node1.no == node2.no){
                System.out.println("两个链表之前有重复no序号的节点对象，合并中断....");
                flag = true;
                break;
            }
            node3 = node3.next;
        }

        //将两个链表以最短链表节点数比较合并之后，将剩余节点书添加
        //判断是否合并链表中断
        if (!flag){
            if (node1 != null){
                while (node1 != null){
                    node3 = node1;
                    node1 = node1.next;
                }
            }else {
                while (node2 != null){
                    node3 = node2;
                    node2 = node2.next;
                }
            }
        }
        return NewNodeManage;
    }

    //
}

public class DoubleLink {
    public static void main(String[] args) {
        //创建管理类对象
        NodeManage manage = new NodeManage();

        //创造节点类对象
        Node node1 = new Node(1,"wmt1",18);
        Node node2 = new Node(2,"wmt2",19);
        Node node3 = new Node(3,"wmt3",20);
        Node node4 = new Node(4,"wmt4",21);

        manage.add(node1);
        manage.add(node3);
        manage.add(node2);
        manage.add(node4);
        System.out.println(manage);

        int size = manage.getSize();
        System.out.println("链表的长度："+size);

        Node node = manage.getLastNode(2);
        System.out.println("倒数第二个节点："+node);
        Node otherNode = manage.getLastNode(5);
        System.out.println("倒数第5个节点："+otherNode);

        manage.Reverse();
        System.out.println("\n反转之后的链表：");
        System.out.println(manage);

        System.out.println("将链表中的节点反向遍历打印");
        manage.ReversePrint();

        NodeManage manage1 = new NodeManage();
        NodeManage manage2 = new NodeManage();
        NodeManage manage3 = new NodeManage();

        Node a1 = new Node(1,"wmt1",18);
        Node a2 = new Node(2,"wmt2",19);
        Node a3 = new Node(3,"wmt3",20);
        Node a4 = new Node(4,"wmt4",21);
        Node a5 = new Node(5,"wmt5",22);
        Node a6 = new Node(6,"wmt6",23);
        Node a7 = new Node(7,"wmt7",24);
        Node a8 = new Node(8,"wmt8",25);

        manage1.add(a2);
        manage1.add(a5);
        manage1.add(a6);
        manage1.add(a8);
        manage2.add(a4);
        manage2.add(a1);
        manage2.add(a7);
        manage2.add(a3);

        manage3 = manage1.MergeLink(manage2);
        System.out.println(manage3);
    }
}

//===========================================创建节点对象=====================================
class Node{
    public int no;
    public String name;
    public int age;
    public Node previous;
    public Node next;

    //构造器
    public Node(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    //重写toString方法

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}