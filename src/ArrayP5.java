// 오름차순으로 출력

public class ArrayP5 {
    public static void main(String[] args){
        int[] arr = {5, 3, 1, 4, 6, 1};
        int[] visited = new int[arr.length]; // 이미 출력한 숫자
        int visitCnt = 0;
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        while(visitCnt < arr.length){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] < minVal && visited[i] == 0){
                    minVal = arr[i];
                    minIdx = i;
                }
            }

            if(minIdx != -1){ // 최소값 출력
                System.out.println(minVal + " ");
                visited[minIdx] = 1; // 해당 인덱스 위치 방문함
                visitCnt++;
            }
            minVal = Integer.MAX_VALUE; // 초기화
            minIdx = -1;
        }
        System.out.println();
    }
}
