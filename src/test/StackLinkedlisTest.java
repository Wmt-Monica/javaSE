package test;

public class StackLinkedlisTest {
    public static void main(String[] args) {

        StackLinkedlist obj = new StackLinkedlist();

        // insert Stack value
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);

        // print Stack elements
        obj.display();

        // print Top element of Stack
        System.out.printf("\nTop element is %d\n", obj.peek());

        // Delete top element of Stack
        obj.pop();
        obj.pop();

        // print Stack elements
        obj.display();

        // print Top element of Stack
        System.out.printf("\nTop element is %d\n", obj.peek());

        //返回栈顶的元素但不出栈
        System.out.println("栈顶的date值："+obj.peekTop());
    }
}
