package week_3.jsm512;

import java.util.*;

public class PGS_같은숫자는싫어 {
/*
stack은 toString이 가능 -> 아래서부터 0 번 idx로 보고 ---->
 */
    public static class Solution {
        public int[] solution(int []arr) {
            int[] answer = {};
            ArrayDeque<Integer> s = new ArrayDeque<>();
            //스택이 비어있지 않고 / peek의 값과 들어온 값이 같다면(연속) continue로 지나침
            for(int i = 0; i < arr.length; i++){
                if(!s.isEmpty() && s.peek() == arr[i]) continue;
                //if문에 안걸렸다면 연속되는 숫자가 아님 -> push
                s.push(arr[i]);
            }

            answer = new int[s.size()];
            //스택은 선입후출(LIFO)로 배열을 뒤에서부터 채우기
            for(int i = answer.length - 1; i >= 0; i--){
                answer[i] = s.pop();
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(s.solution(arr))); // [1, 3, 0, 1]

        arr = new int[]{4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(s.solution(arr))); // [4, 3]

    }
}
