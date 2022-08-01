class MyGraphMatrix{
    char[] vertices; // 알파벳
    int[][] adMat;// 인접행렬
    int elemCnt;//정점의개수

    public MyGraphMatrix(){}
    public MyGraphMatrix(int size){
        this.vertices = new char[size];
        this.adMat = new int [size][size];
        this.elemCnt = 0;
    }

    public boolean isFull(){
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data){
        if(isFull()){
            return;
        }

        this.vertices[this.elemCnt++] = data;
    }

    public void addEdge(int x, int y){
        this.adMat[x][y] = 1;
        this.adMat[y][x] = 1;
    }

    public void addDirectedEdge(int x, int y){
        this.adMat[x][y] = 1;
    }

    public void deleteEdge(int x, int y){
        this.adMat[x][y] = 0;
        this.adMat[y][x] = 0;
    }

    public void deleteDirectedEdge(int x, int y){
        this.adMat[x][y] = 0;
    }

    public void printQAdjacentMatrix(){
        System.out.print("  ");
        for (char item: this.vertices){
            System.out.print(item + " ");
        }
        System.out.println();

        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + " ");
            for (int j = 0; j < this.elemCnt; j++) {
                System.out.print(this.adMat[i][j] + " ");
            }
            System.out.println();
        }
    }


}

public class Graph1 {
    /*
        - 정점과 간선으로 이루어진 자료구조(Cyclic)
     */

    /*
    정점(Vertex): 각 노드
    간선(Edge): 노드와 노드를 연결하는 선
    인접 정점(Adjacent vertex): 간ㅅ너 하나를 두고 바로 연결된 정점
    정점의 차수(Degree): 무방향 그래프레엇 하나의 정점에 인접한 정점의 수 / 그래프 간선의 2배
    진입차수(In degree): 방향 그래프에서 외부에서 오는 간선의 수
    진출차수(Out degree) 방향 그래프에서 외부로 나가는 간선의 수
    경로길이(Path length): 경로를 구성하는데 사용된 간선의 수
    단순경로(Simple path): 경로 중에서 반복되는 정점이 없는 경우
    사이클(Cycle): 단순 경로의 싲가 정점과 끝 정점이 동일한 경우
     */

    /*
        가중치 그래프: 간선에 값이 있는 그래프
        완전 그래프: 모든 정점이 서로 연결돼있는 그래프 n(n-1)/2개
     */

    /*
        DFS: 깊이 우선 탐색
            - 각 노드에 방문했는지 여부를 체크할 배열과 스택 이용하여 구현
        BFS: 너비 우선 탐색
            - 각 노드에 방문했는지 여부를 체크할 배열과 큐 이용하여 구현
     */

    /*
        인접행렬:
            간선 정보 확인과 업데이트 빠름(O(1))
            인접 행렬을 위한 메모리 공간 차지
            노드 개수 적고 간선 수 많을 때 유리
        인접 리스트:
            연결 리스트 이용
            메모리 사용량이 상대적으로 적고 노드 추가 삭제 빠름
            간선정보 확인이 상대적으로 오래 걸림
            노드 개수 많고 간선 수 적을 때 유리
     */
    public static void main(String[] args){
        MyGraphMatrix graph = new MyGraphMatrix(4);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printQAdjacentMatrix();

    }
}
