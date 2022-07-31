class BinaryTree4{
    int h;
    int[] arr;
    int res;

    public BinaryTree4(int h, int[] w){
        this.h = h;
        arr = new int[(int)Math.pow(2, h+1)];
        res = 0;

        for (int i = 2; i < (int)Math.pow(2, h + 1); i++) {
            arr[i] = w[i - 2];
        }
    }

    public int dfs(int idx, int h){
        if(this.h == h){
            res += arr[idx];
            return arr[idx];
        }
        int left = dfs(idx * 2, h + 1);
        int right = dfs(idx * 2 + 1, h + 1);
        res += arr[idx] + Math.abs(left-right);
        return arr[idx] + Math.max(left,right);
    }
}

public class TreeP2 {
    public static void solution(int h, int[] w){
        BinaryTree4 bt = new BinaryTree4(h, w);
        bt.dfs(1, 0);
        System.out.println(bt.res);
    }
    public static void main(String[] args){
        int h = 2;
        int[] w = {2,2,2,1,1,3};
        solution(h, w);
        System.out.println();

        h = 3;
        w = new int[]{1,2,1,3,2,4,1,1,1,1,1,1,1,1};
        solution(h, w);
    }
}
