package week_6.jsm512;

import java.util.*;
public class PGS_단어변환 {
    static class Solution {
        /*
        1. hit -> hot으로만 바꿀 수 있음
        2. hot은 dot or lot로 변경 가능
        3. dot는 dog or log로 변경 가능
        4. dog는 log 또는 cog로 변경 가능 (O)
        하나만 바꿔서 변경할 수 있는게 있으면 -> 깊이 우선 탐색으로 ㄱㄱ
        */
        int answer = Integer.MAX_VALUE;
        boolean[] check;
        public int solution(String begin, String target, String[] words) {
            check = new boolean[words.length];
            // 변환할 수 있는 words 배열에 target 문자열이 없으면 -> 0 리턴
            /*
            Array -> List : asList()
            List -> Array : toArray()
            */
            List<String> list = new ArrayList<>(Arrays.asList(words));
            if(!list.contains(target)){
                return 0;
            }

            dfs(begin, target, words, 0);

            return answer;
        }
        void dfs(String begin, String target, String[] words, int depth){
            if(begin.equals(target)){
                //Math.min안해도 정답인 이유?
                answer = Math.min(answer,depth);
            }

            for(int i = 0; i < words.length; i++){
                if(!check[i]){
                    int cnt = count(begin, words[i]);

                    if(cnt == 1){
                        check[i] = true;
                        dfs(words[i], target, words, depth+1);
                        check[i] = false;
                    }
                }
            }
        }

        int count(String begin, String words){
            int cnt = 0;
            for(int i = 0; i < begin.length(); i++){
                if(begin.charAt(i) != words.charAt(i)) cnt++;
            }

            return cnt;
        }

    }
}
