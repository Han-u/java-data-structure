class HashNode {
    int key;
    int data;
    HashNode next;

    HashNode() {
    }

    public HashNode(int key, int data, HashNode next) {
        this.key = key;
        this.data = data;
        this.next = next;
    }
}

class HashLinkedList {
    HashNode head;

    HashLinkedList() {
    }

    HashLinkedList(HashNode head) {
        this.head = head;
    }


    // 연결 리스트 비어있는지 확인
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }


    // 연결 리스트의 맨 뒤에 데이터 추가
    public void addData(int key, int data) {
        if (this.head == null) {
            this.head = new HashNode(key, data, null);
        } else {
            HashNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new HashNode(key, data, null);
        }
    }


    // 연결 리스트 맨 뒤의 데이터 삭제
    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        HashNode cur = this.head;
        HashNode prev = cur;

        while (cur.next != null) {
            if (cur.key == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }


    // 연결 리스트에서 데이터 찾기
    public Integer findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return null;
        }

        HashNode cur = this.head;
        while (cur != null) {
            if (cur.key == data) {
                System.out.println("Data exist");
                return cur.data;
            }
            cur = cur.next;
        }
        System.out.println("Data not found");
        return null;
    }


    // 연결 리스트의 모든 데이터 출력
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        HashNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }


}


class MyHashTable5 {
    HashLinkedList[] table;

    MyHashTable5(int size){
        this.table = new HashLinkedList[size];
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = new HashLinkedList(null);
        }
    }

    public int getHash(int key){
        return key % this.table.length;
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);
        this.table[idx].addData(key, data);
    }

    public int getValue(int key){
        int idx = this.getHash(key);
        int data = this.table[idx].findData(key);
        return data;
    }

    public void removeValue(int key){
        int idx = this.getHash(key);
        this.table[idx].removeData(key);
    }

    public void printHashTable(){
        for (int i = 0; i < this.table.length; i++) {
            System.out.print(i + ": ");
            this.table[i].showData();
        }
    }
}


public class HashTablePractice5 {
    public static void main(String[] args) {
        MyHashTable5 ht = new MyHashTable5(11);
        ht.setValue(1,10);
        ht.setValue(2,20);
        ht.setValue(3,30);
        ht.printHashTable();
        ht.setValue(12,11);
        ht.setValue(23,12);
        ht.setValue(14,13);

        ht.setValue(13,21);
        ht.setValue(24,22);
        ht.setValue(35,23);
        ht.printHashTable();
    }
}
