package week_2.Shanate;

import java.util.Arrays;
/*
노란색은 무조건 중앙에 칠한다.
갈색은 테두리에 칠한다.
단, 가로 길이>=세로 길이
1. brown + yellow = 카펫의 넓이
*/

public class PGS_카펫 {
    static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow; // 12 = 10 + 2


        for(int x=sum; x>=1; x--){
            //제한 조건 1 : x>=y
            //제한 조건 2 : 경우의 수에서 x가 최소
            if (sum % x != 0) continue;
            int y = sum / x;
            if (x<y) break; // 더 이상 찾을 필요 X
            if( (x-2)*(y-2) == yellow) { // 카펫 내부에 채워져야 하는 노란 타일의 갯수
                                         // 이 코드를 적용하지 않으면, 코드는 단순하게 x>=y이면서, x가 가장 작을 때만을 값을 가진다.
                answer = new int[]{x, y};
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        int brown, yellow;

        brown = 10; yellow = 2;
        System.out.println(Arrays.toString(solution(brown, yellow))); // return [4, 3]

        brown = 8; yellow = 1;
        System.out.println(Arrays.toString(solution(brown, yellow))); // return [3, 3]

        brown = 24; yellow = 24;
        System.out.println(Arrays.toString(solution(brown, yellow))); // return [8, 6]

        brown = 26; yellow = 10;
        System.out.println(Arrays.toString(solution(brown, yellow))); // return [12, 3]

    }
}
/*
테스트 1 〉	통과 (0.02ms, 77MB)
테스트 2 〉	통과 (0.01ms, 77.5MB)
테스트 3 〉	통과 (6.07ms, 73.9MB)
테스트 4 〉	통과 (0.09ms, 75.5MB)
테스트 5 〉	통과 (0.37ms, 80.1MB)
테스트 6 〉	통과 (3.72ms, 79.5MB)
테스트 7 〉	통과 (6.64ms, 76.5MB)
테스트 8 〉	통과 (5.57ms, 75.8MB)
테스트 9 〉	통과 (6.78ms, 82.9MB)
테스트 10 〉	통과 (7.16ms, 78.5MB)
테스트 11 〉	통과 (0.02ms, 74.3MB)
테스트 12 〉	통과 (0.02ms, 72.8MB)
테스트 13 〉	통과 (0.02ms, 72.3MB)
*/
