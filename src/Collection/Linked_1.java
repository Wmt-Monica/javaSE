package Collection;

public class Linked_1 {
    private Linked_Node first;
    private Linked_Node last;
    private int size = 0;

    //添加数据add()方法
    public void add(Object date){
        Linked_Node node = new Linked_Node(date);
        //假设这是第一个节点，将头节点和尾节点都设置为这个节点(当是第一个节点时，那它的最后一个元素为null)
        if (last == null || first == null){
            first = node;
            last = node;
        }else {
           node.previous = last;  //这个新节点的上一个节点指向last
           node.next = null;      //这个新结点的下一个节点指向null
           last.next = node;      //last的下一个节点指向新节点
           last = node;           //将last指向新节点
        }
        size++;                   //整个链表长度加一
        System.out.println("添加成功");
    }

    //重写toString方法，打印链表
    @Override
    public String toString() {
        //对链表是否为空进行判断
        if (isEmpty()){
            return "链表为空";
        }else{
            Linked_Node node = new Linked_Node(null);
            node = first;
            while (node != null){
                System.out.print(node.date+"\t");
                node = node.next;
            }
            System.out.println();
            return "Linked_1{" +
                    "first=" + first.date +
                    ", last=" + last.date +
                    ", size=" + size +
                    '}';
        }
    }

    //判断链表是否为空isEmpty()方法
    public boolean isEmpty(){
        if (first == null){
            return true;
        }else {
            return false;
        }
    }

    //移除链表中的元素deleteLink()方法
    public void deleteLink(int index){
        //先对链表是否为空进行判断
        if (isEmpty()){
            System.out.println("链表为空");
        }else{
            //对索引的判断
            if (isIndex(index)){
                Linked_Node node = new Linked_Node(null);
                node = first;
                for (int i = 1; i < size ; i++){
                    if (i == (index-1)){  //当循环到要删除的元素的前一个元素时，改变指针指向
                        node.next = node.next.next;
//                System.out.println("改变了前面的next指向");
                        node.next.previous = node;
//                System.out.println("改变了后面的previous指向");
                        size--;
                        break;
                    }else{
                        node = node.next;
                    }
                }
            }
        }
    }

    //删除链表全部的内容
    public void deleteAllLink(){
        if (isEmpty()){
            System.out.println("链表为空");
        }else {
            first = null;
            last = null;
        }
    }

    //在链表中插入节点
    public void addInsert(Object object,int index){
        //先对插入index进行判断
        if (isIndex(index)){
            int i = 1;
            Linked_Node node = new Linked_Node(null);
            Linked_Node addNode = new Linked_Node(null);
            addNode.date = object;
            node = first;
            while (i != index){
                if (i == (index-1)){
                    //先建立插入节点与原来位置上节点的联系，防止后面的节点数据丢失
                    //再来建立插入节点与前面一个节点之间的联系
                    if (node.next != null){
                        addNode.next = node.next;
                    }else {
                        addNode.next = null;
                    }
                    node.next.previous = addNode;
                    node.next = addNode;
                    addNode.previous = node;
                    size++;
                }
                node = node.next;
                i++;
            }
        }
    }

    //判断索引是否正确
    public boolean isIndex(int index){
        if (index >= 1 && index <= size){
            return true;
        }else {
            System.out.println("插入索引超出范围，请确认后重新输入");
            return false;
        }
    }

    //根据索引，获取链表中的数据
    public Object getLinked(int index){
        Linked_Node node = new Linked_Node(null);
        if (isIndex(index) && !isEmpty()){
            node = first;
            int i = 1;
            while (i != index){
                node = node.next;
                i++;
            }
        }
        return node.date;
    }

    //根据索引覆盖原来该节点的数据
    public void setLinked(Object date,int index){
        if (isIndex(index)){
            Linked_Node node = new Linked_Node(null);
            node = first;
            for (int i = 1 ; i <= index ; i++){
                if (i == index){
                    node.date = date;
                    break;
                }else {
                    node = node.next;
                }
            }
        }
    }


    public static void main(String[] args) {
        Linked_1 linked = new Linked_1();
        System.out.println(linked);
        System.out.println("================添加=================");
        linked.add("A");
        System.out.println(linked);
        System.out.println("================添加=================");
        linked.add("B");
        System.out.println(linked);
        System.out.println("================添加=================");
        linked.add("C");
        System.out.println(linked);
        System.out.println("================删除=================");
        linked.deleteLink(2);
        System.out.println(linked);
        System.out.println("================插入=================");
        linked.addInsert("B",2);
        System.out.println(linked);
        System.out.println("================插入=================");
        linked.addInsert("B",4);
        System.out.println(linked);
        System.out.println("================获取=================");
        System.out.println("索引为2的元素为："+linked.getLinked(2));
        System.out.println(linked);
        System.out.println("================覆盖=================");
        linked.setLinked("E",2);
        System.out.println(linked);
        System.out.println("================清空=================");
        linked.deleteAllLink();
        System.out.println(linked);

    }
}
