class BinaryTree{
    char[] arr;

    BinaryTree(char[] data){
        this.arr = data.clone();
    }

    public void preOrder(int idx){
        System.out.print(this.arr[idx] + " ");

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if(left < this.arr.length){
            this.preOrder(left);
        }

        if(right<this.arr.length){
            this.preOrder(right);
        }
    }

    public void inOrder(int idx){
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if(left < this.arr.length){
            this.inOrder(left);
        }

        System.out.print(this.arr[idx] + " ");

        if(right < this.arr.length){
            this.inOrder(right);
        }
    }

    public void postOrder(int idx){
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if(left < this.arr.length){
            this.postOrder(left);
        }

        if(right < this.arr.length){
            this.postOrder(right);
        }

        System.out.print(this.arr[idx] + " ");
    }

    public void levelOrder(){
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
    }
}

public class Tree {
    /*
        - 노드와 링크로 구성된 자료구조
        - Cycle 없음
        - 계층적 구조 나타낼 때 사용
     */

    /*
        노드(Node): 트리의 구조 자료 값을 담고 있는 단위
        에지(Edge): 노드 간의 연결선(link, branch)
        루트노드(Root): 부모가 없는 노드, 가장 위의 노드
        잎새노드(Leaf): 자식이 없는 노드
        내부노드(Internal): 잎새 노드를 제외한 모든 노드
        부모(Parent): 연결된 두 노드 중 상위의 노드
        자식(Child): 연결된 두 노드 중 하위의 노드
        형제(Sibling): 같은 부모를 가지는 노드
        깊이(Depth): 루트에서 어떤 노드까지의 간선 수
        레벨(Level): 트리의 특정 깊이를 가지는 노드 집합
        높이(Height): 트리에서 가장 큰 레벨 값
        크기(size): 자신을 포함한 자식 노드의 개수
        차수(Degree): 각 노드가 지닌 가지의 수
        트리의 차수: 트리의 최대 차수
     */

    /*
        - 다른 노드로 이동하는 경로는 유일
        - 에지 수 Node수-1
        - Cycle 존재하지 않음
        - 모든 노드가 서로 연결
        - Edgd 끊으면 2개의 SubTree로 분리
     */

    /*
        - 포화이진트리(모든 레벨에서 노드가 꽉 채워짐)
        - 완전이진트리(마지막 레벨을 제외하고 노드들이 모두 채워진 트리)
        - 정이진트리(모든 노드가 0개 또는 2개 자식노드 갖는 트리)
        - 편향트리(한쪽으로 기울어진 트리)
        - 균형이진트리(모든 노드의 좌우 서브트리 높이가 1이상 차이나지 않는 트리)
     */

    /*
        - 순회: 모든 노드를 중복하지않고 방문
        - 전위순회 : 현재노드 -> 왼쪽노드 -> 오른쪽노드
        - 중위순회 : 왼쪽노드 -> 현재노드 -> 오른쪽노드
        - 후위순회 : 왼쪽노드 -> 오른쪽노드 -> 현재노드
        - 레벨순회 : 위쪽 레벨부트 왼쪽노드 -> 오른쪽노드
     */
    public static void main(String[] args){
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder();
        System.out.println();
    }
}
