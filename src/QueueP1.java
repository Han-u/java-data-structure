// 1~N까지의 카드 N장이 있다.
//1이 제일 위 N이 제일 아래일때 다음 동작을 반복하여 가장 마지막에 남는 카드 출력한다
//1. 가장 위 카드는 버린다
//2. 그 다음 위의 카드는 쌓여있는 카드의 가장 아래에 다시 넣는다.

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class QueueP1 {
    public static int findLastCard(int N){
        Queue queue = new LinkedList();

        IntStream.range(1, N + 1).forEach(x -> queue.add(x));
        System.out.println(queue);

        while(queue.size() > 1){
            queue.remove();
            int data = (int) queue.remove();
            queue.add(data);
            System.out.println(queue);
        }
        return (int)queue.remove();
    }

    public static void main(String[] args){
        System.out.println(findLastCard(4)); //4
        System.out.println(findLastCard(7));//6
        System.out.println(findLastCard(9));//2
    }
}
