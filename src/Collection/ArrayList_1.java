package Collection;

import java.util.Scanner;

public class ArrayList_1<E> {  //添加泛型<E>
    //定义默认的数组对象arrayList和数组长度size
   private Object[] arrayList;
   private int size;

   //定义默认的arrayList长度
    private static final int MO_REN_SIZE = 2;

    //arrayList数组构造器
    public ArrayList_1(){
        arrayList = new Object[MO_REN_SIZE];
    }
    //arrayList数组构造器的重载方法
    static int SHU_RU_SIZE;
    public ArrayList_1(int Fang_Fa_Size){
        arrayList = new Object[Fang_Fa_Size];
        SHU_RU_SIZE = Fang_Fa_Size;
    }

    //为arrayList数组添加数据
    public void add(E e){  //未添加数据类型添加泛型
        if((size+1) > SHU_RU_SIZE){
            //每超出数组默认长度时，都会另外创建一个数组比原先的数组长度多一,因为下面添加数据时，size++,故因此要多加一[(size+1)+1]
            Object[] arrayList = new Object[size+2];

            //将原来数组中的数据赋值到新的数组当中去
            System.arraycopy(this.arrayList,0,arrayList,0,size);

            //将新添加的数据添加到新的数组当中去
            arrayList[size++] = e;

            //将新的数组地址赋值给旧的数组
            this.arrayList = arrayList;

        }else{
            arrayList[size++] = e;
        }
    }

    //打印arrayList数组，重写toString()方法
    @Override
    public String toString() {
        int i = 0;
        System.out.print("arrayList：");
        while (arrayList[i]!=null){
            if ((i)%5==0){
                System.out.println();
                System.out.println("--------------------------------------------------------------------------------");
            }
            System.out.print("array["+i+"]:"+arrayList[i++]+"\t"+"|");
        }
        System.out.println("\n--------------------------------------------------------------------------------");
        return "size："+size;
    }

    //赋值数组对象set()方法
    public void set(E e , int index){

        //索引的判断
        index = Suo_Yin(index);
        arrayList[index] = e;
    }

    //获取数据get()方法
    public E get(int index){

        //在获取数据的同时也要对索引进行判断，故因此直接创建一个方法用于索引的判断
        return (E) arrayList[Suo_Yin(index)];
    }

    //索引的判断
    public int Suo_Yin(int index){
        if (index >= 0 && index <size){
            return index;
        }else{
            //索引引用错误重新输入(1)
            System.out.println("索引超出数组范围，请确认后重写输入");
            Scanner newIndexStep = new Scanner(System.in);
            int newIndex = newIndexStep.nextInt();
            return Suo_Yin(newIndex);

            //索引不合法，不给予修改的机会，直接报运行的错误(2)
//      throw new RuntimeException("索引不合法，请重新输入");
        }
    }

    //传入ArrayList对象，移除元素的操作
    public void remove(E e){
        for (int i = 0 ; i < size ; i++){
            if (arrayList.equals(get(i))){
                remove(i);
            }
        }
    }

    //ArrayList对象索引删除元素的操作
    public void remove(int index){

        //索引的判断
        index = Suo_Yin(index);

        //删除ArrayList数组索引所对应的元素
        Object[] arrayList = new Object[size-1];
        System.arraycopy(this.arrayList,0,arrayList,0,index);
        System.arraycopy(this.arrayList,index+1,arrayList,index,(size-1-index));
        this.arrayList = arrayList;
        arrayList[size-2] = null;
        size--;
    }

    public static void main(String[] args) {
        //添加了数组的扩容，即使超出了静态初始化数组任然可以成功添加数据
        ArrayList_1 arrayList = new ArrayList_1(3);
        arrayList.add("wmt1");
        arrayList.add("sf2");
        arrayList.add("WMT3");
        arrayList.add("SF4");
        arrayList.add("wmt5");
        arrayList.add("sf6");
        arrayList.add("WMT7");
        arrayList.add("SF8");
        arrayList.add("wmt9");
        arrayList.add("sf10");
        arrayList.add("WMT11");
        arrayList.add("SF12");
        System.out.println(arrayList);
        System.out.println(arrayList.get(10));
        arrayList.set("mengmengmeng",12);
        System.out.println(arrayList);
        arrayList.remove(2);
        System.out.println("===================================");
        System.out.println(arrayList);
        arrayList.remove(5);
        System.out.println("===================================");
        System.out.println(arrayList);
        arrayList.remove(9);
        System.out.println("===================================");
        System.out.println(arrayList);
    }
}
