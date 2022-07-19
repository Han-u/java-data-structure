// 이차원배열 arr을 시계방향 90도 회전시킨 결과

public class ArrayP7 {
    static void printArr(int[][] arr){
        for(int[] item1D: arr){
            for(int item: item1D){
                System.out.println(item + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] arr ={{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};

        int[][] arr90 = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int r = arr.length - 1 - i;
                arr90[j][r] = arr[i][r];
            }
        }

        printArr(arr);
        printArr(arr90);

    }
}
