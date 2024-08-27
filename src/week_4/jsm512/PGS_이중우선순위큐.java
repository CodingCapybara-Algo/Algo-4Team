package week_4.jsm512;

import java.util.*;

public class PGS_이중우선순위큐 {

    static class Solution {
        /*
        pq를 두개
        */
        public int[] solution(String[] operations) {
            int[] answer = new int[2];

            PriorityQueue<Integer> min_q = new PriorityQueue<>();
            PriorityQueue<Integer> max_q = new PriorityQueue<>(Collections.reverseOrder());

            for(int i = 0; i < operations.length; i++){
                String str = operations[i];
                char cmd = str.charAt(0);
                int value = Integer.parseInt(str.substring(2));

                if(cmd == 'I'){ //삽입
                    min_q.offer(value);
                    max_q.offer(value);
                }
                else{ //삭제
                    if(!min_q.isEmpty()){

                        if(value == -1){ //최솟값 삭제
                            int min = min_q.poll();
                            max_q.remove(min);
                        }
                        else{ //최댓값 삭제
                            int max = max_q.poll();
                            min_q.remove(max);
                        }
                    }
                }
            }
            if(min_q.size() > 0){
                answer[0] = max_q.poll();
                answer[1] = min_q.poll();
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})); //[0,0]
    }
}
