package test;

public class QueueLinkedlist {

    private class QNode {
        int data;
        QNode next;
    }

    QNode front, rear;

    public QueueLinkedlist()
    {
        this.front =null;
        this.rear = null;
    }

    // Method to add an data to the queue.
    void enqueue(int data)
    {

        // Create a new LL node
        QNode newp = new QNode();
        newp.data=data;

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = newp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = newp;
        this.rear = newp;
    }

    // Method to remove an key from queue.
    void dequeue()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
        {
            //System.out.print("\nqueue is empty");
            return;
        }

        // Store previous front and move front one node ahead
        QNode temp = this.front;
        this.front = temp.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
    }


    public void display()
    {
        if (front == null) {
            System.out.printf("\nStack Underflow");
        }
        else {
            QNode temp = front;

            System.out.println();

            while (temp != null) {

                System.out.printf("%d->", temp.data);

                // assign temp next to temp
                temp = temp.next;
            }

        }
    }

    //返回队头元素的值，但是不出栈
    public int peekFront(){
        if (this.front == null){
            throw new RuntimeException("队列为空");
        }
        return this.front.data;
    }

    //返回队尾元素的值，但是不出栈
    public int peekRear (){
        if (this.rear == null){
            throw new RuntimeException("队列为空");
        }
        return this.rear.data;
    }


}
