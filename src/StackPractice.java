import java.util.ArrayList;

class MyStack1{
    ArrayList list;

    MyStack1(){
        this.list = new ArrayList();
    }

    public boolean isEmpty(){
        if(this.list.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public void push(int data){
        this.list.add(data);
    }

    public Integer pop(){
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        int data = (int) this.list.get(this.list.size() - 1); // 마지막원소
        this.list.remove(this.list.size() - 1);
        return data;
    }

    public Integer peek(){
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        int data = (int) this.list.get(this.list.size() - 1); // 마지막원소
        return data;
    }

    public void printStack(){
        System.out.println(this.list);
    }
}

public class StackPractice {
    public static void main(String[] args){
        MyStack1 myStack = new MyStack1();
        myStack.isEmpty();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.printStack();

        System.out.println(myStack.peek());
        myStack.printStack();

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.printStack();

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.printStack();
    }
}
