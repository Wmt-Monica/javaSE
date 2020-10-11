package Class;

public class chuanZhiJiZhi {
    int age;
    String name;
    public chuanZhiJiZhi(int age,String name){
        this.age = age;
        this.name = name;
        System.out.println("age:" + age + "\t" + "name:" + name);
    }
    public void change(int age,String name){
        /*此处虽然使用的时值传递，但是使用的是同一个对象的地址，故应此调用该方法会改变成员变量的值*/
        this.age = age;
        this.name = name;
    }
    public void chuan_2(chuanZhiJiZhi chuan){
        chuan.age =13;
        chuan.name ="DreamPlume_3";
    }
    public void chuan_3(chuanZhiJiZhi chuan){
        chuanZhiJiZhi chuan_2 = new chuanZhiJiZhi(19,"wmt");
        chuan_2.chuan_2(chuan_2);
        System.out.println("age:"+chuan_2.age+"\t"+"name:"+chuan_2.name);
        chuan_2.age = 14;
        chuan_2.name = "DreamPlume_4";
        System.out.println("age:"+chuan_2.age+"\t"+"name:"+chuan_2.name);
    }
    public static void main(String[] args) {
        chuanZhiJiZhi chuan = new chuanZhiJiZhi(19,"wmt");
        chuan.age = 18;
        chuan.name = "wmt";
        System.out.println("age:" + chuan.age + "\t" + "name:" + chuan.name);
        chuan.change(19, "WMT");
        System.out.println("age:" + chuan.age + "\t" + "name:" + chuan.name);
        chuan.chuan_2(chuan);
        System.out.println("age:" + chuan.age + "\t" + "name:" + chuan.name);
        chuan.chuan_3(chuan);
    }
}
