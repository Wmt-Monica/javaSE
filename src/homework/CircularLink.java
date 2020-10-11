package homework;

/**
 * 单向环形链表
 */
public class CircularLink {
    public static void main(String[] args) {
        ListManage listManage = new ListManage();
        List list1 = new List(1,"wmt1",18);
        List list2 = new List(2,"wmt2",19);
        List list3 = new List(3,"wmt3",20);
        List list4 = new List(4,"wmt4",21);
        listManage.add(list1);
        listManage.add(list3);
//        listManage.add(list4);
//        listManage.add(list2);
        System.out.println(listManage);
    }
}

//创建管理List节点的类
class ListManage{

    //创建List头节点喝尾节点对象
    List first;
    List last;

    //判断链表是否为空
    public boolean isEmpty(){
        if (first == null){
            return true;
        }else {
            return false;
        }
    }

    //为节点有序的添加数据
    public void add(List list){

        //判断链表是否为空
        if (isEmpty()){
            //链表为空，直接添加节点对象
            first = list;
            //由于链表只有一个节点，任然要形成环形，将尾部节点指向第一个节点对象
            last = list;
            last.next = first;
        }else {
            //创造临时List对象存放first节点对象
            List head = first;

            //创建布尔值判断是否有重复数据
            boolean flag = false;

            while (true){
                //当找到尾节点仍未找到下一个节点比插入节点no数的节点，直接放在尾节点后面
                if (head.no == list.no){
                    flag = true;
                    break;
                }else if (first.no > list.no){
                   first = list;
                   list.next = last.next;
                   last.next = first;
                   break;
                }else if (head.next.no > list.no){
                    list.next = head.next;
                    head.next = list;
                    break;
                }else {
                    head = head.next;
                }
            }

            if (flag){
                System.out.println("节点no序号重复，数据添加失败");
            }else {
                System.out.println("数据添加成功");
            }
        }
    }

    //重写toString方法

    @Override
    public String toString() {
        List list = first;
        if (list != null){
            System.out.println(list);
            list = list.next;
        }
        return "";
    }
}

//创建节点对象
class List{
    public int no;
    public String name;
    public int age;
    public List next;

    //构造器
    public List(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    //重写toString方法


    @Override
    public String toString() {
        return "List{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
