package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射机制动态操作构造器，方法，属性
 */
public class DynamicOperation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String path = "reflection.reflectionClass";
        Class clazz = Class.forName(path);  //通过类的名字获取类对象

        //获取类的名字
        System.out.println("allName: "+clazz.getName());  //获取类的名字
        System.out.println("simpleName: "+clazz.getSimpleName());  //获取类名称的简称

        //获取属性的信息
        Field[] fields = clazz.getFields();  //获取所有的公开的属性(public)
        System.out.println("\nreflectClass中所有公开的属性：");
        for (Field f : fields){
            System.out.println("属性："+f);
        }
        System.out.println();

        //如果想获取该类中所有的属性使用getDeclaredFields()方法
        Field[] fields2 = clazz.getDeclaredFields();
        System.out.println("reflectClass中所有的属性：");
        for (Field f : fields2){
            System.out.println("属性："+f);
        }
        System.out.println();

        //指定属性名获取改类中的属性 (只能是公开的属性，否则在类中找不到该属性)
        Field field3 = clazz.getField("name");
        System.out.println("获取的特定的属性name: "+field3);

        //获得指定属性时，假如该属性不是公开的，我们可以对该属性使用setAccessible()方法传入true参数
        //这样该属性可以不用经过安全检查就可以直接访问?
        try {
            reflectionClass Class4 = (reflectionClass) clazz.newInstance();
            Class4.setAge(19);
            System.out.println("\n获取的特定的属性age: "+Class4.getAge()+"\n");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //获取方法信息
        Method[] method1 = clazz.getMethods();
        for (Method m : method1){
            System.out.println("方法: "+m);
        }
        System.out.println();

        //获得指定方法时,前面传入方法名，后面传入方法中传入的参数的类，假如没有参数就传入null
        Method method2 = clazz.getDeclaredMethod("haveParameterMethod", int.class, String.class);
        System.out.println("haveParameterMethod(): "+method2+"\n");
        Method method3 = clazz.getDeclaredMethod("noHaveParameterMethod",null);
        System.out.println("naveParameterMethod(): "+method3+"\n");

        //获得构造器信息
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors){
            System.out.println("构造器: "+c);
        }
        System.out.println();

        //获得指定的构造器，后面传入参数，想要指定获取无参构造器就在后面的参数传入null
        Constructor constructor = clazz.getConstructor(int.class,int.class,String.class,boolean.class);
        System.out.println("指定获取有参构造器："+constructor+"\n");
        Constructor constructor1 = clazz.getConstructor(null);
        System.out.println("指定获取无参构造器："+constructor1+"\n");

        //通过反射API调用构造方法，构造对象
        //注意：以下调用的是无参的构造方法，javabean因此不管是否需要无参构造器都需要有一个无参构造器，因此在运用反射时
        //我们是通过newInstance()方法获得的构造器
        Class<reflectionClass> clazz2 = (Class<reflectionClass>) java.lang.Class.forName(path);
        reflectionClass reflection = clazz2.newInstance(); //其实是调用了User的无参构造方法
        System.out.println("无参构造方法："+reflection+"\n");

        Constructor<reflectionClass> c = clazz2.getDeclaredConstructor(int.class,int.class,String.class,boolean.class);
        //获取到了reflectClass类对象c之后，可以使用newInstance来动态使用该类
        reflectionClass reflection1 = c.newInstance(19,160,"王梦婷",true);
        System.out.println(reflection1.name+" age : "+reflection1.getAge()+"\n");

        //通过反射API调用普通方法
        reflectionClass reflection2 = clazz2.newInstance();
        Method method = clazz2.getDeclaredMethod("haveParameterMethod",int.class,String.class);
        System.out.println("调用有参方法haveParameterMethod()");
        //前面第一个参数是获取类对象reflection2,我们使用getDeclaredMethod()方法获得的有参普通方法对象method调用invoke()方法来启动该方法
        method.invoke(reflection2,19,"王梦婷");

    }
}

//我们用来实例使用反射机制创造的反射类
class reflectionClass{
    private int age;
    private int height;
    public String name;
    protected boolean sex;

    //有参构造器
    public reflectionClass(int age, int height, String name, boolean sex) {
        this.age = age;
        this.height = height;
        this.name = name;
        this.sex = sex;
    }

    //无参构造器
    public reflectionClass(){

    }

    //私有属性的get()和set()方法
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //有参数的普通方法
    public void haveParameterMethod(int age,String name){
        System.out.println("age: "+age+"\tname: "+name);
    }

    //无参的普通方法
    public void noHaveParameterMethod(){
        System.out.println("age: "+this.age+"\tname: "+this.name);
    }
}