import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class AVLNode{
    int key;
    int height;
    AVLNode left;
    AVLNode right;

    public AVLNode(int key, AVLNode left, AVLNode right) {
        this.key = key;
        this.height = 0;
        this.left = left;
        this.right = right;
    }
}

class AVLTree{
    AVLNode head;
    public int height(AVLNode node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    public AVLNode rightRotate(AVLNode node){
        AVLNode lNode = node.left; // 중간부
        node.left = lNode.right; // 기존에 중간부에 오른자식이 있으면 맨위의 왼쪽자식으로 이동
        lNode.right = node; // 밸런스 맞춤

        node.height = Math.max(height(node.left), height(node.right))+1;
        lNode.height = Math.max(height(lNode.left), height(lNode.right)) + 1;

        return lNode;
    }

    public AVLNode leftRotate(AVLNode node){
        AVLNode rNode = node.right;
        node.right = rNode.left;
        rNode.left = node;

        node.height = Math.max(height(node.left), height(node.right))+1;
        rNode.height = Math.max(height(rNode.left), height(rNode.right)) + 1;

        return rNode;
    }

    public AVLNode lrRotate(AVLNode node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    public AVLNode rlRotate(AVLNode node){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public int getBalance(AVLNode node){
        if(node == null){
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    public void insert(int key){
        this.head = insert(this.head, key);

    }

    public AVLNode insert(AVLNode node, int key){
        if(node == null){
            return new AVLNode(key, null,null);
        }

        if(key < node.key){
            node.left = insert(node.left ,key);
        }else{
            node.right = insert(node.right, key);
        }

        node.height = Math.max(height(node.left), height(node.right))+ 1;

        int balance = getBalance(node);

        if(balance > 1 && key < node.left.key){
            return rightRotate(node);
        }

        if(balance < -1 && key > node.right.key){
            return leftRotate(node);
        }

        if(balance > 1 && key > node.left.key){
            return lrRotate(node);
        }

        if(balance < -1 && key < node.right.key){
            return rlRotate(node);
        }
        return node;
    }

    public void levelOrder(AVLNode node){
        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            AVLNode cur = queue.poll();

            System.out.print(cur.key + " ");
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }

}
public class BinarySearchTree3 {
    /*
        균형이진트리
        -모든 노드의 좌우 서브트리 높이가 1이상 차이나지 않는 트리
        - 삽입 삭제시 균형을 유지하도록 하는 트리
        - ex) AVL 트리, Red Black 트리

        AVL
        - 삽입삭제시 균형체크
        - Balance Factor: 왼쪽 서브트리 톺이 - 오른쪽 서브트리 높이
        - BF를 -1 0 1만 가지게 함

            리밸런싱
            - 균형이 깨짐 : BF가 +이면 왼쪽 서브트리에 이상 -이면 오른쪽 서브트리에 이상
            - 회전 연산: LL RR LR RL

            1. LL: 회전 1회 오른쪽 방향으로 회전
            2. RR: 회전 1회 왼쪽 방향으로 회전
            3. LR: 회전 2회 RR회전후 LL회전
            4. RL: 회전 2회 LL회전후 RR회전
     */
    public static void main(String[] args){
        AVLTree avl = new AVLTree();

        avl.insert(50);
        avl.insert(20);
        avl.insert(10);
        avl.levelOrder(avl.head);

        avl.insert(40);
        avl.insert(50);
        avl.levelOrder(avl.head);

        avl.insert(5);
        avl.insert(7);
        avl.levelOrder(avl.head);

        avl.insert(60);
        avl.insert(55);
        avl.levelOrder(avl.head);
    }
}
