package test;

class StackLinkedlist {

    // A linked list node
    private class Node {
        int data;
        Node next;
    }

    Node top;

    public StackLinkedlist()
    {
        this.top = null;
    }

    public void push(int x)
    {
        Node newp = new Node();

        if (newp == null) {
            System.out.print("\nHeap Overflow");
        }
        else
        {
            newp.data = x;
            newp.next = top;

            top = newp;
        }
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public int peek()
    {
        if (!isEmpty()) {
            return top.data;
        }
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }


    public int pop()
    {
        int popData;

        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        else
        {
            popData=top.data;
            top = top.next;

            return popData;
        }


    }


    public void display()
    {
        if (top == null) {
            System.out.printf("\nStack Underflow");
        }
        else {
            Node temp = top;
            while (temp != null) {

                System.out.printf("%d->", temp.data);

                // assign temp next to temp
                temp = temp.next;
            }

        }
    }

    public int peekTop(){
        int popData;

        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        else
        {
            popData=top.data;
            return popData;
        }
    }



}
