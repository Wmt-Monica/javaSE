package reflection.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 可以通过反射API：getAnnotations,getAnnotation获得相关的注解信息
 */
public class annotationReflection {

    public static void main(String[] args) {

        try {
            Class clazz = Class.forName("reflection.annotation.annotationTest");

            //1.获得类的所有注解
            System.out.println("获取类的所有注解：");
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations){
                System.out.println(a);
            }
            System.out.println();

            //2.获得类的指定注解
            annotationTest annotationTest = (reflection.annotation.annotationTest)
                    clazz.getAnnotation(reflection.annotation.annotationTest.class);
            System.out.println(annotationTest.age());

            //3.获得属性的注解
            Field field = clazz.getDeclaredField("age");
            annotationTest test = field.getAnnotation(annotationTest.class);
            System.out.println(test.name()+"---"+test.type());

        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    class annotationClass{
        @annotationTest(name = "王梦婷",type = "wmt",age = 19)
        String name = "王梦婷";
        @annotationTest(name = "石燔",type = "sf",age = 21)
        String name2 = "石燔";
    }
}
