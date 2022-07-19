import java.util.Stack;

public class Stack1 {
    public static void main(String[] args){
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack.peek()); // 가장 마지막 원소를 반환하지만 스택에서 제거하지는 않는다
        System.out.println(stack.contains(1));
        System.out.println(stack.size());
        System.out.println(stack.empty());
        stack.clear(); // 모두 삭제

        stack.pop(); // EmptyStackException
    }
}
