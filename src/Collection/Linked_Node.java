package Collection;

public class Linked_Node<E> {

    public Linked_Node<E> previous;  //上一个节点
    public Linked_Node<E> next;      //下一个节点
    public E date;      //节点数据

    public Linked_Node(E date){  //构造器
        this.date = date;
    }
}
