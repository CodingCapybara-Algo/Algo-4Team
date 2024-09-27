package week_8.jsm512;

import java.util.*;
public class PGS_징검다리 {
    static class Solution {
        /*
        이분 탐색의 범위?
        -> 0부터 distance까지
        1. rocks 정렬 -> [2, 11, 14, 17, 21]

        */
        public int solution(int distance, int[] rocks, int n) {
            int answer = 0;

            Arrays.sort(rocks);

            //범위
            int left = 1;
            int right = distance;

            while(left <= right){
                int mid = (left + right) / 2;

                //제거된 바위의 개수가 목표한 바위의 개수보다 작거나 같으면
                if(removeRock(rocks, mid, distance) <= n){
                    //mid가 거리의 최솟값 -> 최솟값 중 가잔 큰 값을 저장
                    answer = Math.max(answer, mid);
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

            return answer;
        }
        // 바위 제거 cnt
        public int removeRock(int[] rocks, int mid, int distance){
            int cnt = 0;
            int s = 0;
            // 0과 25도 바위라고 생각
            for(int i = 0; i < rocks.length; i++){
                //각 바위 사이의 거리가 이분탐색(최솟값)의 거리보다 작으면 바위를 제거해야됨
                if(rocks[i] - s < mid){
                    cnt++;
                    continue;
                }
                //목표한 최솟값(이분탐색 mid) 보다 크거나 같으면 해당 바위는 제거하지 않음 s로 바위 위치 초기화
                s = rocks[i];
            }
            // 마지막 바위와 distacne의 거리
            if(distance - s < mid){
                cnt++;
            }

            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(25,new int[]{2,14,11,21,17},2));
    }
}
