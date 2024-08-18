package week_4.jsm512;

import java.util.*;

public class PGS_더맵게 {

    static class Solution {
        /*
        스코빌 지수가 가장 낮은 두 개의 음식을 조합 -> 정렬?이 되어 있으면 쉬울듯
        모든 음식의 값이 k 이상 -> 조합하고 검사를 계속 해줘
        1. scoville을 우선 순위 큐(min heap)으로 저장
        2. 맨 앞의 두개 씩 조합식에 따라 조합
        3. 추가 -> 우선 순위 큐 적용
        4. 검사 k 이상이면 return
        5. 2~4 반복
        ++ K이상이 안된다면 -1 return
        */
        public int solution(int[] scoville, int K) {
            int answer = 0;
            //가장 작은 값을 항상 앞으로 보내기 위해 우선 순위 큐 사용
            PriorityQueue<Integer> q = new PriorityQueue<>();
            //scoville 배열을 우선순위 큐에 담아줌
            for(int x : scoville){
                q.add(x);
            }

        /*
        q.peek()의 값은 q에서 가장 작은 값이니까 모든 음식이 K 이상이라면
        q.peek()의 값도 K 이상일 것이다
        */
            while(!q.isEmpty() && q.peek() < K){
                //q의 사이즈가 1이라서 조합할 수 없으면
                if(q.size() < 2){
                    return -1;
                }

                int x = q.poll(); //가장 작은 값
                int y = q.poll(); //두번째로 작은 값
                q.offer(x+y*2); //조합식
                answer++;
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1,2,3,9,10,12}, 7)); // return 2
    }
}
