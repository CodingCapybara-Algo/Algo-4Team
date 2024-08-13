package week_3.harvartz;
import java.util.*;

public class PGS_기능개발 {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        // 작업 완료까지 남은 일수를 저장할 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 각 작업의 남은 작업 기간을 계산하여 큐에 추가
        for(int x = 0; x < progresses.length; x++){
            // 100에서 현재 진행도를 빼고, 속도로 나눈 후 올림 처리하여 남은 작업 일수를 계산
            queue.add((int)(Math.ceil((100.0 - progresses[x]) / speeds[x])));
        }

        // 결과를 저장할 리스트 생성
        ArrayList<Integer> answer = new ArrayList<>();

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 첫 번째 작업의 남은 일수를 꺼냄
            int day = queue.poll();
            int cnt = 1; // 같이 배포할 작업의 수를 카운트

            // 현재 작업의 남은 일수보다 적은 일수가 남은 작업들은 함께 배포됨
            while(!queue.isEmpty() && day >= queue.peek()){
                cnt++; // 같이 배포할 작업 수 증가
                queue.poll(); // 큐에서 작업 제거
            }
            // 현재 작업 그룹의 개수를 정답 리스트에 추가
            answer.add(cnt);
        }

        // 정답 리스트 반환
        return answer;
    }
}
