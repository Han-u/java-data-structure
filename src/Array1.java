import java.util.ArrayList;
import java.util.Arrays;

public class Array1 {
    public static void main(String[] args){
        /*
            배열
            - 인덱스와 1:1 대응
            - 메모리 상 연속적 저장

            장점
            - 인덱스로 데이터 빠른 접근 가능

            단점
            - 데이터 추가 / 삭제 번거롭
            - 미리 최대 길이 정해야함
            - 가변길이 배열은 크기 변경마다 새 배열 생성
            - 데이터 삭제시 인덱스 유지위해 빈 공간 유지
        */


        // 1. 1차원 배열
        int[] arr = {1, 2, 3, 4, 5};
        for(int item: arr){
            System.out.println("item = " + item);
        }

        arr[1] = 100;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));



        // 2. 2차원 배열
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(arr2[0][1]);

        for(int[] row: arr2){
            for(int item: row){
                System.out.println("item = " + item);
            }
        }


        // 3. ArrayList 1, 2차원 배열
        ArrayList list1 = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println("list1 = " + list1);
        list1.add(4);
        list1.add(5);
        list1.remove(2);
        list1.remove(Integer.valueOf(2));

        ArrayList list2d = new ArrayList();
        ArrayList list1d1 = new ArrayList(Arrays.asList(1, 2, 3));
        ArrayList list1d2 = new ArrayList(Arrays.asList(4, 5, 6));
        list2d.add(list1d1);
        list2d.add(list1d2);

        System.out.println("list1d1 = " + list1d1);
        System.out.println("list1d2 = " + list1d2);
        System.out.println("list2d = " + list2d);

    }
}
