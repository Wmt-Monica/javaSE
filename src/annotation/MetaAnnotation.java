package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 元注解
 * 作用 ：就是负责注解其他注解，Java定义了4个标准的meta-annotation类型，
 * 它们被用来提供对其他annotation类型作说明
 * 这些类型和它们所支持的类在java.lang.annotation包中可以找到
 * @Target
 * @Retention
 * @Documented
 * @Inherited
 */
public class MetaAnnotation {
    public static void main(String[] args) {

    }
    /**
     * @Target
     * 作用：
     * 用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
     * ---------------------------------------------------
     * 所修饰的范围           取值ElementType
     * ---------------------------------------------------
     * package               PACKEAGE
     * ---------------------------------------------------
     * 类，接口，枚举，        TYPE
     * Annotation类型
     * ---------------------------------------------------
     * 类型成员(方法，构造，   CONSTRUCTOR：用于描述构造器
     * 方法，成员变量，枚举    FIELD：用于描述域
     * 值)                   METHOD：用于描述方法
     * --------------------------------------------------
     */
    //单个权限
    @Target(value = ElementType.METHOD)
    public @interface target{

    }

    //多个权限
    @Target(value = {ElementType.METHOD,ElementType.TYPE})
    public @interface targets{

    }

    /**
     * @Retention
     * 作用：
     * 表示需要在什么级别保存该注释信息，用于描述注解的生命周期
     * SOURCE   在源文件中有效（即源文件保留）
     * CLASS    在class文件中有效（即class保留）
     * RUNTIME  在运行是有效（即运行时保留），为Runtime可以被反射机制读取
     */
}
