package week_8;

import java.util.*;

public class PGS_입국심사 {
    // 목적: 가장 짧은 전체 입국 심사 시간 구하기
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        // 범위 0 ~ 가장 오래 걸리는 시간 * 사람 수 = 가장 오래 걸리는 시간
        long left = 0;
        long right = times[times.length - 1] * (long) n;

        while (left <= right) {
            // mid 시간에 각 심사대에서 처리할 수 있는 사람 수
            long mid = (left + right) / 2;
            long complete = 0;
            // 각 심사대에서 처리할 수 있는 사람 수 더하기
            for (int i = 0; i < times.length; i++) {
                // mid 시간에 각 심사대에서 처리할 수 있는 사람 수
                complete += mid / times[i];
            }
            // 만약에 처리한 사람 수가 n보다 작으면 시간을 늘려야함
            if (complete < n)
                left = mid + 1;
                // 만약에 처리한 사람 수가 n보다 크면 시간을 줄여야함
            else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
