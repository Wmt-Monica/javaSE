package test;

public class StackArrayTest {
    public static void main(String[] args) {
        StackArray stack=new StackArray();
        stack.push(15);
        stack.push(34);
        stack.push(5);

		/*
		System.out.println(stackArray.pop());;
		System.out.println(stackArray.pop());;
		System.out.println(stackArray.pop());;
		*/

        while(!stack.empty())
            System.out.println(stack.pop());

        //判断栈是否为为空
        System.out.println("栈是否为空："+stack.empty());

        //使用push()方法添加数据
        for (int i = 0; i < 10; i++){
            stack.push(i);
        }

        //遍历栈
        stack.display();

        //返回栈顶元素
        System.out.println("栈顶元素："+stack.peek());
    }

}
