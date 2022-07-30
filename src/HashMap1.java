import java.util.Hashtable;
import java.util.Map;

public class HashMap1 {
    /*
       해시테이블
       키: 테이블 접근을 위한 입력 값
       해시 함수: 키를 해시 값으로 매핑하는 연산
       해기 값: 해시 테이블의 인덱스
       해시 테이블: 키-값을 연관시켜 저장하는 데이터 구조


        해시 충돌
        - 같은 공간에 서로 다른 값을 저장하려는 경우
        - 개방 주소법:
            - 충돌시 비어있는 간의 hash를 찾아 저장
            - 1:1 관계 유지
            - 선형탐사법
                - 빈 공간 순차 탐사
                - 일차 군집화: 반복 충돌시 해당 지점 주변에 몰림
            - 제곱탐사법
                - 빈 공간을 제곱 간격으로 탐사
                - 이차 군집화
            - 이중해싱
                - 해싱 함수를 이중으로 사용
                - 1: 최초해시 2: 충돌 발생시 탐사 이동간격
        - 분리 연결법:
            - 해시 테이블을 연결 리스트로 구성
            - 다른 위치를 탐색하지 않고 연결 리스트를 이용해 연결
     */

    public static int getHash(int key){
        return key % 5;
    }
    public static void main(String[] args){
        Hashtable<String, Integer> ht = new Hashtable<>();

        ht.put("key1", 10);
        ht.put("key2", 20);
        ht.put("key3", 30);
        ht.put("key3", 50);

        for(Map.Entry<String, Integer> item: ht.entrySet()){
            System.out.println(item.getKey() + ". " + item.getValue());
        }

        // 해시 충돌 케이스(해시 함수 사용)
        Hashtable<Integer, Integer> ht2 = new Hashtable<>();
        ht2.put(getHash(1), 10);
        ht2.put(getHash(2), 20);
        ht2.put(getHash(3), 30);
        ht2.put(getHash(4), 40);
        ht2.put(getHash(5), 50);

        for(Map.Entry<Integer, Integer> item: ht2.entrySet()){
            System.out.println(item.getKey() + ". " + item.getValue());
        }
        System.out.println("충돌 후");
        ht2.put(getHash(6), 60);
        for(Map.Entry<Integer, Integer> item: ht2.entrySet()){
            System.out.println(item.getKey() + ". " + item.getValue());
        }
    }
}
