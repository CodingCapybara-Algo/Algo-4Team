package week_3.harvartz;
import java.util.*;

public class PGS_주식가격 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer[]> stack = new Stack<>();

        for(int i = 0; i < prices.length; i++){
            answer[i] = answer.length - 1 - i; // 최대기간으로 세팅
            Integer[] arr = {i, prices[i]}; // 인덱스, 가격

            // 스택이 비어 있지 않지 않고 && 스택에서 꺼낸 가격이 현재 가격보다 높다면 -> 가격이 떨어졌다.
            while(!stack.empty() && stack.peek()[1] > prices[i]){ // 가격이 떨어진 경우
                // 스택에서 값을 꺼내서 정답 인덱스를 바꿔줘야 한다.
                Integer[] price = stack.pop();
                //현재 비교할 인덱스 - 스택에서 꺼낸 값의 인덱스 => 떨어지지 않은 기간을 구할 수 있다.
                answer[price[0]] = i - price[0];
            }

            stack.push(arr);
        }
        return answer;
    }
}
