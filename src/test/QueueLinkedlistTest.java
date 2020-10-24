package test;

public class QueueLinkedlistTest {
    public static void main(String[] args)
    {
        QueueLinkedlist q = new QueueLinkedlist();

        q.enqueue(10);
        q.enqueue(20);
        q.display();

        q.dequeue();
        q.display();

        q.dequeue();
        q.display();


        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();

        q.dequeue();
        q.display();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.display();

        //返回队头元素的值
        System.out.println(""+q.peekFront());

        //返回队尾元素的值
        System.out.println(""+q.peekRear());


    }
}
