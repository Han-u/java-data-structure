import java.util.Stack;

// 두 문자열 비교 #은 backspace
public class StackP4 {

    public static boolean stringCompare(String s1, String s2){
        String s1After = doBackspace(s1);
        String s2After = doBackspace(s2);
        return s1After.equals(s2After);
    }

    public static String doBackspace(String s){
        Stack stack = new Stack();
        for(char c : s.toCharArray()){
            if(c == '#' && !stack.isEmpty()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return String.valueOf(stack);
    }
    public static void main(String[] args){
        String s1 = "tree";
        String s2 = "th#ree";
        System.out.println(stringCompare(s1, s2));

        s1 = "ab#a";
        s2 = "abb#";
        System.out.println(stringCompare(s1, s2));

        s1 = "wo#w";
        s2 = "ww#o";
        System.out.println(stringCompare(s1, s2));
    }
}
