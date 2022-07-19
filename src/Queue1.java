import java.util.Queue;
import java.util.LinkedList;

public class Queue1 {
    public static void main(String[] args){
        Queue queue = new LinkedList();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue);
        System.out.println(queue.poll()); // 가장 앞 원소 꺼내기

        System.out.println(queue.peek()); // 가장 앞 원소 출력만하기

        System.out.println(queue.contains(3));
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.clear();
        System.out.println(queue.poll()); // null 반환
    }
}
