// 연결리스트 부분 뒤집기
// 주어진 연결 리스트에서 시작 위치부터 끝 위치 사이의 노드 뒤집기


public class LinkedListP3 {
    public static LinkedList reverseList(LinkedList list, int left, int right){
        Node cur1 = null;
        Node pre1 = null;

        cur1 = list.head;
        for (int i = 0; i < left - 1; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        } // 시작점 찾기

        Node cur2 = cur1;
        Node pre2 = pre1;
        Node after = null;
        for (int i = left; i <= right; i++) {
            after = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = after;
        }

        pre1.next = pre2;
        cur1.next = cur2;

        return list;
    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(2);
        linkedList.addData(3);
        linkedList.addData(4);
        linkedList.addData(5);
        linkedList.showData();

        linkedList = reverseList(linkedList, 2, 4);
        linkedList.showData();

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(1);
        linkedList2.addData(2);
        linkedList2.addData(3);
        linkedList2.addData(4);
        linkedList2.addData(5);
        linkedList2.addData(6);
        linkedList2.showData();

        linkedList = reverseList(linkedList2, 3, 5);
        linkedList.showData();
    }
}
