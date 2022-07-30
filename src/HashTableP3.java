import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableP3 {
    // Hashtable과 HashMap
    public static void main(String[] args){
        // Hashtable
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(0, 10);
        System.out.println(ht.get(0));

        // HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 10);
        System.out.println(hm.get(0));

        Map<Integer, Integer> map1 = ht;
        Map<Integer, Integer> map2 = hm;

        // ht.put(null, -999); // error
        hm.put(null, -999);

        // 차이
        // 공통점: 둘 다 Map 인터페이스를 구현한 것
        // 차이: key에 null 사용여부
        // Thread-safe
            // HashTable : O (멀티 스레드 환경에서 우수)
            // HashMap : X (싱글 스레드 환경에서 우수)
            // synchronizedMap ConcurrentHashMap
    }
}
