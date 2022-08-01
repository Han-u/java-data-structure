import java.util.LinkedList;
import java.util.Queue;

class BST2{
    BSTNode head;

    BST2(int key){
        this.head = new BSTNode(key, null, null);
    }

    public BSTNode addNodeRecursive(BSTNode cur, int key){
        if(cur == null){
            return new BSTNode(key, null, null);
        }

        if(key < cur.key){
            cur.left = addNodeRecursive(cur.left, key);
        }else{
            cur.right = addNodeRecursive(cur.right, key);
        }

        return cur;
    }

    public BSTNode removeNodeRecursive(BSTNode cur, int key){

        if(cur==null){
            return null;
        }

        if(key < cur.key){
            cur.left = removeNodeRecursive(cur.left, key);
        }else if(key > cur.key){
            cur.right = removeNodeRecursive(cur.right,key);
        }else{
            if(cur.left == null){
                return cur.right;
            }else if(cur.right == null){
                return cur.left;
            }else{
                BSTNode predecessor = cur;
                BSTNode successor = cur;

                while(successor.right != null){
                    predecessor = successor;
                    successor = successor.right;
                }
                predecessor.right = successor.left;
                cur.key = successor.key;
            }
        }
        return cur;
    }

    public void levelOrder(BSTNode node){
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            BSTNode cur = queue.poll();

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

public class BinarySearchTree2 {
    public static void main(String[] args){
        BST2 bst = new BST2(20);
        bst.head = bst.addNodeRecursive(bst.head,10);
        bst.head = bst.addNodeRecursive(bst.head,30);
        bst.head = bst.addNodeRecursive(bst.head,1);
        bst.head = bst.addNodeRecursive(bst.head,15);
        bst.head = bst.addNodeRecursive(bst.head,25);
        bst.head = bst.addNodeRecursive(bst.head,13);
        bst.head = bst.addNodeRecursive(bst.head,35);
        bst.head = bst.addNodeRecursive(bst.head,27);
        bst.head = bst.addNodeRecursive(bst.head,40);
        bst.levelOrder(bst.head);

        bst.head = bst.removeNodeRecursive(bst.head,40);
        bst.levelOrder(bst.head);
        bst.head = bst.removeNodeRecursive(bst.head,25);
        bst.levelOrder(bst.head);
        bst.head = bst.removeNodeRecursive(bst.head,20);
        bst.levelOrder(bst.head);
    }
}
