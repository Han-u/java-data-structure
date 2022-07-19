// 단순 연결 리스트 구현

class LinkedList2 extends LinkedList{
    LinkedList2(Node node){
        this.head = node;
    }

    // 연결 리스트에 데이터 추가
    // before_data 가 null이면 가장 뒤
    // before_data에 값이 있으면 해당 값 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData){
        if(this.head == null){
            this.head = new Node(data, null);
        }else if (beforeData == null){
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }else{
            Node cur = this.head;
            Node pre = cur;
            while (cur != null){
                if(cur.data == beforeData){
                    if(cur == this.head){
                        this.head = new Node(data, this.head);
                    }else{
                        pre.next = new Node(data, cur);
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data){
        if(this.isEmpty()){
            System.out.println("list is empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;
        while(cur != null){
            if(cur.data == data){
                if(cur == this.head){
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

}

public class LinkedListPractice {
    public static void main(String[] args){
        LinkedList2 myList = new LinkedList2(new Node(1, null));
        myList.showData();

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();
    }
}
