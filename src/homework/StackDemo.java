package homework;

/**
 * 用数组来实现栈
 */
public class StackDemo {
    public static void main(String[] args){
        StackArray stack = new StackArray(10);

        //使用栈的push()方法添加数据
        for (int i = 0 ; i < 10 ; i++){
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println("stack.top:"+stack.top);

        //使用栈的listArray()方法，打印输出数据，但是不出栈
        stack.listArray();
        System.out.println("\n=====================================");

        //使用栈的pop()方法，将栈顶的数据依次出栈且输出
        for (int i = 0; i < 10; i++){
            System.out.print(stack.pop()+"\t");
        }

        System.out.println("\n栈是否为空："+stack.isEmpty());
    }
}

//创建StackArray类
class StackArray{

    int array[];
    int top = -1;

    //构造器
    public StackArray(int maxSize) {
        array = new int[maxSize];
    }

    //==================重写toString方法==================
    @Override
    public String toString() {
       for (int i = 0; i < array.length ; i++){
           System.out.print("array["+i+"]="+array[i]+"\t");
           if (i != 0 && (i+1) % 5 == 0)
               System.out.println();
       }
       return "";
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    //添加数据的方法push()入栈
    public void push(int value){
        array[++top] = value;
    }

    //删除栈顶的方法pop()出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException(); //抛出运行时的异常
        }else {
            return array[top--];
        }
    }

    //从栈顶开始输出数据，但是不出栈
    public void listArray(){
        int stp = top;
        while (stp != -1){
            System.out.print(array[stp--]+"\t");
        }
    }
}