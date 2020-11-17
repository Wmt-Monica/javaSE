package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * setAccessible
 * 期用和禁止访问安全检查的开关，值为true则指示反射的对象在使用时因该取消java
 * 语言访问检查，值为false则指示反射的对象应该实施Java语言访问检查，并不是为true
 * 就能访问false就不能访问
 * 禁止安全检查，可以提高反射的运行速度
 */
public class setAccessibleToUpFunction {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
       ordinaryMethod();
       notSetAccessible();
       setAccessibleMethod();
    }

    public static void ordinaryMethod(){
        setAccessibleClass setAccessible = new setAccessibleClass();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000L; i++){
            setAccessible.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用类方法耗时："+(endTime-startTime)+"ms");
    }

    public static void notSetAccessible() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        setAccessibleClass setAccessible = new setAccessibleClass();
        Class clazz = setAccessible.getClass();
        Method method = clazz.getDeclaredMethod("getName",null);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000L; i++){
            method.invoke(setAccessible,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用类方法耗时："+(endTime-startTime)+"ms");
    }

    public static void setAccessibleMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        setAccessibleClass setAccessible = new setAccessibleClass();
        Class clazz = setAccessible.getClass();
        Method method = clazz.getDeclaredMethod("getName",null);
        method.setAccessible(true);  //设置为不需要进行安全检查

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000L; i++){
            method.invoke(setAccessible,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用类方法耗时："+(endTime-startTime)+"ms");
    }
}

class setAccessibleClass{
    private String name = "王梦婷";

    public String getName() {
        return name;
    }
}