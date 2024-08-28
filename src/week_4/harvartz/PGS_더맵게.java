package week_4.harvartz;
import java.util.*;

public class PGS_더맵게 {
    // 목적: 음식을 섞으면서 모든 음식의 스코빌 지수가 K이상으로 만들기

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 스코빌 지수를 큐에 모두 넣는다.
        for(int i : scoville){
            pq.add(i);
        }
        // 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞음
        int answer = 0;
        while(!findAll(pq, K)){
            // 큐
            if(pq.size() == 1) return -1;
            // 첫번째, 두번째를 빼서 섞는다.
            int first = pq.poll();
            int second = pq.poll();
            int mixed = first + second * 2;
            // 섞어서 다시 넣는다.
            pq.offer(mixed);
            answer++;
        }
        return answer;
    }

    // 스코빌 지수가 K 이상인지 확인하는 함수
    public static boolean findAll(PriorityQueue<Integer> pq, int K){
        // 큐를 다 돌려서 K보다 낮으면 바로false 반환
        for(int i : pq){
            if(i < K) {
                return false;
            }
        }
        return true;
    }
}
