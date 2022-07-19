// 배열 데이터 순서 거꾸로
// 추가 배열 사용하지 않고

import java.util.Arrays;

public class ArrayP3 {
    public static void main(String[] args){
        int[] arr = {1, 3, 5, 7, 9};

        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i]=tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
