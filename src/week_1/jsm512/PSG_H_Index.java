package week_1.jsm512;

import java.util.*;
public class PSG_H_Index {
    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            for(int i = 0; i < citations.length; i++){
                int cnt = 0;
                for(int j = 0; j < citations.length; j++){
                    if(citations[i] <= citations[j]) cnt++;
                }
                if(citations[i] <= cnt){
                    answer = Math.max(citations[i], answer);
                }
                 else{
                     answer = Math.max(cnt, answer);
                 }
            }
            // Arrays.sort(citations);
            // // System.out.println(Arrays.toString(citations));
            // for(int i = 0; i < citations.length; i++){
            //     if(citations[i] >= citations.length - i){
            //         answer = citations.length - i;
            //         break;
            //     }
            // }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3,0,6,1,5}));
    }
}
