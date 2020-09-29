package Integer;

public class IntegerTest {
    public static void main(String[] args) {
        //基本数据类型转换成包装类对象
        Integer a1 = new Integer(19);  //创建Integer对象，在里面参数里面放置value值
        Integer a2 = Integer.valueOf(21);  //直接调用Integer对象方法里面的valueOf方法

        //将包装类对象转换成基本数据类型
        int b1 = a1.intValue();  //调用Integer对象里面的intValue方法，使得包装类对象变成基本数据类型
        double b2 = a2.doubleValue();  //数据类型(Value())

        //将字符串装换成Integer对象
        Integer c1 = new Integer("20010501");  //创建Integer对象将数字值的字符串传入数据
        //使用Integer对象方法里面的parseInt方法，使得数字值的字符串转换成Integer对象,其他类型相似用法
        Integer c2 = Integer.parseInt("199901007");
        Double c3 = Double.parseDouble("2439.342");

        //将Integer对象转换成字符串
        String str = c2.toString();

        System.out.println("a1:"+a1);
        System.out.println("a2:"+a2);
        System.out.println("b1:"+b1);
        System.out.println("b2:"+b2);
        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);
        System.out.println("c3:"+c3);
        System.out.println("str:"+str);
    }
}
