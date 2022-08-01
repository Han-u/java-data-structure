class AVLTree2 extends AVLTree{
    public void delete(int key){
        this.head = delete(this.head, key);
    }
    public AVLNode delete(AVLNode node, int key){
        if(node == null){
            return null;
        }
        if(key < node.key){
            node.left = delete(node.left, key);
        }else if(key > node.key){
            node.right = delete(node.right, key);
        }else{
            if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }else{
                AVLNode predecessor = node;
                AVLNode successor = node.left;

                while(successor.right != null){
                    predecessor = successor;
                    successor = successor.right;
                }

                predecessor.right = successor.left;
                node.key = successor.key;
            }
        }
        node.height = Math.max(height(node.left), height(node.right))+1;
        int balance = getBalance(node);

        if(balance > 1 && getBalance(node.left)>0){
            return rightRotate(node);
        }

        if(balance < -1 && getBalance(node.right) < 0){
            return leftRotate(node);
        }

        if(balance > 1 && getBalance(node.left) < 0){
            return lrRotate(node);
        }

        if(balance < -1 && getBalance(node.right) > 0){
            return rlRotate(node);
        }
        return node;
    }
}
public class BinarySearchTree4 {
    public static void main(String[] args){
        AVLTree2 avl = new AVLTree2();

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
