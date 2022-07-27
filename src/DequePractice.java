import java.util.ArrayList;

class MyDeque1{
    ArrayList list;

    MyDeque1(){
        this.list = new ArrayList();
    }

    public boolean isEmpty(){
        return this.list.size() == 0;
    }

    public void addFirst(int data){
        this.list.add(0, data);
    }

    public void addLast(int data){
        this.list.add(data);
    }

    public Integer removeFirst(){
        if (this.isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }

        int data = (int) this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Integer removeLast(){
        if (this.isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }
        int data = (int)this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        return data;
    }

    public void printDeque(){
        System.out.println(this.list);
    }
}


public class DequePractice {
    public static void main(String[] args){
        MyDeque1 myDeque = new MyDeque1();
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
        myDeque.printDeque();
    }
}
