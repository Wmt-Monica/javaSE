package IO;

import java.io.*;

/**
 * 对象流：
 * ObjectInputStream / ObjectOutputStream
 * 和数据流有着相似的功能，就是在数据流的基础上还可以用于存储各种对象的数据类型
 * 注意：但是不是所有的对象都可以，必须要实现Serializable接口的类才可以使用对象流
 */
public class ObjectStreamDemo1 {
    public static void main(String[] args) {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        try {
            ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(byteArray));

            //写入数据
            output.writeBoolean(true);
            output.writeInt(1314);
            output.writeObject(new String());  //String类实现了Serializable接口

            Employ e = new Employ("王梦婷",200000);
            output.writeObject(e);  //写入自己写的类型的对象（实现了Serializable接口）

            //读取完数据后，一定要记得刷新
            output.flush();

            //读取数据
            byte[] data = byteArray.toByteArray();
            ObjectInputStream input =
                    new ObjectInputStream(
                            new BufferedInputStream(
                                    new ByteArrayInputStream(data)));

            boolean a1 = input.readBoolean();
            int a2 = input.readInt();
            //还原数据
            Object a3 = input.readObject();
            Object a4 = input.readObject();

            //因为在读取对象数据的时候，不知道其他的数据类型，所以我们要加上判断(类型判断 instanceof)
            if (a3 instanceof String){
                String str = (String) a3;
                System.out.println(str);
            }
            if (a4 instanceof Employ){
                Employ employ = (Employ) a4;
                System.out.println(employ);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Employ implements Serializable{  //实现Serializable接口（可序列化）
    private String name;
    private int salary;

    public Employ(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "employ:{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
