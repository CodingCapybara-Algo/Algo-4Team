package week_1.Shanate;

import java.util.*;

public class PGS_K번째수 {

    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length]; // commands.length = 3

            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0; i<commands.length; i++){
                for(int j=commands[i][0]; j<=commands[i][1]; j++){
                    list.add(array[j-1]); // 시점 e ~ 종점 e를 list에 추가
                }
                Collections.sort(list); // 배열 다 뽑아낸 후 정렬
                answer[i] = list.get(commands[i][2]-1); // K번째 e 추출
                list.clear(); // list 배열 초기화
            }

            return answer;
        }
    }
}

//테스트 1 〉	통과 (0.29ms, 89.5MB)
//테스트 2 〉	통과 (0.31ms, 78.4MB)
//테스트 3 〉	통과 (0.20ms, 69.2MB)
//테스트 4 〉	통과 (0.22ms, 72.7MB)
//테스트 5 〉	통과 (0.32ms, 71.2MB)
//테스트 6 〉	통과 (0.32ms, 76MB)
//테스트 7 〉	통과 (0.22ms, 75.5MB)
