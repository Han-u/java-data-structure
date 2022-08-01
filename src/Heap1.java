import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete(){
        if(heap.size() == 1){
            System.out.println("Heap is empty!");
            return null;
        }

        int target = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while(true){
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if(rightIdx < heap.size()){
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                targetIdx = cur * 2;
            }else{
                break;
            }

            if(heap.get(cur) < heap.get(targetIdx)){
                break;
            }else{
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }
        return target;
    }

    public void printTree(){
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Heap1 {
    /*
        힙
        - 완전 이틴트리 형태
        - 중복 값 허용
        - 반 정렬 상태
        - 최소값 or 최대값 빠르게 찾아내는데 유용

        최소힙
        - 부모노드키가 자식노드 키보다 작거나 같음

            삽입
            - 트리 가장 끝 위치에 삽입
            - 부모노드와 키 비교한 후 작을 경우 부모 자리와 교체를 반복

            삭제
            - 최상위 노드 반환 및 삭제
            - 가장 마지막 위치의 노드를 최상위 노드로 위치시킴
            - 자식 노드 중 작은 값과 비교 후 부모 노드가 더 크면 자리교체를 반복

        최대힙
        - 부모노드키가 자식노드 키보다 크거나 같음
     */
    public static void main(String[] args) {

    }
}
