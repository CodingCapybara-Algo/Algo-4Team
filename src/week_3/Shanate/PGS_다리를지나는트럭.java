package week_3.Shanate;

import java.util.ArrayDeque;
/*
누가 만든 문제인지는 모르겠으나, 정말 개떡같이 설명 적어놔서 트럭이 어떻게 움직이는건지를 몰랐음.
테스트 케이스 두 번째에서 weight를 distance로 보면 조금 이해가 간다.
트럭이 다리에 발을 올렸을 때부터 시간이 흐르기 시작하며, 완전하게 지나가게 됐을 때의 시간은 결국 다음과 같다.
다리가 견딜 수 있는 무게(터널의 길이) / 트럭의 무게(자동차의 길이) + 1(이거 더하지 않으면 다리에 바퀴 걸쳐져 있다.)
즉, 길이만큼의 큐를 생성

*/

public class PGS_다리를지나는트럭 {
        static public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            ArrayDeque<Integer> queue = new ArrayDeque<>();
            int sum = 0;

        for(int truck : truck_weights) {

            while(true){
                // 다리에 트럭이 없는 경우
                if(queue.isEmpty()){
                    queue.offer(truck);
                    sum += truck;
                    answer++;
                    break;
                }
                // 다리가 꽉 찬 경우
                else if(queue.size()==bridge_length){
                    sum -= queue.poll();
                }
                else{ // 차지 않았을 경우

                    // 트럭이 올라올 수 있을 경우
                    if(sum+truck<=weight){
                        queue.offer(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                    //다리 트럭 무게가 초과인 경우
                    else {
                        queue.offer(0);
                        answer++;
                    }
                }

            }

        }
            answer += bridge_length;

            return answer;
        }

        public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 100;
        int[] truck_weights = {7, 4, 5, 6};
            System.out.println(solution(bridge_length, weight, truck_weights)); // return 8

            bridge_length = 100;
            weight = 100;
            truck_weights = new int[] {10};
            System.out.println(solution(bridge_length, weight, truck_weights)); // return 101

            bridge_length = 100;
            weight = 100;
            truck_weights = new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
            System.out.println(solution(bridge_length, weight, truck_weights)); // return 110


    }
}
