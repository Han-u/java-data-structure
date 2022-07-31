public class TreeP1 {
    public static void solution(int n){
        int[] bt = new int[(int)Math.pow(2,n)];
        bt[0] = 0;
        for (int i = 0; i < (int)Math.pow(2,n-1)-1; i++) {
            bt[i*2+1] = 0;
            bt[i+2+2] = 1;
        }
        inOrder(bt, 0);
        System.out.println();
    }

    public static void inOrder(int[] arr, int idx){
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if(left < arr.length - 1){
            inOrder(arr,left);
        }
        System.out.println(arr[idx] + " ");
        if(right < arr.length - 1){
            inOrder(arr, right);
        }
    }

    public static void main(String[] args){
        solution(1);
        solution(2);
        solution(3);
    }
}
