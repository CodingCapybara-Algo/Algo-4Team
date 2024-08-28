package week_5.jsm512;

import java.util.*;
public class PGS_폰켓몬 {
    static class Solution {
        /*
        종류의 수 = 중복 제거
        */
        public int solution(int[] nums) {
            int answer = 0;

            //최댓값 비교
            int num = nums.length / 2;

            //중복 제거 Set자료구조 사용
            HashSet<Integer> s = new HashSet<>();

            for(int x : nums){
                s.add(x);
            }

            //중복제거된 포켓몬 종류
            answer = s.size();

            //최대로 가져갈 수 있는 포켓몬의 수는 num
            if(answer <= num){
                return answer;
            }else{
                return num;
            }
        }
    }
}
