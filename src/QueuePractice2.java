class MyQueue2{
    int[] arr;
    int front = 0;
    int rear = 0;

    MyQueue2(int size){
        this.arr = new int[size];
    }

    public boolean isEmpty(){
        return this.rear == this.front;
    }

    public boolean isFull(){
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void enqueue(int data){
        if(this.isFull()){
            System.out.println("Queue is full");
            return ;
        }
        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer dequeue(){
        if(this.isFull()){
            System.out.println("Queue is full");
            return null;
        }

        front = (this.front + 1) % this.arr.length;
        return this.arr[front];
    }

    public void printQueue(){
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();

    }
}

public class QueuePractice2 {
    public static void main(String[] args){
        MyQueue2 myQueue = new MyQueue2(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);

        myQueue.printQueue();

        myQueue.printQueue();

        System.out.println(myQueue.dequeue());
        myQueue.printQueue();

        System.out.println(myQueue.dequeue());
        myQueue.printQueue();

        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        myQueue.printQueue();
    }
}
