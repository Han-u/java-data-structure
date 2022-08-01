import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphMatrix2 extends MyGraphMatrix{
    public MyGraphMatrix2(int size) {
        super(size);
    }

    public void dfs(int id){
        boolean[] visited = new boolean[this.elemCnt];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(id);
        visited[id] = true;
        
        while(!stack.isEmpty()){
            int curId = stack.pop();
            System.out.print(this.vertices[curId] + " ");

            for (int i = this.elemCnt - 1; i >= 0 ; i--) {
                if(this.adMat[curId][i] == 1 && visited[i] == false){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void bfs(int id){
        boolean[] visited = new boolean[this.elemCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(id);
        visited[id] = true;

        while(!queue.isEmpty()){
            int curId = queue.poll();
            System.out.print(this.vertices[curId] + " ");

            for (int i = this.elemCnt - 1; i >= 0 ; i--) {
                if(this.adMat[curId][i] == 1 && visited[i] == false){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}

public class GraphPractice3 {
    public static void main(String[] args){
        MyGraphMatrix2 graph = new MyGraphMatrix2(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);


    }
}
