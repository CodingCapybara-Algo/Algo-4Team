package week_3.Shanate;

import java.util.Collections;
import java.util.PriorityQueue;

public class PGS_프로세스 {
    static int solution(int[] priorities, int location) {
        int answer = 0;
        // 우선순위 큐 내림차순 [2, 1, 3, 2] -> [3, 2, 2, 1]
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
        }   // [2, 1, 3, 2] -> [3, 2, 2, 1]
        while(!pq.isEmpty()) {
            // 기존의 배열을 순회
            for(int i = 0; i < priorities.length; i++) {
                //
                // i=0, 3 != 2 -> i=1, 3 != 1 -> i=2, 3 == 3
                if(pq.peek() == priorities[i]) {
                    pq.poll();                // 3
                    answer += 1;               // answer = 1
                    if(location == i){
                        return answer;        // 3 == 3
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location)); // return 1

        priorities = new int[]{1, 1, 9, 1, 1, 1};
        location = 0;
        System.out.println(solution(priorities, location)); // return 5

    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.69ms, 70.2MB)
테스트 2 〉	통과 (0.93ms, 75.7MB)
테스트 3 〉	통과 (0.55ms, 76.3MB)
테스트 4 〉	통과 (0.91ms, 78.4MB)
테스트 5 〉	통과 (0.36ms, 73.6MB)
테스트 6 〉	통과 (0.49ms, 77MB)
테스트 7 〉	통과 (0.75ms, 82MB)
테스트 8 〉	통과 (1.01ms, 74.2MB)
테스트 9 〉	통과 (0.51ms, 73.9MB)
테스트 10 〉	통과 (0.69ms, 72.1MB)
테스트 11 〉	통과 (0.70ms, 73.7MB)
테스트 12 〉	통과 (0.97ms, 76.7MB)
테스트 13 〉	통과 (0.70ms, 72.1MB)
테스트 14 〉	통과 (0.35ms, 76.1MB)
테스트 15 〉	통과 (0.40ms, 78MB)
테스트 16 〉	통과 (0.56ms, 75.3MB)
테스트 17 〉	통과 (0.86ms, 74.1MB)
테스트 18 〉	통과 (0.38ms, 73.9MB)
테스트 19 〉	통과 (0.66ms, 75.7MB)
테스트 20 〉	통과 (0.50ms, 78.8MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
