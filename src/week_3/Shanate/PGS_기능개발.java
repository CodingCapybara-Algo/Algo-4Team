package week_3.Shanate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
100%가 완료되어도 자신의 앞 작업이 미완료 상태라면 무한 대기 상태.
-> for문이 반복될 때마다, 본인의 앞 작업과 100%이 되었을 때 같이 큐에서 빠져나간다.

*/

public class PGS_기능개발 {
    static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // 각 과정이 배포될 날을 구해 큐에 쌓는다.
    for(int i=0; i<progresses.length; i++) {
        if((100 - progresses[i]) % speeds[i] == 0) { // 나머지가 0일 때 당일 배포
            queue.offer((100 - progresses[i]) / speeds[i]);
        } else {                                    // 나머지가 0이 아닐 때 다음 날 배포
            queue.offer(((100 - progresses[i]) / speeds[i]) + 1);
        }
    } // 배포 가능 날짜 [7, 3, 9]

    int now = queue.poll(); // 7    [3, 9]
    int count  = 1;

    while(!queue.isEmpty()) {
        // 현재 배포 날짜가 다음 배포날짜보다 크면 추가
        if(now >= queue.peek()){    // 7 >= 3         else 7 !>=9
            count++;                // 2
            queue.poll();           // 7,3  [9]
        } else{ // 현재 배포 날짜가 다음 날짜보다 작으면 answer에 카운트 담고, count 초기화.
        answer.add(count);              // 2
        count = 1;                      // 1 카운트 초기화
        now = queue.poll(); // 다음 배포날짜  // 9
        }
    }
        answer.add(count); // 마지막 카운트   // 1


        return answer.stream().mapToInt(i->i).toArray();    // 한줄에 스페이스로 되어 있는 int값을 받을 때 사용할 수 있다.

    }

    public static void main(String[] args) {
        int[]progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds))); // return [2, 1]

        progresses = new int[] {95, 90, 99, 99, 80, 99};
        speeds = new int[] {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds))); // return [1, 3, 2]

    }
}
