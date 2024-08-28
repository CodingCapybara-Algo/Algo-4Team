package week_4.harvartz;
import java.util.*;

public class PGS_이중우선순위큐 {
    // 목적: 명령어에 따라 최대, 최솟값을 삭제한다. 혹은 값을 넣는다.
    // 명령어가 종료된 이후에 남아있는 최대, 최솟값을 구하는 문제이다.
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for (String operation : operations) {
            // 명령어와 input값을 분리하는 과정이다.
            String[] parts = operation.split(" ");
            char command = parts[0].charAt(0);
            int value = Integer.parseInt(parts[1]);

            // 값을 대입하는 명령어일 경우 두 개의 큐에 모두 넣는다.
            if (command == 'I') {
                maxQueue.offer(value);
                minQueue.offer(value);
            } else if (command == 'D') {
                // 최댓값을 삭제하는 경우는 maxQueue에 최댓값을 삭제한다.
                // 동시에 최댓값에 대한 값을 minQueue에서 삭제하여 동기화를 시켜준다.
                // remove() 함수를 알았냐 몰랐냐의 차이가 클 거 같다.
                if (value == 1 && !maxQueue.isEmpty()) {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                } else if (value == -1 && !minQueue.isEmpty()) {
                    // 최솟값 삭제
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                }
            }
        }

        if (maxQueue.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxQueue.peek(), minQueue.peek()};
        }
    }
}
