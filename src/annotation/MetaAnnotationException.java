package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)  //使用范围
@Retention(RetentionPolicy.RUNTIME)  //使用生命周期
public @interface MetaAnnotationException {
    //注意：当我们未给参数设置默认值的时候，我们再其他类中使用我们自定义的注解
    //需要在注解后的括号里面输入这些参数的值

    String s();  //数据类型 数据名称 括号()

    //注意：我们一般字符串参数默认值为""空字符，数值型就赋值为0或者时-1
    int i() default 0;  //给int型参数默认值为0
}
