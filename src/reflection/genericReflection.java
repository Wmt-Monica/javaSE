package reflection;

import java.lang.reflect.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * java采用泛型擦除的机制来引入泛型，Java中的泛型仅仅是给编译器javac使用的
 * 确保数据的安全性和免去强制类型转换的麻烦，但是，一旦编译完成，所有的和泛型
 * 有关的类型全部擦除
 *
 * 为了反射操作这些数据类型，Java新增了ParameterizedType,GenericArrayType
 * TypeVariable和WildcardType集中类型来代表不能归一到Class类中的类型，但是
 * 有和原始类型齐名的类型
 *
 * ParameterizedType: 表示一种参数化的类型，比如Collection<String>
 * GenericArrayType: 表示一种元素类型时参数化类型或者类型变量的数组类型
 * TypeVariable: 是各种类型变量的公共父接口
 * WildcardType: 代表一种通配符类型表达式，比如？，？extends Number,?super Integer
 */
public class genericReflection {
    public static void main(String[] args) throws NoSuchMethodException {
        Method m = genericReflection.class.getMethod("genericMethod",Map.class,List.class);
        Type[] t = m.getGenericParameterTypes();
        for (Type paramType : t){
            if (paramType instanceof ParameterizedType){
                Type[] genericType = ((ParameterizedType) paramType).getActualTypeArguments();
                for (Type genericTypes : genericType){
                    System.out.println("泛型类型："+genericTypes);
                }
            }
        }

        System.out.println();
        Method m2 = genericReflection.class.getMethod("genericMethod",null);
        Type returnType = m2.getGenericReturnType();
        if (returnType instanceof ParameterizedType){
            Type[] genericType = ((ParameterizedType) returnType).getActualTypeArguments();
            for (Type genericTypes : genericType){
                System.out.println("返回值，泛型类型："+genericTypes);
            }
        }

    }

    public void genericMethod(Map<String,Integer> map, List<genericClass> list){
        System.out.println("genericMethod()");
    }

    public Map<String,Integer> genericMethod(){
        Map<String ,Integer> map = new LinkedHashMap<>();
        return map;
    }


    class genericClass{
        Map<String,Boolean> map;
        Constructor<String> constructor;
    }
}
