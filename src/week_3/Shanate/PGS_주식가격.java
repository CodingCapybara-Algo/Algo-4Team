package week_3.Shanate;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PGS_주식가격 {
    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i < prices.length; i++) {
                // for문을 돌면서 주식이 하락했을 때는 answer에 여태 카운팅을 집어넣고, 상승 혹은 유지일 경우에는 stack에 넣는다.
                while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                    // 처음 stack이 비어있기에 false -> stack.push(0)
                    // i=1 -> prices[1] < prices[0] => 2 < 1 false -> stack.push(1)
                    // i=2 -> prices[2] < prices[1] => 3 < 2 false -> stack.push(2)
                    // i=3 -> prices[3] < prices[2] => 2 < 3 true  -> answer[2] = 1 , stack.pop() 2, stack.push(3)
                    // i=4 -> prices[4] < prices[3] => 3 < 2 false -> stack.push(4)
                    answer[stack.peek()] = i - stack.peek();    // 최종 answer[2] = 1
                    stack.pop();
                }
                stack.push(i);
            }
            // stack에 값이 끝까지 떨어지지 않았을 때, 빌 때까지 prices.length - stack.peek() - 1
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }   // answer[4] = 5-4-1=0  answer[3]=5-3-1=1   answer[1]=5-1-1=3   answer[0]=5-0-1=4

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices))); // return [4, 3, 1, 1, 0]
    }
}
