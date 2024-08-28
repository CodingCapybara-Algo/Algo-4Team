package week_5.jsm512;

import java.util.*;
public class PGS_완주하지못한선수 {

    static class Solution {
        /*
        같은 이름이 있을 수 있음 -> HashMap으로 풀자
        참가자 이름을 key로 하고 value는 getOrDefault로 확인 후 증가
        */
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            HashMap<String, Integer> map = new HashMap<>();

            for(String s : participant){
                map.put(s, map.getOrDefault(s,0)+1);
            }

            for(String s : completion){
                map.put(s, map.get(s) - 1);
            }

            for(String k : map.keySet()){
                if(map.get(k) != 0){
                    answer = k;
                }
            }


            return answer;
        }
    }
}
