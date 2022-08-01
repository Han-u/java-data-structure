import java.util.HashMap;

class TNode{
    HashMap<Character, TNode> child;
    boolean isTerminal;

    public TNode() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie{
    TNode root;
    public Trie(){
        this.root = new TNode();
    }

    public void insert(String str){
        TNode cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new TNode());
            cur = cur.child.get(c);

            if(i == str.length() - 1){
                cur.isTerminal = true;
                return;
            }
        }
    }

    public boolean search(String str){
        TNode cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(cur.child.containsKey(c)){
                cur = cur.child.get(c);
            }else{
                return false;
            }

            if(i == str.length() - 1){
                if (!cur.isTerminal){
                    return false;
                }
            }
        }
        return true;
    }

    public void delete(String str){
        boolean ret = this.delete(this.root, str, 0);
        if(ret){
            System.out.println(str + " 삭제 완료");
        }else{
            System.out.println(str + " 단어가 없습니다.");
        }
    }

    public boolean delete(TNode node, String str, int idx){
        char c = str.charAt(idx);

        if(!node.child.containsKey(c)){
            return false;
        }

        TNode cur = node.child.get(c);
        idx++;

        if(idx == str.length()){
            if(!cur.isTerminal){
                return false;
            }

            cur.isTerminal = false;

            if(cur.child.isEmpty()){
                node.child.remove(c);
            }
        }else{
            if(!this.delete(cur, str, idx)){
                return false;
            }

            if(!cur.isTerminal && cur.child.isEmpty()){
                node.child.remove(c);
            }
        }

        return true;
    }
}

public class Trie1 {
    /*
        트라이(Trie)
        - 문자열을 저장하고 빠르게 탐색하기 위한 트리 형태의 자료구조
        - 정렬된 트리 구조
        - 문자열 저장을 위한 메모리가 필요하지만 탐색이 빠름
        - 길이 N 문자열 탐색시간 O(N)

        구현:
        key : 알파벳
        value: 자식노드
        로 이루어진 노드로 구성
     */
    public static void main(String[] args){

    }
}
