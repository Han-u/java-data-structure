class NodeP3{
    int data;
    int cmd;

    boolean visited;
    NodeP3 next;
    NodeP3 prev;

    public NodeP3(int data, int cmd, boolean visited, NodeP3 next, NodeP3 prev) {
        this.data = data;
        this.cmd = cmd;
        this.visited = visited;
        this.next = next;
        this.prev = prev;
    }
}

class LinkedList8{
    NodeP3 head;
    public void add(int data, int cmd){
        if(this.head == null){
            this.head = new NodeP3(data, cmd, false, null, null);
            this.head.next = this.head;
            this.head.prev = this.head;
        }else{
            NodeP3 cur = this.head;
            while(cur.next != this.head){
                cur = cur.next;
            }
            cur.next = new NodeP3(data, cmd, false, cur.next, cur);
            this.head.prev = cur.next;
        }
    }
}

public class LinearPractice3 {
    public static void solution(int[] data){
        LinkedList8 linkedList = new LinkedList8();
        for (int i = 0; i < data.length; i++) {
            linkedList.add(i + 1, data[i]);
        }
        NodeP3 cur = linkedList.head;
        int visitedCnt = 0;
        int cmd = 0;
        while(visitedCnt != data.length){
            int cnt = 0;
            while(cnt != Math.abs(cmd)){
                if (cmd > 0){
                    cur = cur.next;
                }else{
                    cur = cur.prev;
                }

                if(cur.visited == false){
                    cnt++;
                }
            }
            System.out.println(cur.data + " ");
            cur.visited = true;
            visitedCnt++;
            cmd = cur.cmd;
        }
    }
    public static void main(String[] args){
        int[] balloon = {3,2,1,-3,-1};
        solution(balloon);

        balloon = new int[]{3,2,-1,-2};
        solution(balloon);
    }
}
