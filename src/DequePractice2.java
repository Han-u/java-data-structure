import java.util.Arrays;

class MyDeque2{
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque2(int size){
        this.arr = new int[size + 1];
    }

    public boolean isEmpty(){
        return this.rear == this.front;
    }

    public boolean isFull(){
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void addFirst(int data){
        if(this.isFull()){
            System.out.println("Deque is Full!");
            return;
        }

        this.arr[this.front] = data;
        this.front = (this.front - 1 + this.arr.length) % this.arr.length; // 맨 뒤로 가서 front 인덱스 유지하기
    }

    public void addLast(int data){
        if(this.isFull()){
            System.out.println("Deque is Full!");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer removeFirst(){
        if (this.isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }

        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast(){
        if (this.isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }
        int data = this.arr[this.rear];
        this.rear = (this.rear - 1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque(){
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for(int i = start; i != end; i = (i + 1) % this.arr.length){
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}

public class DequePractice2 {
    public static void main(String[] args){
        MyDeque2 myDeque = new MyDeque2(5);
        myDeque.addFirst(1);
        myDeque.addFirst(2);
        myDeque.addFirst(3);
        myDeque.printDeque();

        myDeque.addLast(10);
        myDeque.addLast(20);
        myDeque.addLast(30);
        myDeque.printDeque();

        System.out.println(myDeque.removeFirst());
        myDeque.printDeque();

        System.out.println(myDeque.removeLast());
        myDeque.printDeque();

        System.out.println(myDeque.removeLast());
        System.out.println(myDeque.removeLast());
        System.out.println(myDeque.removeLast());
        System.out.println(myDeque.removeLast());
    }
}
