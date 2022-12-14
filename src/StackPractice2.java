class MyStack2{
    int[] arr;
    int top = -1;

    MyStack2(int size){
        arr = new int[size];
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == this.arr.length - 1;
    }

    public void push(int data){
        if(this.isFull()){
            System.out.println("Stack is Full");
            return;
        }
        this.top += 1;
        this.arr[this.top] = data;
    }

    public Integer pop(){
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        int data = this.arr[this.top];
        this.top -= 1;
        return data;
    }

    public Integer peek(){
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        return this.arr[this.top];
    }

    public void printStack(){
        for (int i = 0; i < this.top + 1; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}

public class StackPractice2 {
    public static void main(String[] args){
        MyStack2 myStack = new MyStack2(5);
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
