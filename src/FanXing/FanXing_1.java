package FanXing;

public class FanXing_1 {
    public static void main(String[] args) {
        a <String> a1 = new a<>();  //创建类型a的String 对象
        a1.set("WMT",0);
        System.out.println("a1[0]:"+a1.get(0));
        b<String> b1 = new b<>();
        b1.set("SF",0);
        System.out.println("b1[0]:"+b1.get(0));
    }
}

class a <E>{  //尖括号里面可以填写任何可以代表类型的形参
    Object[] object = new Object[10];
    public void set(E e,int i){
        object[i] = e;
    }
    public E get(int i){
        return (E) object[i];
    }
}

class b <Sting>{  //可以直接就提前确定好类型
    Object[] object = new Object[10];
    public void set(String e,int i){
        object[i] = e;
    }
    public String get(int i){
        return (String) object[i];
    }
}