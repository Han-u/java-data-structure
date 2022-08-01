import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PriorityQueue1 {
    /*
        우선순위 큐
        - 우선순위가 높은 데이터가 먼저 나옴
        - 모든 데이터에 우선순위가 있음
        - Dequeue시 우선순위가 높은 순으로 나감
        - 우선순위가 같은 경우에는 FIFO
        - 최소 힙 및 최대 힙의 삽입 삭제 같음
     */
    public static void enqueue(LinkedList<Integer> list, int data){
        int idx = list.size();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > data){
                idx = i;
                break;
            }
        }
        list.add(idx, data);
    }

    public static Integer dequeue(LinkedList<Integer> list){
        if (list.size() == 0){
            return null;
        }

        int data = list.get(0);
        list.remove(0);
        return data;
    }

    public static void main(String[] args){
        LinkedList<Integer> pqList = new LinkedList<>();
        enqueue(pqList, 5);
        enqueue(pqList, 7);
        enqueue(pqList, 3);
        enqueue(pqList, 1);
        enqueue(pqList, 9);
        System.out.println(pqList);

        System.out.println(dequeue(pqList));
        System.out.println(dequeue(pqList));
        System.out.println(pqList);

        // 자바 기본 PriorityQueue 사용
        // 우선순위: 낮은 숫자 순
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(7);
        pq.add(3);
        pq.add(1);
        pq.add(9);
        System.out.println(Arrays.toString(pq.toArray()));

        // 우선순위: 높은 숫자 순
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.add(5);
        pq2.add(7);
        pq2.add(3);
        pq2.add(1);
        pq2.add(9);
        System.out.println(Arrays.toString(pq2.toArray()));
    }
}
