package week_8.Shanate;

import java.util.Arrays;
/*
시작 지점은 0, 종료 지점은 25
answer = 바위를 제거한 뒤 각 지점 사이의 거리 중 가장 큰 값
1. 바위 오름차순 정렬
2.1. 이분탐색 알고리즘 사용
2.2. mid 설정(14)
2.3. 0-2의 거리 < 14 => 2 제거
2.4. 0-11의 거리 < 14 => 11 제거
2.5. 0-14의 거리 = 14 => 기준점을 14로 설정
2.6. 17-14의 거리 < 14 => 17제거
2.7. 21-14의 거리 < 14 => 21제거
2.8. 25-14의 거리 < 14.
3. 종료 당시 지운 횟수 비교. 문제(2) != 현재 지운 개수(4)
3.1. n개 보다 많이 지우면 right = mid - 1로 하면서 다시 반복
3.2 n개 보다 적게 지웠으면, left = mid + 1로 설정하고 다시 반복
*/


public class PGS_징검다리 {
    static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0;
        int right = distance;
        Arrays.sort(rocks);

        while(left <= right) {
            int mid = (left + right) / 2;
            int stone = 0; // 제거할 돌
            int mark = 0; // 기준점이 되는 돌

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - mark < mid)
                    stone++;
                else{
                    mark = rocks[i];
                }
            }
            if (distance - mark < mid ) {
                stone++;
            }
            if(stone <= n) {
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = new int[]{2, 14, 11, 21, 17};
        int n = 2;
        System.out.println(solution(distance, rocks, n));
    }
}
