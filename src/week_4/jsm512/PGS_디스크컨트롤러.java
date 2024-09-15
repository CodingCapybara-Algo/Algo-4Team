package week_4.jsm512;

import java.util.*;

public class PGS_디스크컨트롤러 {
//다시 풀어보기..
    static class Solution {
    /*
기본적인 동작은 요청 시간이 빠른 순서대로 진행하지만,
뒤에 진행될 작업의 요청 시간이 앞 전의 완료 시간보다 빠르다면
ex) [1,9],[2,6]의 요청 시간은 각각 1,2로 [0,3]의 완료시간인 3보다 빠르다.
이때, [1,9],[2,6]의 작업에 대해 작업속도를 기준으로 한 우선순위 큐를 적용한다.

여기서 반례를 생각해서
요청시간이 가장 빠른 작업의 작업 속도가 뒤에 오는 작업보다 훨씬 오래 걸리는 경우를 생각해봤을 때, 소수점 이하는 버린다는 조건? 때문에 상관없이 위에 조건으로도 풀린다..
*/
    public int solution(int[][] jobs) {
        int answer = 0;
        //요청시간이 가장 빠른 순으로 정렬
        Arrays.sort(jobs,(o1,o2) -> o1[0]-o2[0]);
        //이전 작업의 완료 시간보다 빠른 요청 시간을 가진 작업들을 작업 속도를 순으로 정렬
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

        int start = 0; //가장 빠른 요청시간
        int cur_idx = 0; //작업의 완료시간
        int work_flow = 0; //총 걸린 시간
        int cnt = 0; //완료한 작업의 개수

        while(cnt < jobs.length){

            //작업의 완료 시간보다 요청 시간이 더 빠르다면, 우선순위 큐에 넣는다
            while(start < jobs.length && jobs[start][0] <= cur_idx){
                q.offer(jobs[start++]);
            }
            //현재 작업의 완료 시간보다 빠른 요청시간이 없다면, 작업의 완료시간을 초기화
            if(q.isEmpty()){
                cur_idx = jobs[start][0];
            }

            else{
                int[] tmp = q.poll();
                work_flow += tmp[1] + cur_idx - tmp[0];
                cur_idx += tmp[1];
                cnt++;
            }

        }
        answer = (int)Math.floor(work_flow/jobs.length);


        return answer;
    }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{0,3},{1,9},{2,6}}));
    }
}
