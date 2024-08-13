package week_3.harvartz;
import java.util.*;

public class PGS_같은숫자는싫어 {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int x : arr){
            if(stack.isEmpty()){
                stack.push(x);
            } else if(x != stack.peek()){ // 연속적으로 나타나는 숫자이기 때문에 직전에 집어넣은 숫자와 비교
                stack.push(x);
            }
        }

        int[] answer = new int[stack.size()];

        // 하나씩 뽑아내어 answer 배열에 넣기
        for(int i = stack.size()-1 ; i>=0 ; i--){
            answer[i] = stack.pop();
        }
        return answer;
    }
}
