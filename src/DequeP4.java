class MyDeque4 extends MyDeque2{

    MyDeque4(int size) {
        super(size);
    }

    public void increaseSize(){
        int[] arrTmp = this.arr.clone();
        this.arr = new int[this.arr.length * 2];

        int start = (this.front + 1) % arrTmp.length;
        int end = (this.rear + 1) % arrTmp.length;

        int idx = 1;
        for (int i = start; i != end ; i = (i + 1)%arrTmp.length) {
            this.arr[idx++] = arrTmp[i];
        }

        this.front = 0;
        this.rear = idx - 1;
    }

    public void addFirst(int data){
        if(this.isFull()){
            increaseSize();
        }

        this.arr[front] = data;
        this.front = (this.front -1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data){
        if (this.isFull()){
            increaseSize();
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear]= data;
    }
}

public class DequeP4 {
    public static void main(String[] args){
        MyDeque4 myDeque = new MyDeque4(5);

        myDeque.addLast(1);
        myDeque.addLast(2);
        myDeque.addLast(3);
        myDeque.addLast(4);
        myDeque.addLast(5);
        myDeque.printDeque();

        myDeque.addLast(6);
        myDeque.addLast(7);
        myDeque.addLast(8);
        myDeque.addLast(9);
        myDeque.addLast(10);
        myDeque.printDeque();

        myDeque.removeLast();
        myDeque.removeLast();
        myDeque.addFirst(100);
        myDeque.addFirst(200);
        myDeque.printDeque();

        myDeque.addFirst(300);
        myDeque.addFirst(400);
        myDeque.addFirst(500);
        myDeque.printDeque();
    }
}
