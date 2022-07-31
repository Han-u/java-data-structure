import java.util.LinkedList;
import java.util.Queue;

class Node3{
    char data;
    Node3 left;
    Node3 right;
    Node3 parent;

    public Node3(char data, Node3 left, Node3 right, Node3 parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class BinaryTree3{
    Node3 head;
    BinaryTree3(char[] arr){
        Node3[] nodes = new Node3[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node3(arr[i], null, null, null);
        }

        for (int i = 0; i < arr.length; i++) { // 노드 연결하기
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < arr.length){
                nodes[i].left = nodes[left];
                nodes[left].parent = nodes[i];
            }

            if(right < arr.length){
                nodes[i].right = nodes[right];
                nodes[right].parent = nodes[i];
            }
        }
        this.head = nodes[0];
    }

    public Node3 searchNode(char data){
        Queue<Node3> queue = new LinkedList<>();

        queue.add(this.head);
        while(!queue.isEmpty()){
            Node3 cur = queue.poll();
            if(cur.data == data){
                return cur;
            }
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        return null;
    }

    public Integer checkSize(char data){
        Node3 node = this.searchNode(data);

        Queue<Node3> queue = new LinkedList<>();
        queue.add(node);

        int size = 0;
        while(!queue.isEmpty()){
            Node3 cur = queue.poll();
            if(cur.left != null){
                queue.offer(cur.left);
                size++;
            }
            if(cur.right != null){
                queue.offer(cur.right);
                size++;
            }
        }
        return size + 1;
    }
}

public class TreePractice2 {
    public static void main(String[] args){
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }
        BinaryTree3 bt = new BinaryTree3(arr);

        // Root node
        System.out.println(bt.head.data);


        // B's child node
        Node3 B = bt.searchNode('B');
        if(B.left != null){
            System.out.println(B.left.data);
        }
        if(B.right != null){
            System.out.println(B.right.data);
        }


        // F's parent node
        Node3 F = bt.searchNode('F');
        System.out.println(F.parent.data);


        // leaf node
        for (int i = 0; i < arr.length; i++) {
            Node3 cur = bt.searchNode((char)('A' + i));

            if (cur.left == null && cur.right == null){
                System.out.print(cur.data + " ");
            }
        }
        System.out.println();


        //E's parent
        Node3 E = bt.searchNode('E');
        Node3 cur = E;
        int cnt = 0;
        while(cur.parent != null){
            cur = cur.parent;
            cnt++;
        }


        //level2 Node
        for (int i = 0; i < arr.length; i++) {
            Node3 target = bt.searchNode((char)('A'+i));
            cur = target;
            cnt = 0;
            while(cur.parent != null){
                cur = cur.parent;
                cnt++;
            }

            if(cnt == 2){
                System.out.print(target.data + " ");
            }
        }
        System.out.println();


        // Height
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Node3 target = bt.searchNode((char)('A'+i));
            cur = target;
            cnt = 0;
            while(cur.parent != null){
                cur = cur.parent;
                cnt++;
            }

            if(maxCnt < cnt){
                maxCnt = cnt;
            }
        }
        System.out.println(maxCnt);



        // B's size
        int size = bt.checkSize('B');
        System.out.println("size = " + size);

    }
}
