package Integer;

public class ZIDong {
    public static void main(String[] args) {
        /**
            自动装箱：
                基本数据类型处于需要对象的环境中时，会自动转换成"对象"
                创建数据类型包装列对象时不需要new一个对象，会自动调用valueOf()方法
         */
        Integer a1 = 19;  //自动装箱等价于Integer a1 = Integer.valueOf(19);

        /**
         * 自动装箱：
         *  每当需要一个值的时候，对象会自动转换成一个基本数据类型，
         *  没有必要调用intValue()方法，doubleValue()方法
         * */
        Integer b1 = 5;
        int b2 = b1;  //此处基本数据类型int型被直接用Integer对象b1赋值：（b1这里自动拆箱）
        //等价于：int b2 = b1.valueOf();

        /**
         *  缓存【(-128)-(127)】之间的数字。实际是系统在初始化的时候，创建了【(-128)-(127)】之间的缓存数组
         *  当我们调用valueOf()方法的时候，首先检查数据是否在[-18-127]范围内，如果在这个范围则直接
         *  从缓存数组里已经创建好的对象，如果不在这个范围，则创建新的Integer对象
         * */
        Integer c1 = Integer.valueOf(-128);
        Integer c2 = -128;
        System.out.println("c1==c2:"+(c1==c2));  //在范围内：返回值为 true

        Integer c3 = 128;
        Integer c4 = Integer.valueOf(128);
        System.out.println("c3==c4:"+(c3==c4));  //不在范围内：返回值为 fault





















    }
}
