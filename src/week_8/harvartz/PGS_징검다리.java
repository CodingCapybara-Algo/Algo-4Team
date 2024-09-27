package week_8.harvartz;

import java.util.*;

public class PGS_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0, right = distance;

        Arrays.sort(rocks);  // 돌들을 오름차순으로 정렬
        while (left <= right) {
            int mid = left + (right - left) / 2;  // 중간 값을 구할 때 오버플로우 방지
            int removeRocks = 0;
            int prev = 0;  // 시작점부터의 거리

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    removeRocks++;  // 거리 차이가 mid보다 작으면 돌을 제거
                } else {
                    prev = rocks[i];  // 돌을 제거하지 않는 경우, 이전 돌을 갱신
                }
            }

            // 마지막 바위와 도착 지점 간 거리 체크
            if (distance - prev < mid) {
                removeRocks++;  // 도착 지점까지의 거리도 확인
            }

            // 제거한 바위의 수가 허용된 수 이하이면
            if (removeRocks <= n) {
                answer = mid;  // 최댓값 갱신
                left = mid + 1;  // 더 큰 거리로 탐색
            } else {
                right = mid - 1;  // 더 작은 거리로 탐색
            }
        }
        return answer;
    }
}
