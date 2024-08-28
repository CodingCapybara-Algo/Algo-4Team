package week_5.jsm512;

import java.util.*;

public class PGS_의상 {
    static class Solution {
        /*
        종류별 최대 1개
        Map으로 해야겠는데? String String[]으로 받아서
        아니다 굳이 의상을 String으로 저장할 필요가 없을 거 같은디./..//.///./
        개수만 저장하면 될 듯?
        각 key의 value+1 값을 곱하면 --> 전체 조합의 개수가 나옴
        */
        public int solution(String[][] clothes) {
            int answer = 1;

            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < clothes.length; i++){
                map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
            }

            for(String s : map.keySet()){
                answer *= (map.get(s) + 1);
            }

        /*
        고수 발견
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
        */

            return answer - 1;
        }
    }
}
