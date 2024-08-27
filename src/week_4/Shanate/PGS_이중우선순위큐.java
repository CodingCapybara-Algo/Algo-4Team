package week_4.Shanate;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
/*
I 숫자 -> 숫자 삽입
D 1 -> 큐에서 최댓값 삭제
D -1 -> 큐에서 최솟값 삭제

I 16 -> [ 16 ]
I -5643 -> [ 16, -5643 ]
D -1 -> [ 16 ]
D 1 -> [ ]
D 1 -> [ ]
I 123 -> [ 123 ]
D -1 -> [ ]
*/

public class PGS_이중우선순위큐 {
    static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> descPQ = new PriorityQueue<>(Collections.reverseOrder()); // 최대->최소, 내림차순
        PriorityQueue<Integer> ascPQ = new PriorityQueue<>(); // 최소->최대, 오름차순

        for (String operation : operations) {
            String[] tokens = operation.split(" ");
            int num = Integer.parseInt(tokens[1]);
            if(tokens[0].equals("I")){
                descPQ.offer(num); ascPQ.offer(num); // 동시에 집어넣고
            }
            else if(tokens[0].equals("D")){
                if(num == -1){
                    descPQ.remove(ascPQ.poll()); // 서로 뺄 거 빼준다
                }
                else if(num == 1){
                    ascPQ.remove(descPQ.poll()); // 추출
                }
            }
            answer[0] = !descPQ.isEmpty() ? descPQ.peek() : 0;
            answer[1] = !ascPQ.isEmpty() ? ascPQ.peek() : 0;

/*            if(descPQ.isEmpty()){
                answer[0] = 0;
            } else{
                answer[0] = descPQ.peek();
            }
*/
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] operations = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println(Arrays.toString(solution(operations))); // return [0, 0]
        operations = new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(operations)));

    }
}
