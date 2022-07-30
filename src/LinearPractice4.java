import java.util.HashMap;
import java.util.Stack;

public class LinearPractice4 {

    public static void solution(String str){
        Stack<String> stack = new Stack<>();
        boolean checkFlag = true;

        HashMap<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");

        for(String s: str.split("")){
            if (map.containsKey(s)){
                stack.push(s);
            }else if(map.containsValue(s)){
                if(stack.isEmpty()){
                    checkFlag = false;
                    break;
                }else{
                    String cur = stack.pop();
                    if(!s.equals(map.get(cur))){
                        checkFlag = false;
                        break;
                    }
                }
            }
        }

        if(checkFlag && stack.isEmpty()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }

    public static void main(String[] args){
        solution("[yyyy]-[mm]-[dd]");
        solution("System.out.println(arr[0][1))");
        solution("Support {Java or Python(3.x)}");
        solution("([[{}])");
    }
}