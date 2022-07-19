//링크드리스트에서 중복 찾아 삭제
class LinkedList3 extends LinkedList{
    public boolean existData(int data){
        if (this.isEmpty()){
            System.out.println("List is Empty");
        }

        Node cur = this.head;
        while (cur != null){
            if(cur.data == data){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}

public class LinkedListP1 {
    public static LinkedList3 removeDup(LinkedList listBefore){
        LinkedList3 listAfter = new LinkedList3();

        Node cur = listBefore.head;
        while(cur != null){
            if (listAfter.existData(cur.data) == false){
                listAfter.addData(cur.data);
            }
            cur = cur.next;
        }
        return listAfter;
    }

    public static void main(String[] args){
        LinkedList3 linkedList = new LinkedList3();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(3);
        linkedList.addData(1);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.showData();

        linkedList = removeDup(linkedList);
        linkedList.showData();

    }
}
