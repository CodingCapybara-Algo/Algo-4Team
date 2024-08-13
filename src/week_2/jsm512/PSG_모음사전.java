package week_2.jsm512;

import java.util.*;
public class PSG_모음사전 {
    static class Solution {
        /*
        뭔가 dfs로 풀어야될 거 같은 느낌
        모든 조합을 고려하면서 원하는 값을 찾아야되니까 dfs가 맞다고 판단
        */
        char[] ch = {'A','E','I','O','U'};
        int cnt = 0;
        boolean flag = false; //종료
        public int solution(String word) {
            int answer = 0;

            dfs(0,"",word);

            answer = cnt;
            return answer;
        }

        void dfs(int depth, String str, String word){
            if(flag) return;
            if(depth > 5) return;
            if(str.length() > 0){
                cnt++;
                // System.out.println(str);
                if(word.equals(str)){ //==을 쓰면 안되는 이유는? 뭐일까요?(다 같이 정확하게 알았으면 좋겠음)
                    flag = true;
                }
            }
            for(int i = 0; i < ch.length; i++){
                dfs(depth+1, str+ch[i], word);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("EIO"));
    }

}
