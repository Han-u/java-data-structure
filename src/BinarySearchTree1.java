import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

class BSTNode{
    int key;
    BSTNode left;
    BSTNode right;

    public BSTNode(int key, BSTNode left, BSTNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BST{
    BSTNode head;

    public BST(int key) {
        this.head = new BSTNode(key, null, null);
    }
    public void addNode(int key){
        if(this.head == null){
            this.head = new BSTNode(key, null,null);
        }else{
            BSTNode cur = this.head;

            while(true){
                BSTNode pre = cur;

                if(key < cur.key){ //키값이 작으면
                    cur = cur.left; //좌측으로 이동

                    if(cur==null){ //자식이 없으면
                        pre.left=new BSTNode(key,null,null);
                        break;
                    }
                }else{
                    cur = cur.right;
                    if(cur==null){
                        pre.right = new BSTNode(key, null, null);
                        break;
                    }
                }
            }
        }
    }
    public void removeNode(int key){
        BSTNode parent = null; // 부모노드
        BSTNode successor = null; // 왼쪽에서 큰노드 혹은 오른쪽에서 자른노드
        BSTNode predecessor = null;  //
        BSTNode child = null;

        BSTNode cur = this.head;
        while(cur!=null) {
            if(key == cur.key){
                break;
            }

            parent = cur;
            if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }

        if(cur == null){//삭제노드 없음
            System.out.println("key에 해당하는 노드가 없습니다");
            return;
        }

        if(cur.left == null && cur.right == null){ // Leaf 노드인 경우
            if(parent==null){
                this.head =null;
            }else{
                if(parent.left == cur){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }
        }else if(cur.left!=null&&cur.right == null || cur.left==null&cur.right!=null) { // 자식 노드가 하나
            if (cur.left != null) {
                child = cur.left;
            } else {
                child = cur.right;
            }

            if(parent == null){
                this.head = child;
            }else{
                if(parent.left== cur){
                    parent.left= child;
                }else{
                    parent.right = child;
                }
            }
        }else{//자식 노드가 둘
            predecessor = cur;
            successor = cur.left;

            while(successor.right != null){
                predecessor = successor;
                successor = successor.right;
            }

            predecessor.right = successor.left;
            successor.left = cur.left;
            successor.right = cur.right;

            if(parent == null){
                this.head = successor;
            }else{
                if(parent.left == cur){
                    parent.left = successor;
                }else{
                    parent.right = successor;
                }
            }
        }
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


public class BinarySearchTree1 {
    /*
        이진탐색트리
        - 왼쪽 자식노드는 부모노드보다 작음
        - 오른쪽 자식 노드는 부모노드보다 큼
        - 중복키 허용 않음
        - 이진트리에비해 탐색 빠름(균형유지 필요)
        - 균형: O(logN)
        - 불균형: O(N)

        탐색
        1. 루트노드부터 시작
        2. 작으면 왼쪽 크면 오른쪽으로 이동
        3. 없으면 null반환
        - 최대 트리 높이만큼 탐색 이뤄짐

        삽입
        1. Root부터 시작(중복시 추가않고 종료)
        2. 작으면 왼쪽 크면 오른쪽
        3. leaf 노드에 도달하면 작으면 왼쪽 크면 오른쪽에 삽입

        삭제-leaf
        1. 삭제
        2. 부모노드 링크 null로 변경

        삭제-자식이 하나 있는경우
        1. 자식노드를 부모노드에 연결
        2. 대상노드 삭제

        삭제-자식둘
        1-1. 왼쪽서브트리에서 가장큰노드 선택
        1-2. 오른쪽서브트리에서 가장 작은 노드 선택
        2. 1에서 하나를 선택해서 현재 자리로 올림
     */
    public static void main(String[] args){
        BST bst = new BST(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(1);
        bst.addNode(15);
        bst.addNode(25);
        bst.addNode(13);
        bst.addNode(35);
        bst.addNode(27);
        bst.addNode(40);
        bst.levelOrder(bst.head);

        bst.removeNode(40);
        bst.levelOrder(bst.head);
        bst.removeNode(25);
        bst.levelOrder(bst.head);
        bst.removeNode(20);
        bst.levelOrder(bst.head);
    }
}
