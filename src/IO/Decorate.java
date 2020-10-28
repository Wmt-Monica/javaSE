package IO;

/**
 * 抽象装饰类的案例
 * 案例一：模拟扩音器
 * 案例二：购买咖啡
 */
public class Decorate {
    public static void main(String[] args) {
        //案例一：模拟扩音器
        people p = new people(10);
        System.out.println("人普通的说话的音量为"+p.voice+"分贝");
        System.out.println("人使用扩音器之后说话的音量为"+p.say()+"分贝");

        //案例二：购买咖啡
        drink coffee = new Coffee();  //一杯咖啡
        drink milk = new milk(coffee);  //一杯咖啡牛奶
        drink sugar = new sugar(coffee);  //一杯咖啡加糖
        System.out.println(milk.toName()+"花费："+milk.cost());
        System.out.println(sugar.toName()+"花费："+sugar.cost());
        milk = new milk(sugar);  //一杯加奶加糖的咖啡
        System.out.println(milk.toName()+"花费："+milk.cost());
    }
}

//扩音器放大声音的接口
interface load{
    public int say ();
}
//people类
class people implements load{
    //声音分贝属性
    int voice = 10;

    //构造器
    public people(int voice){
        this.voice = voice;
    }

    @Override
    public int say() {
        return this.voice*10;
    }
}

//案例二：模拟购买咖啡
/**
 * 1.抽象组件：需要装饰的抽象对象（接口或抽象父类）
 * 2.具体组件：需要装饰的对象
 * 3.抽象包装类：包含了对抽象组件的引用以及装饰着共有的方法
 * 4.具体装饰类：被装饰的对象
 */

//1.抽象组件 
interface drink{
   public int cost();
   public String toName();
}

//2.具体组件
class Coffee implements drink{

    private String name = "coffee";
    private int price = 20;

    @Override
    public int cost() {
        return price;
    }

    @Override
    public String toName() {
        return name;
    }
}

//3.抽象包装类
abstract class addDecorate implements drink{
    //1.抽象组件的引用
   drink dr;
   public addDecorate(drink dr){
       this.dr = dr;
   }

   //重写抽象方法
    @Override
    public int cost() {
        return this.dr.cost();
    }

    @Override
    public String toName() {
        return this.dr.toName();
    }
}

//4.具体装饰类
class milk extends addDecorate {

    public milk(drink dr) {
        super(dr);
    }

    //重写方法
    @Override
    public int cost() {
        return super.cost()+10;
    }

    @Override
    public String toName() {
        return super.toName()+" + milk ";
    }
}

class sugar extends addDecorate{

    public sugar(drink dr) {
        super(dr);
    }

    @Override
    public int cost() {
        return super.cost()+5;
    }

    @Override
    public String toName() {
        return super.toName()+" + sugar ";
    }
}


















