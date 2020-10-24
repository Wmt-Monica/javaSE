package test;

import java.awt.*;

public class DoublyLinkedList {

    private Node head;

    public void DoublyLinkedList() {
        head=null;
    }

    public boolean insert(int item) {
        boolean inserted;
        Node ptr,prev;

        inserted = false;
        ptr = head;
        prev = null;

        while(ptr != null && ptr.getData() < item) {
            prev = ptr;
            ptr = ptr.getNext();
        }

        if(ptr == null || ptr.getData() != item) {
            inserted = true;
            Node newp = new Node();
            newp.setData(item);

            newp.setNext(ptr);
            newp.setPrior(prev);

            if(prev == null)
            {
                head = newp;
            } else {
                if(prev.getNext()!=null)
                    (prev.getNext()).setPrior(newp);
                prev.setNext(newp);
            }
        }
        return inserted;
    }

    public void printRecursive() {
        System.out.print("List Recursive: ");
        printR(head);
        System.out.println();
    }

    private void printR(Node p) {
        if(p != null) {
            System.out.print(p.getData()+" ");
            printR(p.getNext());
        }
    }

    //这个删除功能是要求布尔值返回，判断是否删除成功？
    public boolean delete(int item){
        Node node = head;
        boolean flag = false;
        while (node.getNext() != null){
            if (node.getData() == item){
               Node p = node.getPrior();
               Node n = node.getNext();
               p.setNext(n);
               n.setPrior(p);
               flag = true;
            }
            node = node.getNext();
        }
        return flag;
    }

    //遍历链表
    public void printNodesTest(){
        Node stp;
        for (stp = head; stp.getNext()!= null; stp = stp.getNext()){
            System.out.print(stp.getData()+"\t");
        }
        System.out.println(stp.getData());
        System.out.println("遍历完毕");
    }

}

//节点类
class Node {
    private int data;
    private Node prior;
    private Node next;

    public Node(){
        this(0);
    }

    public Node(int data) {
        this.data = data;
        prior=null;
        next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPrior() {
        return prior;
    }

    public void setPrior(Node prior) {
        this.prior = prior;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}


//PrintNodes类
class PrintNodes {

    public static void main(String[] args) {

        DoublyLinkedList list;
        list = new DoublyLinkedList();

        //Add four nodes.
        System.out.println("\ninsert 27,115,16,25");

        list.insert(27);
        list.insert(115);
        list.insert(16);
        list.insert(25);

        list.printRecursive();
        //list.printNodesTest();

        System.out.println("=============================================");
        //删除链表
        System.out.println("删除值为27的节点是否删除成功："+list.delete(27));
        //遍历链表看是否删除成功
        list.printNodesTest();

    }

}