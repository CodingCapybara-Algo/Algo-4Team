package week_3.harvartz;
import java.util.*;
// 1. PriorityQueue<int[]>일 때 Collections.reverseOrder() 방법
public class PGS_프로세스 {
    // 문제 풀이
    // PriorityQueue<int[]>를 활용한 풀이 방법 -> 기존의 순서를 지킬 수 없다.
    public int solution(int[] priorities, int location) {
        // 우선순위 큐 생성
        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
        // 하나씩 넣어주기
        for(int i = 0; i< priorities.length; i++){
            qu.add(priorities[i]);
        }
        int answer = 0;
        while(!qu.isEmpty()){
            // 순서를 확인하기 위한 for 문
            for(int i = 0; i<priorities.length; i++){
                if(qu.peek() == priorities[i]){ // pq의 맨 위의 값과 배열의 값이 같다? -> 우선순위가 가장 높은 값이다.
                    qu.poll();
                    answer++;
                    // 그 값의 순서와 내가 찾으려는 순서와 같다? -> 답이다.
                    if(i == location){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
