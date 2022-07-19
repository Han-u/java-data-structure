// 주어진 문자열 배열을 연결 리스트 배열로 관리하는 코드 작성하기

import java.util.HashSet;

public class LinkedListP4 {
    public static void dataCollect(String[] data){
//        HashSet<Character> set = new HashSet();
//
//        for(String item: data){
//            set.add(item.toCharArray()[0]);
//        }
//        System.out.println(set);
//
//        Character[] arr = set.toArray(new Character[0]);
//        LinkedList[] linkedList = new LinkedList[set.size()];
//        for (int i = 0; i < linkedList.length; i++) {
//            linkedList[i] = new LinkedList(null, arr[i]);
//        }
//
//        for(String item:data){
//            for(LinkedList list: linkedList){
//                if (list.alphabet == item.toCharArray()[0]){
////                    list.addData(item);
//                }
//            }
//        }
     }

    public static void main(String[] args){
        String[] input = {"apple", "watermelon", "banana", "apricot", "kiwi", "blueberry"};
        dataCollect(input);

        System.out.println();
        String[] input2 = {"ant", "kangaroo", "dog", "cat", "alligator", "duck", ""};
    }
}
