package annotation;

/**
 * 内置注解
 */
public class BuiltInAnnotations {
    public static void main(String[] args) {
        test t = new test();
        t.lost();
    }

    static class test{
        /**
         * @override (重写)
         * 定义在java.lang.Override中，此注解只适用于修饰方法，表示一个方法
         * 声明打算重写超类的另一个方法声明
         *
         * 注意：如果使用@override注解但是在父类中没有该要重写的方法会报错
         */
        @Override
        public String toString() {
            return "重写的toString()方法";
        }

        /**
         * @Deprecated (已弃用)
         * 定义在java.lang.Deprecated中，此注释可用于修饰方法，属性，类
         * 表示不鼓励程序员使用这样的元素，通常是因为它很危险或者存在更好
         * 的选择
         */
        @Deprecated
        public void lost(){
            System.out.println("该方法被已弃用的注解修饰了，不建议程序员使用");
        }

        /**
         * @SuppressWarnings (镇压警告信息)
         * 定义在java.lang.SuppressWarnings中，用来抑制编译时的警告信息
         *
         * 参数类型
         * 1.deprecation 使用了过时的类或方法的警告
         * 2.unchecked 执行了未检查的转换时的警告，如使用了集合未指定泛型
         * 3.fallthrough 当在switch语句中使用时发生了case穿透
         * 4.path 在类路径，源文件路径等中又不存在路径的警告
         * 5.serial 当在可序列化的类缺少serialVersionUID定义时的警告
         * 6.finally 任何finally子句不能完成时的警告
         * 7.all 关于以上所有情况的警告
         *
         * 当只有镇压一中警告类型时
         * @SuppressWarnings("deprecation")
         * 当要指定多种类型时，使用value = 大括号括起来{}
         * @SuppressWarings(value = {"unchecked","deprecation"})
         */
    }

}
