package test;

public class StackArray {
    private static final int N = 10;
    private int top, sarray[];

    // constructors
    public StackArray() {
        this(N);
    }

    public StackArray(int n) {
        top = 0;
        sarray = new int[n];
    }

    // value returning methods
    public boolean empty() {
        return top <= 0;
    }

    public boolean full() {
        return top >= sarray.length;
    }

    public int pop() {
        if(empty())
            throw new RuntimeException("Stack is empty");

        top--;
        return sarray[top];
    }

    // void method
    public void push(int item) {
        if(full())
            throw new RuntimeException("Stack is full");
        sarray[top]=item;
        top++;
    }

    //遍历栈
    public void display(){
        if (empty()){
            throw new RuntimeException("栈为空");
        }else{
            for (int i = top-1; i >= 0; i--){
                System.out.print(sarray[i]+"\t");
            }
            System.out.println("\n元素遍历完毕");
        }
    }

    //返回栈顶元素，但不出栈
    public int peek(){
        if (empty()){
            throw new RuntimeException("栈为空");
        }
        return sarray[top-1];
    }

}