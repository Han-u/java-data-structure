import java.util.ArrayDeque;
import java.util.Deque;

public class Deque1 {
    public static void main(String[] args){
        /*
        Deque
        - 양쪽에서 삽입과 삭제가 모두 가능한 자료구조
        - Stack + Queue
        add(offer)
        remove(poll)

        Scroll: 한쪽의 입력을 제한한 데크
        Shelf: 한 쪽의 출력을 제한한 데크
         */

        Deque deque = new ArrayDeque();

        // Front 부분 입력
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);


        // Rear 부분 입력
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);


        // Front 부분 출력
        deque.removeFirst();


        // Rear 부분 출력
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();

        System.out.println(deque.pollLast()); // null
        System.out.println(deque.removeLast()); // NoSuchElementException


    }
}
