package test;

public class QueueArrayTest {
    public static void main(String[] args) {

        QueueArray queue;
        queue=new QueueArray();

        queue.enqueue(10);
        queue.enqueue(60);
        queue.enqueue(30);
        queue.enqueue(20);

        while(!queue.empty())
            System.out.println(queue.dequeue());

        System.out.println("队列是否为空："+queue.empty());
        //使用enqueue()方法添加数据
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        //使用display()方法遍历队列
        queue.display();
    }

}
