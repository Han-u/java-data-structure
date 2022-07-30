import java.util.Hashtable;

public class HashTableP1 {
    // 첫번째 배열내에서 두번째 배열 요소들이 있는지
    public static void solution(int[] arr1, int[] arr2){
        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for (int i = 0; i < arr1.length; i++) {
            ht.put(arr1[i], arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if(ht.containsKey(arr2[i])){
                System.out.println("True");
            }else{
                System.out.println("False");
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {1, 2, 3, 4, 5};
        solution(arr1, arr2);
    }
}
