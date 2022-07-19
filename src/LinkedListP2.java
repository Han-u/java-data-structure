// 추가 자료구조 없이 연결리스트만으로 Palindrome 여부 확인

public class LinkedListP2 {
    public static boolean checkPalindrome(LinkedList list){
        Node cur = list.head;
        Node left = list.head;
        Node right = null;

        int cnt = 0; // 연결리스트 안에 원소가 몇 개인지 셀 때
        while(cur != null){
            cnt++;
            right = cur; // 마지막
            cur = cur.next;
        }

        Node preRight = right;
        for (int i = 0; i < cnt / 2; i++) {
            if (left.data != right.data){
                return false;
            }

            left = left.next;
            right = left;
            while(right.next != preRight){
                right = right.next;
            }
        }
        return true;
    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(5);
        linkedList.addData(3);
        linkedList.addData(1);
        System.out.println(checkPalindrome(linkedList));

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(3);
        linkedList2.addData(5);
        linkedList2.addData(5);
        linkedList2.addData(3);
        System.out.println(checkPalindrome(linkedList2));

        LinkedList linkedList3 = new LinkedList();
        linkedList3.addData(1);
        linkedList3.addData(3);
        linkedList3.addData(5);
        linkedList3.addData(1);
        System.out.println(checkPalindrome(linkedList3));
    }
}
