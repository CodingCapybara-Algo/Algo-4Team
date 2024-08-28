package week_3.jsm512;

import java.util.*;

public class PGS_주식가격 {

    static class Solution {
        public int[] solution(int[] prices) {
            //완탐으로 먼저 풀어봤음
         int[] answer = new int[prices.length];

         for(int i = 0; i < prices.length; i++){
             int cnt = 0;
             for(int j = i+1; j < prices.length; j++){
                 if(prices[i] <= prices[j]){
                     cnt++;
                 }
                 else{
                     cnt++;
                     break;
                 }
             }
             answer[i] = cnt;
         }

            return answer;
        }
    }
}
