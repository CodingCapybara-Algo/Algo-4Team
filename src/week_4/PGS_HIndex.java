package week_4;

import java.util.*;

public class PGS_HIndex {
    public int solution(int[] citations) {
        int answer = 0;

        // 정렬을 진행한다.
        Arrays.sort(citations);

        // 0번째 인덱스부터 
        for(int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // 인용된 논문의 수
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}