class GNode{
    int id;
    GNode next;

    public GNode(int id, GNode next) {
        this.id = id;
        this.next = next;
    }
}

class MyGraphList{
    char[] vertices;
    GNode[] adjList;
    int elemCnt;

    public MyGraphList(){}
    public MyGraphList(int size){
        this.vertices = new char[size];
        this.adjList = new GNode[size];
        this.elemCnt = 0;
    }

    public boolean isFull(){
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data){
        if(isFull()){
            System.out.println("Graph is full");
            return;
        }
        this.vertices[elemCnt++] = data;
    }

    public void addEdge(int x, int y){
        this.adjList[x] = new GNode(y, this.adjList[x]);
        this.adjList[y] = new GNode(x, this.adjList[y]);
    }

    public void addDirectedEdge(int x, int y){
        this.adjList[x] = new GNode(y, this.adjList[x]);
    }

    public void printAdjacentList(){
        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + ": ");

            GNode cur = this.adjList[i];
            while(cur!=null){
                System.out.print(this.vertices[cur.id] + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}

public class GraphPractice2 {
    public static void main(String[] args){
        MyGraphList graph = new MyGraphList(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentList();
    }
}
