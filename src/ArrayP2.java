// 배열에서 target에 해당하는 값의 인덱스 출력
// 값이 여러개면 가장 큰 인덱스 출력

public class ArrayP2 {
    public static void main(String[] args){
        int[] arr = {1, 1, 100, 1, 1, 1, 100};
        int target = 100;
        int idxMax = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                if(i > idxMax){
                    idxMax = i;
                }
            }
        }

        if(idxMax >= 0){
            System.out.println(idxMax);
        }
    }
}
