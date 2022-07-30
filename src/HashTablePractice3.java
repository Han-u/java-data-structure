class MyHashTable3 extends MyHashTable {
    // 개방주소법(제곱탐사)
    MyHashTable3(int size) {
        super(size);
    }
    public void setValue(int key, int data){
        int idx = this.getHash(key);

        if(this.elemCnt == this.table.length){
            System.out.println("HT is full");
            return;
        }else if(this.table[idx] == null){
            this.table[idx] = data;
        }else{
            int newIdx = idx;
            int cnt= 0;
            while(true){
                newIdx = (newIdx+(int)Math.pow(2,cnt)) % this.table.length;
                if(this.table[newIdx] == null){
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }
        this.elemCnt++;
    }
}

public class HashTablePractice3 {
    public static void main(String[] args){
        MyHashTable3 ht = new MyHashTable3(11);
        ht.setValue(1,10);
        ht.setValue(2,20);
        ht.setValue(4,40);
        ht.printHashTable();

        ht.setValue(1,100);
        ht.printHashTable();

        ht.setValue(1,200);
        ht.setValue(1,300);
        ht.setValue(1,400);
        ht.printHashTable();
    }
}