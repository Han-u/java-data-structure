import java.util.Arrays;
import java.util.Hashtable;

public class HashTableP2 {
    // num에서 임의의 두수 도해 target 구할수있는지
    // 있으면 index 없으면 null
    public static int[] solution(int[] numbers, int target) {
        int[] result = new int[2];
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for (int i = 0; i < numbers.length; i++) {
            if(ht.containsKey(numbers[i])){
                 result[0] = ht.get(numbers[i]);
                 result[1] = i;
                 return result;
            }
            ht.put(target - numbers[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[] = {7, 11, 5, 3};
        System.out.println(Arrays.toString(solution(nums, 10)));

        nums = new int[]{8, 3, -2};
        System.out.println(Arrays.toString(solution(nums, 6)));

        nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(solution(nums, 12)));

    }
}
