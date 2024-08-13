package week_3.jsm512;

import java.util.*;
public class PGS_프로세스 {
    static class Solution {
    /*
    우선순위가 있음 -> 우선순위 큐 사용
    큰 숫자가 높은 순위 -> reverseOrder
    q는 내림차순으로 있으니까
    peek()랑 원본 배열이랑 비교 -> answer++
    비교하는 원본 배열이랑 location도 동시에 비교
    */

        public int solution(int[] priorities, int location) {
            int answer = 0;
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

            for(int i = 0; i < priorities.length; i++){
                q.offer(priorities[i]);
            }

            Loop : while(!q.isEmpty()){
                for(int i = 0; i < priorities.length; i++){

                    if(q.peek() == priorities[i]){
                        answer++;
                        q.poll();
                        if(i == location){
                            break Loop;
                        }
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(s.solution(priorities, location)); // return 1

        priorities = new int[]{1, 1, 9, 1, 1, 1};
        location = 0;
        System.out.println(s.solution(priorities, location));
    }
}
