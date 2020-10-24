package test;

public class QueueArray {
    private final int N = 4;
    private int front, rear, count, qarray[];

    public QueueArray() {
        front = rear = count = 0;
        qarray = new int[N];
    }

    public int dequeue() {
        int item = -1;

        if(empty())
            System.out.println("Queue is empty: " +
                    "item not dequeued");
        else {
            item = qarray[front];
            front = (front + 1) % N;
            count--;
        }

        return item;
    }

    public void enqueue(int item) {
        if(full())
            System.out.println("Queue is full: item not enqueued");
        else {
            qarray[rear] = item;
            rear = (rear + 1) % N;
            count++;
        }
    }

    public boolean empty() {
        return count <= 0;
    }

    public boolean full() {
        return count >= N;
    }

    public void display(){
        if (empty()){
            System.out.println("队列为空");
        }else{
            for (int i = front; i < count; i++){
                System.out.println(qarray[i]);
            }
        }
    }

}