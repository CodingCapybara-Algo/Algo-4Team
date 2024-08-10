package week_3.Shanate;

import java.util.Arrays;
import java.util.Stack;
/*
1st thinking
초기에 스택이 비어있으니 당연히 집어넣는다.
가장 마지막에 집어넣은 숫자와 지금 넣을 숫자를 비교한다.
같으면 넣지 않는다. 같으면 넣는다.
맨 마지막 숫자를 비교하면서 넣을지 말지를 고민한다. => 뭐다? Stack 쓰겠다.
*/

public class PGS_같은숫자는싫어 {
    static int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty() || stack.peek() != arr[i]){
                stack.push(arr[i]);
            }
        }
        answer = new int [stack.size()];
        for (int i=0; i<answer.length; i++){
            answer[i] = stack.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(solution(arr))); // [1, 3, 0, 1]

        arr = new int[]{4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(solution(arr))); // [4, 3]
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.12ms, 83.6MB)
테스트 2 〉	통과 (0.25ms, 74.3MB)
테스트 3 〉	통과 (0.28ms, 72.3MB)
테스트 4 〉	통과 (0.17ms, 72.1MB)
테스트 5 〉	통과 (0.16ms, 76.6MB)
테스트 6 〉	통과 (0.27ms, 73.8MB)
테스트 7 〉	통과 (0.18ms, 75.2MB)
테스트 8 〉	통과 (0.15ms, 75.2MB)
테스트 9 〉	통과 (0.28ms, 73.6MB)
테스트 10 〉	통과 (0.16ms, 77MB)
테스트 11 〉	통과 (0.23ms, 77.7MB)
테스트 12 〉	통과 (0.17ms, 73.4MB)
테스트 13 〉	통과 (0.17ms, 77.3MB)
테스트 14 〉	통과 (0.20ms, 75.2MB)
테스트 15 〉	통과 (0.29ms, 75.5MB)
테스트 16 〉	통과 (0.23ms, 74MB)
테스트 17 〉	통과 (0.16ms, 74.3MB)
효율성  테스트
테스트 1 〉	통과 (40.68ms, 111MB)
테스트 2 〉	통과 (41.05ms, 116MB)
테스트 3 〉	통과 (40.56ms, 112MB)
테스트 4 〉	통과 (42.04ms, 117MB)
*/
