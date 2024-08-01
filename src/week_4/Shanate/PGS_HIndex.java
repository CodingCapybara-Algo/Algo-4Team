package week_4.Shanate;

import java.util.*;
import java.io.*;

// 받은 입력값을 정렬.
// H : 논문 인용 횟수 >= H회 이상 인용된 논문의 개수


public class PGS_HIndex {
    static int solution(int[] citations) {
        int answer = 0;
//  {3, 0, 6, 1, 5} -> {0, 1, 3, 5, 6}
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++) {
            int H = citations.length - i; // 논문 인용 횟수
            if(citations[i] >= H){
                answer = H;
                break;
            }
        }

        // H = 5-0
        // citations[0] = 0 >= 5 X
        // H = 5-1
        // citations[1] = 1 >= 4 X
        // H = 5-2
        // citations[2] = 3 >= 3
        return answer;
    }


    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(solution(citations));  // return 3

        citations = new int[]{3, 4};
        System.out.println(solution(citations));  // return 2

        citations = new int[]{1, 2, 3, 5, 6, 7, 10, 11};
        System.out.println(solution(citations));  // return 5

    }
}

//테스트 1  〉   	통과 (0.60ms, 76.5MB)
//테스트 2  〉   	통과 (0.91ms, 75.9MB)
//테스트 3  〉   	통과 (0.57ms, 75.1MB)
//테스트 4  〉   	통과 (0.54ms, 72.5MB)
//테스트 5  〉   	통과 (0.85ms, 75MB)
//테스트 6  〉   	통과 (0.89ms, 69.6MB)
//테스트 7  〉   	통과 (0.46ms, 76.6MB)
//테스트 8  〉   	통과 (0.37ms, 74MB)
//테스트 9  〉   	통과 (0.39ms, 72.7MB)
//테스트 10 〉	통과 (0.62ms, 68.7MB)
//테스트 11 〉	통과 (0.94ms, 76.8MB)
//테스트 12 〉	통과 (0.36ms, 71.3MB)
//테스트 13 〉	통과 (0.93ms, 85.2MB)
//테스트 14 〉	통과 (0.99ms, 77.6MB)
//테스트 15 〉	통과 (0.65ms, 76.9MB)
//테스트 16 〉	통과 (0.37ms, 75.8MB)