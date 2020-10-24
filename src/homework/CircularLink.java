package homework;

/**
 * 约瑟夫圈：
 */

//创建管理节点的类
class NodeManage2{

    //定义一个头节点
    Node2 head;
    //辅助节点(head节点的前一个节点)
    Node2 helpNode;

    //重写toString方法
    @Override
    public String toString() {
        if (isEmpty()){
            System.out.println("链表为空");
        }else {
            Node2 stp = head;
            while (stp.next != head){
                System.out.println(stp);
                stp = stp.next;
            }
            System.out.println(stp);
        }
        return "";
    }

    //判断链表是否为空isEmpty()方法
    public boolean isEmpty(){
        return head == null;
    }

    //添加节点add()方法
    public void add(Node2 addNode){
        if (isEmpty()){  //当链表为空时，直接添加节点数据
            head = addNode;
            //辅助节点先暂时定位到头节点
            helpNode = head;
            head.next = head;  //即使只有一个元素也要形成环状链表
        }else {
            Node2 stp = head;
            while (stp.next != head){  //将临时节点指向尾节点
                stp = stp.next;
            }
            stp.next = addNode;
            helpNode = addNode;  //添加数据的同时将helpNode位置下移一位
            addNode.next = head;  //将环状链表连接起来
        }
    }

    //创建约瑟夫圈方法
    public void Joseph(int num, int space){

        //找到对应first的Node对象
        Node2 stp = head;
        boolean flag = false;  //判断是否找到第一个节点
        while (stp.next != head){
            if (stp.num == num){
                flag = true;
                break;
            }
            stp = stp.next;
        }
        if (!flag){
            System.out.println("未查找到第一个startNode节点");
            return;
        }
        //先将head和helpNode移动到至head == startNode
        while (head != stp){
            head = head.next;
            helpNode = helpNode.next;
        }
        System.out.println("所查找到第一个删除的位置："+head);
        System.out.println("所查找到第一个删除的前一个位置："+helpNode);

        int j = 1;
        while (helpNode != head){
            //当head移动到要删除的节点
            System.out.println("删除"+head);
            helpNode.next = head.next;
            head = head.next;
            System.out.println("head:"+head);

            System.out.println("第"+j+"轮第"+1+"次下移");
            //将head移动到下一个要删除的节点
            for (int i = 1; i < space; i++){
                head = head.next;
                helpNode = helpNode.next;
                System.out.println("第"+j+"轮第"+(i+1)+"次下移");
            }
            j++;
        }
    }


}

//创建节点类
class Node2{
    int num;
    Node2 next;

    //构造器
    public Node2(int num) {
        this.num = num;
    }

    //重写toString方法

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                '}';
    }
}
//===========================main方法=====================================
public class CircularLink {
    public static void main(String[] args) {
        NodeManage2 manage = new NodeManage2();
        for (int i = 0; i < 10; i++){
            manage.add(new Node2(i));
        }
        System.out.println(manage);
        System.out.println("head:"+manage.head);
        System.out.println("helpNode:"+manage.helpNode);
        System.out.println("\n============================================");

        manage.Joseph(2,3);
        System.out.println(manage);
    }
}