package week_2.jsm512;

import java.util.*;
public class PSG_카펫 {
    static class Solution {
        /*
        brown+yellow 해서
        x * y = brown+yellow인 값을 찾는다
        -> x와 y의 차이가 최소가될 때 정답??
        => 반례가 나옴... 뭐지??????????
        => 차이가 최소가 되는 값으로 하게되면 타일 갯수가 안맞을 수 있음.. 조건을 바꿔줘야될듯



        12
        */
        public int[] solution(int brown, int yellow) {
            int[] answer = {};

            int sum = brown + yellow;
            int min = Integer.MAX_VALUE;
            for(int i = 3; i <= Math.sqrt(sum); i++){

                if(sum % i == 0){
                    int x = i;
                    int y = sum/i;
                    if(y >= x){
                        int cnt = (x-2)*2 + y*2; //갈색 타일 갯수
                        if(cnt == brown){
                            answer = new int[]{y,x};
                        }
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10, 2));
    }
}
