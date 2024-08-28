package week_4.harvartz;
import java.util.*;

public class PGS_디스크컨트롤러 {
    // 목표: 모든 작업이 끝나는 시간에 대한 최소 평균 시간 구하기

    public int solution(int[][] jobs) {
        int count = 0; //
        int answer = 0; // 답
        int end = 0; // 끝나는 시점
        int jobsIdx = 0; // jobs 배열의 인덱스

        // 작업이 요청되는 시점을 오름차순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 작업의 소요시간을 기준으로 오름차순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while(count < jobs.length){
            // 현재 배열의 인덱스가 배열의 범위 안에 있어야 하며 &&
            // 비교하려고 하는 작업 시점이 현재까지 작업 완료한 시점보다 작을 경우
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end){
                // 계속 우선순위큐에 넣어준다.
                pq.add(jobs[jobsIdx++]);
            }
            // 만약 큐가 비어있다면, end에 첫번째 인덱스의 배열 값에 대한 작업 완료한 시점을 넣어준다.
            if(pq.isEmpty()){
                end = jobs[jobsIdx][0];
            }else{
                int[] temp = pq.poll();
                // 누적합 += 현재 작업의 길이 + 마지막 위치 - 현재 작업의 시작 위치
                // => 겹치는 부분을 빼주는 것이다.
                answer += temp[1] + end - temp[0];
                // 마지막 위치에서 현재 배열의 길이를 더해준다.
                // => 현재까지 작업이 종료된 시점을 구하는 것이다.
                end += temp[1];
                count++; // 인덱스값은 계속 바뀌기 때문에
            }
        }
        return (int) Math.floor(answer/jobs.length);
    }
}
