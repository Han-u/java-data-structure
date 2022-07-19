// 중복값 제거한 새 배열

public class ArrayP6 {
    public static void main(String[] args){
        int[] arr = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        int[] arrResult = new int[arr.length];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean dupFlag = false;
            for (int j = 0; j < cnt; j++) {
                if(arr[i] == arrResult[j]){ // 중복된 데이터
                    dupFlag = true;
                }
            }

            if(dupFlag == false){
                arrResult[cnt++] = arr[i];
            }
        }

        for (int i = 0; i < cnt; i++) {
            System.out.println(arrResult[i] + " ");
        }
        System.out.println();
    }
}
