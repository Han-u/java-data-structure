// N >= K 양의정수
// 1번부터 N번까지 N명이 순서대로 원을 이루어 모여있다. 원을 따라 순서대로 K번째 사람을 제외한다
// 모든 사람들이 제외될때까지 반복한다. 제외되는 순서가 요세푸스 순열이다.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class QueueP2 {

    public static ArrayList getJosephusPermutation(int N, int K){
        ArrayList result = new ArrayList();
        Queue queue = new LinkedList();

        IntStream.range(1, N+1).forEach(x -> queue.add(x));
        int cnt = 0;
        while(!queue.isEmpty()){
            int data = (int)queue.remove();
            cnt += 1;

            if(cnt % K == 0){
                result.add(data);
            }else{
                queue.add(data);
            }
        }

        return result;
    }
    public static void main(String[] args){
        System.out.println(getJosephusPermutation(5, 2));
        System.out.println(getJosephusPermutation(7, 3));
    }
}
