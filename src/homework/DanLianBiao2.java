package homework;

import java.util.Stack;

//管理Hero对象的类
class HeroManage{
    //创建Hero对象节点的头节点 (头节点不实际存放数据)
    Hero head = new Hero(0,"",0);

    //按照 no (排名)添加节点的 add() 方法 ,确保不重复添加相同排名的节点======================================
    public void add(Hero hero){
        boolean flag = false;//用于判断排名是否重复

        //头节点不能改变，用临时Hero对象stp存储头节点head
        Hero stp = head;

        while (true){
            //到了尾节点跳出循环
            if (stp.next == null){
                break;
            }else if (stp.next.no > hero.no){  //找到要插入的位置
                break;
            }else if (stp.next.no == hero.no){ //发现有着重复排名的节点，flag标记跳出循环
                flag = true;
                break;
            }else {  //如果没有找到，则下移一个节点
                stp = stp.next;
            }
        }

        //判断是否有重复排名的节点对象=======================================================
        if (flag){
            System.out.print(hero);
            System.out.println("该排名已有Hero对象，添加失败");
        }else {
            //找到插入位置，添加数据
            hero.next = stp.next;
            stp.next = hero;
            System.out.println("添加成功");
        }
    }

    //重写HeroMange对象的toString()方法====================================================
    @Override
    public String toString() {
        //头节点不能改变，用临时 Hero 对象存储
        Hero stp = head;

        while (stp.next != null){
            System.out.println("no:"+stp.next.no+"\tname:"+stp.next.name+"\tage:"+stp.next.age);
            stp = stp.next;
        }
        return "";
    }

    //根据序号，修改节点数据=============================================================
    //根据序号更改对应节点对象的name
    public void Change(int no, String name){
        Hero hero;
        for (hero = head.next; hero != null; hero = hero.next){
            if (hero.no == no){
                hero.name = name;
                break;
            }
        }
        if (hero == null){ //到达尾节点，未找到该序号的Hero节点对象
            System.out.println("为查找到该序号的节点，更改失败....");
        }else {
            System.out.println("更改成功....");
        }
    }
    //根据序号更改对应节点对象的age===========================================================
    public void Change(int no, int age){
        Hero hero;
        for (hero = head.next; hero != null; hero = hero.next){
            if (hero.no == no){
                hero.age = age;
                break;
            }
        }
        if (hero == null){ //到达尾节点，未找到该序号的Hero节点对象
            System.out.println("为查找到该序号的节点，更改失败....");
        }else {
            System.out.println("更改成功....");
        }
    }
    //根据序号更改对应节点的所有数据===============================================================
    public void Change(int no, String name, int age){
        Hero hero;
        for (hero = head.next; hero != null; hero = hero.next){
            if (hero.no == no){
                hero.name = name;
                hero.age = age;
                break;
            }
        }
        if (hero == null){ //到达尾节点，未找到该序号的Hero节点对象
            System.out.println("为查找到该序号的节点，更改失败....");
        }else {
            System.out.println("更改成功....");
        }
    }
    //直接传入Hero对象更改节点数据============================================================
    public void Change(Hero NewHero){
        Hero hero;
        for (hero = head.next; hero != null; hero = hero.next){
            if (hero.no == NewHero.no){
                hero.name = NewHero.name;
                hero.age = NewHero.age;
                break;
            }
        }
        if (hero == null){ //到达尾节点，未找到该序号的Hero节点对象
            System.out.println("为查找到该序号的节点，更改失败....");
        }else {
            System.out.println("更改成功....");
        }
    }

    //根据序号删除节点对象
    public void delete(int no){
        if (isEmpty()){
            System.out.println("链表为空，无可删除的节点....");
        }else {
            Hero hero;
            for (hero = head; hero.next != null; hero = hero.next){
                if (hero.next.no == no){
                    hero.next = hero.next.next;
                    System.out.println("删除成功....");
                    break;
                }
            }
            if (hero == null){
                System.out.println("未找到该序号所对应的Hero节点对象,删除失败....");
            }
        }
    }

    //判断单链表是否为空
    public boolean isEmpty(){
        if (head.next == null){
            return true;
        }else {
            return false;
        }
    }

    //获取链表的总结点数
    public int getSize(){
        if (isEmpty()){
            return 0;
        }else {
            Hero hero = head.next;
            int length = 0;
            while (hero != null){
                length++;
                hero = hero.next;
            }
            return length;
        }
    }

    //获取链表倒数第n个节点的数据
    public void Seek(int n){
        if (isEmpty()){
            System.out.println("该链表为空....");
        }else if (n <= 0 || n > (getSize())){
            System.out.println("所寻找节点超过链表长度....");
        }else {
            Hero hero = head.next;
            for (int i = 0; i != (getSize()-n); i++){
                hero = hero.next;
            }
            System.out.println(hero);
        }
    }

    //将单链表反转
    public void Reverse(){
      Hero hero = head.next;
      Hero next;
      Hero NewHero = new Hero(0,"",0);
      while (hero != null){
          next = hero.next;
          hero.next = NewHero.next;
          NewHero.next = hero;
          hero = next;
      }
      head.next = NewHero.next;
    }

   //将链表从尾部开始打印 要求：反向遍历，运用栈
    public void ReversePrint(){
        //创建栈对象
        Stack<Hero> stack = new Stack<>();

        //遍历链表，将Hero对象入栈
        for (Hero hero = head.next; hero != null; hero = hero.next){
            stack.add(hero);
        }

        //用pop()方法，将栈中的元素从尾部开始出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    //将两个有序链表合并，合并后的链表任然为有序
    public HeroManage MergeHero(HeroManage OtherHero){
        //创建一个新的链表
        Hero NewHero;
        HeroManage NewHeroMange = new HeroManage();
        NewHero = NewHeroMange.head;
        Hero hero1 = head.next;
        Hero hero2 = OtherHero.head.next;

        //判断链表是否合并成功
        boolean flag = true;

        while (hero1 != null && hero2 != null){
            if (hero1.no < hero2.no){
                NewHero.next = hero1;
                hero1 = hero1.next;
                NewHero = NewHero.next;
                System.out.println("hero1.no < hero2.no");
            }else if (hero2.no < hero1.no){
                NewHero.next = hero2;
                hero2 = hero2.next;
                NewHero = NewHero.next;
                System.out.println("hero1.no > hero2.no");
            }else {
                flag = false;
                break;
            }
        }
        //将最后未添加的节点对象添加入新的链表
        if (flag){
            if (hero1 != null){
                while (hero1 != null){
                    NewHero.next = hero1;
                    hero1 = hero1.next;
                }
            }else {
                while (hero2 != null){
                    NewHero.next = hero2;
                    hero2 = hero2.next;
                }
            }
        }

        //打印新的链表
        for (Hero hero = NewHeroMange.head.next; hero != null; hero = hero.next){
            System.out.println(hero);
        }

        //判断链表是否合并成功，返回新的链表
        if (flag){
            System.out.println("链表合并成功");
            return NewHeroMange;
        }else {
            System.out.println("两个链表中出现重复序号的Hero对象，链表合并中断....");
            return NewHeroMange;
        }
    }

    int seat = 1;
    //使用递归，根据值来查找位置
    public int Found(Hero hero,String nameValue){
        if (hero.name.equals("wmt5")){
            return seat;
        }else {
            seat++;
            hero = hero.next;
            Found(hero,nameValue);
        }
        return seat;
    }
}

public class DanLianBiao2 {
    public static void main(String[] args) {
        //创建几个节点对象
        Hero hero1 = new Hero(1,"wmt1",19);
        Hero hero2 = new Hero(2,"wmt2",20);
        Hero hero3 = new Hero(3,"wmt3",21);
        Hero hero4 = new Hero(4,"wmt4",22);

        //创造管理对象类对象
        HeroManage heroManage = new HeroManage();

        //按照排名有序的添加数据
        heroManage.add(hero1);
        heroManage.add(hero3);
        heroManage.add(hero4);
        heroManage.add(hero2);
        heroManage.add(hero2);
        System.out.println();

        //输出
        System.out.println(heroManage);

        //更改节点数据
        heroManage.Change(1,"SF01");
        heroManage.Change(2,21);
        heroManage.Change(3,"SF03",22);
        Hero NewHero = new Hero(4,"SF04",23);
        heroManage.Change(NewHero);
        heroManage.Change(5,"SF05");
        System.out.println();

        System.out.println(heroManage);

        //获取链表的总结点数
        System.out.println("该链表的总结点数量："+heroManage.getSize());

        //获取链表倒数第2节点的Hero对象数据
        heroManage.Seek(2);

        System.out.println("反转前：");
        System.out.println(heroManage);
        heroManage.Reverse();
        System.out.println("反转后：");
        System.out.println(heroManage);

        System.out.println("===============将链表反向打印===============");
        heroManage.ReversePrint();
        System.out.println();

        //删除节点对象
        heroManage.delete(1);
        heroManage.delete(2);
        heroManage.delete(3);
        heroManage.delete(4);
        heroManage.delete(4);
        System.out.println(heroManage);

        //合并两个链表
        HeroManage heroManage1 = new HeroManage();
        HeroManage heroManage2 = new HeroManage();

        Hero a1 = new Hero(1,"wmt1",19);
        Hero a2 = new Hero(2,"wmt2",20);
        Hero a3 = new Hero(3,"wmt3",21);
        Hero a4 = new Hero(4,"wmt4",22);
        Hero a5 = new Hero(5,"wmt5",20);
        Hero a6 = new Hero(6,"wmt6",21);
        Hero a7 = new Hero(7,"wmt7",22);
        Hero a8 = new Hero(8,"wmt8",19);

        heroManage1.add(a3);
        heroManage1.add(a6);
        heroManage1.add(a8);
        heroManage1.add(a1);
        heroManage2.add(a4);
        heroManage2.add(a7);
        heroManage2.add(a2);
        heroManage2.add(a5);

        HeroManage NewHeroMange = heroManage1.MergeHero(heroManage2);
        System.out.println("===============合并后的新链表=================");
        System.out.println(NewHeroMange);

        Hero hero = NewHeroMange.head.next;
        int seat = NewHeroMange.Found(hero,"wmt5");
        System.out.println("wmt5的位置："+seat);
    }
}

//创建节点对象类
class Hero{

    //对象属性
    public int no;
    public String name;
    public int age;
    public Hero next;

    //创建构造器
    public Hero(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    //重写toSting()方法

    @Override
    public String toString() {
        return "Hero{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}