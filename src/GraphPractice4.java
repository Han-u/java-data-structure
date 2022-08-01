import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphList2 extends MyGraphList{
    public MyGraphList2(int size) {
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

            GNode cur = this.adjList[curId];
            while(cur != null){
                if(visited[cur.id] == false){
                    stack.push(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
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

            GNode cur = this.adjList[curId];
            while(cur != null){
                if(visited[cur.id] == false){
                    queue.offer(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
    }
}

public class GraphPractice4 {
    public static void main(String[] args){

    }
}
