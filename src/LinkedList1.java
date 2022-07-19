class Node{
    int data;
    Node next;
    Node(){}

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList{
    Node head;

    LinkedList(){}
    LinkedList(Node head) {
        this.head = head;
    }


    // 연결 리스트 비어있는지 확인
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }


    // 연결 리스트의 맨 뒤에 데이터 추가
    public void addData(int data){
        if(this.head == null){
            this.head = new Node(data, null);
        }else{
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }


    // 연결 리스트 맨 뒤의 데이터 삭제
    public void removeData(){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node cur = this.head;
        Node prev = cur;

        while(cur.next != null){
            prev = cur;
            cur = cur.next;
        }

        if(cur == this.head){
            this.head = null;
        }else{
            prev.next = null;
        }
    }


    // 연결 리스트에서 데이터 찾기
    public void findData(int data){
        if (this.isEmpty()){
            System.out.println("List is Empty");
            return;
        }

        Node cur = this.head;
        while (cur != null){
            if(cur.data == data){
                System.out.println("Data exist");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data not found");
    }


    // 연결 리스트의 모든 데이터 출력
    public void showData(){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }


}

public class LinkedList1 {
    public static void main(String[] args){
        /*
        연결 리스트
        - 데이터 링크로 연결해서 관리
        - 자료 순서 정해져있지만 메모리상 연속성 X

        장점
        - 공간 미리 할당 X
        - 길이 가변적이라 추가/삭제 용이

        단점
        - 연결 구조위한 별도 데이터 공간 필요
        - 연결 정보 찾는 시간 필요(접근속도 배열보다 느림)
        - 데이터 추가, 삭제시 앞뒤 데이터 연결 재구성 필요
         */

        LinkedList myList = new LinkedList(new Node(1, null));
        myList.showData();

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData(); // 1 2 3 4 5

        myList.findData(3); // Data exist!
        myList.findData(100); // Data not found!

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData(); // 1 2

        myList.removeData();
        myList.removeData();
        myList.removeData(); // List is empty



    }
}
