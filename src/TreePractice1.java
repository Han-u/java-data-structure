import java.util.Queue;
import java.util.LinkedList;

// 연결 리스트를 이용한 이진 트리 구성, 순회
class Node2{
    char data;
    Node2 left;
    Node2 right;

    public Node2(char data, Node2 left, Node2 right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree2{
    Node2 head;
    BinaryTree2(){}
    BinaryTree2(char[] arr){
        Node2[] nodes = new Node2[arr.length];
        for (int i = 0; i < arr.length; i++) { // 노드 만들기
            nodes[i] = new Node2(arr[i], null, null);
        }

        for (int i = 0; i < arr.length; i++) { // 노드 연결하기
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < arr.length){
                nodes[i].left = nodes[left];
            }

            if(right < arr.length){
                nodes[i].right = nodes[right];
            }
        }
        this.head = nodes[0];
    }

    public void preOrder(Node2 node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(Node2 node){
        if(node == null){
            return;
        }
        this.inOrder(node.left);
        System.out.print(node.data + " ");
        this.inOrder(node.right);
    }

    public void postOrder(Node2 node){
        if(node == null){
            return;
        }
        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrder(Node2 node){
        Queue<Node2> queue= new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node2 cur = queue.poll();

            System.out.print(cur.data + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
}


public class TreePractice1 {
    public static void main(String[] args){
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree2 bt = new BinaryTree2(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(bt.head);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(bt.head);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(bt.head);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(bt.head);
        System.out.println();
    }
}
