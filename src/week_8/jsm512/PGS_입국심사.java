package week_8.jsm512;

import java.util.*;
public class PGS_입국심사 {

    static class Solution {
        /*

         */
        public long solution(int n, int[] times) {
            long answer = 0;
            //가장 오래걸리는 심사 시간을 알기 위해 정렬
            Arrays.sort(times);
            long left = 0;
            //최대로 오래 걸리는 시간
            long right = times[times.length - 1] * (long)n;
            while(left <= right){
                long mid = (right + left) / 2;
                long sum = 0;

                //mid 시간동안 몇명을 검사할 수 있는지 sum으로 체크
                for(int i = 0; i < times.length; i++){
                    sum += mid / times[i];
                }

                //mid 시간안에 n명을 검사할 수 없으면 -> mid보다 많은 시간이 필요
                if(sum < n){
                    left = mid + 1;
                    //mid 시간안에 n명을 모두 검사할 수 있음 -> answer = mid로 갱신(최솟값이 아닐 수 있음)
                }else{
                    right = mid - 1;
                    answer = mid;
                }

            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6,new int[]{7,10}));
    }
}
