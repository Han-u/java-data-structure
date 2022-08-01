import java.util.LinkedList;
import java.util.Queue;

class RBNode{
    int key;
    int color;
    RBNode left;
    RBNode right;
    RBNode parent;

    public RBNode(int key, int color, RBNode left, RBNode right, RBNode parent) {
        this.key = key;
        this.color = color;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class RedBlackTree{
    final int BLACK = 0;
    final int RED = 1;

    RBNode head;

    public void insert(int key){
        RBNode checkNode = null;
        if(this.head == null){
            this.head = new RBNode(key, BLACK, null, null, null);
        }else{
            RBNode cur = this.head;

            while(true){
                RBNode pre = cur;

                if(key < cur.key){
                    cur = cur.left;
                    if(cur == null){
                        pre.left = new RBNode(key, RED, null, null, pre);
                        checkNode = pre.left;
                        break;
                    }
                }else{
                    cur = cur.right;
                    if(cur == null){
                        pre.right = new RBNode(key, RED, null, null, pre);
                        checkNode = pre.right;
                        break;
                    }
                }
            }
            rbBalance(checkNode);
        }
    }

    public void rbBalance(RBNode node){
        while(node.parent != null && node.parent.color == RED){
            RBNode sibling = null;
            if(node.parent == node.parent.parent.left){
                sibling = node.parent.parent.right;
            }else{
                sibling = node.parent.parent.left;
            }

            if(sibling != null && sibling.color == RED){
                node.parent.color = BLACK;
                sibling.color = BLACK;
                node.parent.parent.color = RED;

                if(node.parent.parent == this.head){
                    node.parent.parent.color = BLACK;
                    break;
                }else{
                    node = node.parent.parent;
                    continue;
                }
            }else{
                if(node.parent == node.parent.parent.left){
                    if(node == node.parent.right){
                        node = node.parent;
                        leftRotate(node);
                    }

                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rightRotate(node.parent.parent);
                }else if(node.parent == node.parent.parent.right){
                    if(node == node.parent.left){
                        node = node.parent;
                        rightRotate(node);
                    }

                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    leftRotate(node.parent.parent);
                }
                break;
            }
        }
    }

    public void leftRotate(RBNode node){
        if(node.parent == null){
            RBNode rNode = this.head.right;
            this.head.right = rNode.left;
            rNode.left.parent = this.head;
            this.head.parent = rNode;
            rNode.left = this.head;
            rNode.parent = null;
            this.head = rNode;
        }else{
            if(node == node.parent.left){
                node.parent.left = node.right;
            }else{
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;

            if(node.right.left != null){
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        }
    }

    public void rightRotate(RBNode node){
        if(node.parent == null){
            RBNode lNode = this.head.left;
            this.head.left = lNode.right;
            lNode.right.parent = this.head;
            this.head.parent = lNode;
            lNode.right = this.head;
            lNode.parent = null;
            this.head = lNode;
        }else{
            if(node == node.parent.left){
                node.parent.left = node.left;
            }else{
                node.parent.right = node.left;
            }
            node.left.parent = node.parent;
            node.parent = node.left;

            if(node.left.right != null){
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        }
    }

    public void levelOrder(RBNode node){
        char[] color = {'B', 'R'};

        Queue<RBNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            RBNode cur = queue.poll();

            System.out.print("["+color[cur.color]+"]"+cur.key + " ");
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

public class BinarySearchTree5 {
    /*
    Red-Black트리
    - root, leaf는 black
    - read 자식은 black
    - 모든 leaf노드에서 root까지 black 노드 수 같음

    삽입 - 부모노드 형제노드가 red일떄
    - 빨간색으로 삽입했는데 double red
    - recoloring 진행
        - 내부모와 부모형제를 black으로 변경
        - 조부모를 red로 변경
        - 조부모가 root인지 doublered인지

     삽입 - 부모노드 형제노드 black이거나 없을때
     - restructuring 진행
        - 삽입노드, 부모노드, 조부모노드
        - 조정대상들을 오름차순 정렬
        - 가운데 노드를 부모노드로 선정하고 black으로 변경
        - 나머지 두 노드를 자식 노드로 두고 red로 변경

     삭제 - 대상이 black, 오는 노드가 red
     - 삭제하고 오는노드 black으로 변경

     삭제 - 이중흑색
        -형제 노드를 red로 변경
        - 이중흑색 노드의 검은색 1개를 부모노드로 전달
        - 부모가 root가 아닌 이중 흑색 노드가 되면 해당 case 반복 진행

     삭제 - 이중흑색, 형제노드가 red인경우
        - 형제노드를 black으로 변경
        - 부모노드를 red로 변경
        - 부모노드 기준 왼쪽으로 회전
        - 이중흑색 case에 따라 반복 진행

     */

    public static void main(String[] args){

    }
}
