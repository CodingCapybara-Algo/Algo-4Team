package week_1.jsm512;

import java.util.*;
public class PSG_가장큰수 {
    static class Solution {

        public String solution(int[] numbers) {
            String answer = "";
            String[] str = new String[numbers.length];

            for(int i = 0; i < str.length; i++){
                str[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(str,(o1,o2) -> (o2+o1).compareTo(o1+o2));
            // System.out.println(Arrays.toString(str));

            for(int i = 0; i < str.length; i++){
                answer += str[i];
            }
            // System.out.println(answer);
            if(answer.charAt(0) == '0') return "0";
            return answer;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{6,10,2})); //6210
        System.out.println(s.solution(new int[]{3,10,5,7,1})); //753110

    }
}
