package week_4.jsm512;

import java.util.*;

public class PGS_디스크컨트롤러 {
//다시 풀어보기..
    static class Solution {
        /*
        한번에 하나의 요청만 수행 가능
        작업 속도가 빠른 순서대로 작업을 진행하면 평균 시간을 단축할 수 있음
        => 각 작업의 완료 시간은 요청시간부터 계산 됨
        우선 순위 큐(min heap)으로 풀이
        2차원 배열????????? 2차원 배열 우선 순위 큐를 사용?
        0번 째 indext는 요청 위치 / 1번 째 index는 작업 시간
        예제만 봤을 때는 작업 속도가 느린 순서(min heap)으로 우선 순위 큐를 구성한 것으로 보임.. 검증 필요
        [[3,3],[1,9],[2,6]] 일 때, 예제와 같이 푼다면 작업 속도가 가장 빠른 순서 대로 [3,3],[2,6],[1,9]로
        큐에 들어가서 진행하면 33/3 = 11ms
        만약 요청 시간을 기준으로
        [1,9],[2,6],[3,3]으로 큐에 들어 간다면, 39/3 = 13ms의 값이 나옴
        따라서, 작업 속도가 빠른 순서대로 큐에 들어가 작업을 진행

        [[0, 10], [4, 10], [5, 11], [15, 2]]에서 평균 속도는 15ms가 나와야됨
        -> 작업속도가 빠른 순서대로 큐에 들어간다면
        [15,2],[0,10],[4,10],[5,11] => 이렇게 되면 평균 속도는 26ms
        작업 속도 순서대로 큐에 들어가는 건 맞지만, 요청 시간 또한 고려해 줘야될듯
        [15,2]가 들어오기전에 [0,10] or [4,10]은 완료할 수 있음 -> [15,2]랑 [0,10]or[4,10]이랑은 상관이 없는
        작업 따라서 jobs 배열도 같이 검사를 진행하는 방법으로 다시 풀이 ㄱㄱ
        1. jobs배열을 요청 시간에 따라 오름차순으로 정렬
        2. pq에 작업속도가 빠른 순으로 들어감 => pq에 먼저 넣고 검사하는 방식으로 가면 인덱스로 접근하기 애매해짐
        => 3번에서 가능한 작업을 pq에 넣어 진행하는 방식으로 바꿔야될 듯..
        3. pq의 요청 시간보다 먼저 완료할 수 있는 작업? 낭비되는 시간이 없도록 가능한 작업은 pq에 넣어줌
        => [15,2] 작업이 오기전에 [0,10],[4,10]의 작업을 하면 [15,2] 작업 전 낭비되는 시간이 없음
        4.
        */
        public int solution(int[][] jobs) {
            int answer = 0;
            Arrays.sort(jobs,(o1,o2) -> o1[0]-o2[0]);
            int[][] arr = new int[jobs.length][2];
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < 2; j++){
                    arr[i][j] = jobs[i][j];
                }
            }
            Arrays.sort(arr,(o1,o2) -> o1[1] - o2[1]);
            int start = arr[0][1];
            PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

            int cnt = 0;
            int idx = 0;
            int sum = 0;
            int cur_idx = jobs[0][0];
            while(cnt < jobs.length){

                while(idx < jobs.length && cur_idx <= start){
                    sum += jobs[idx][1] + cur_idx - jobs[idx][0];
                    cur_idx += jobs[idx][1];
                    idx++;
                }
                for(int i = idx; i < jobs.length; i++){
                    q.offer(jobs[i]);
                }

                while(!q.isEmpty()){
                    int[] tmp = q.poll();
                    sum += tmp[1] + cur_idx - tmp[0];
                    cur_idx += tmp[1];
                    idx++;
                }
            }

            answer = sum / jobs.length;




            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{0,3},{1,9},{2,6}}));
    }
}
