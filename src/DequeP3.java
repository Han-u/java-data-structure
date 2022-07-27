class MyDeque3{
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque3(int size){
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

    public void addMiddle(int data){
        if(this.isFull()){
            System.out.println("Deque is full!");
            return;
        }

        int elements = this.rear - this.front;
        if(elements < 0){
            elements = this.arr.length + elements;
        }

        int mid = (this.rear - elements / 2 + this.arr.length) % this.arr.length + 1;

        int start = (this.rear + 1) % this.arr.length;
        int end = (this.rear - elements / 2 + this.arr.length) % this.arr.length;
        for (int i = start; i != end; i = (i -1 + this.arr.length) % this.arr.length) {
            this.arr[i] = this.arr[(i - 1 + this.arr.length) % this.arr.length];
        }
        this.arr[mid] = data;
        this.rear = (this.rear + 1) % this.arr.length;

    }

}

public class DequeP3 {
    public static void main(String[] args){

    }
}
