import java.util.Hashtable;

public class LinearPractice9 {
    public static String solution(String[] participant, String[] completion){
        String result = "";
        Hashtable<String, Integer> ht = new Hashtable<>();

        for(String item:participant){
            if (ht.containsKey(item)){
                ht.put(item, ht.get(item) + 1);
            }else{
                ht.put(item, 1);
            }
        }

        for(String item: completion){
            ht.put(item, ht.get(item) - 1);
        }

        for(String item: participant){
            if(ht.get(item) > 0){
                result = item;
                break;
            }
        }

        return result;
    }
    public static void main(String[] args){
        String [] participant = {"leo", "kiwi", "eden"};
        String[] completion = {"eden", "kiwi"};

        System.out.println(solution(participant, completion));
    }
}
