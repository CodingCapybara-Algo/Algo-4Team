package week_3.Shanate;

import java.util.ArrayDeque;
/*
괄호 검사 -> 스택을 사용한다.(Last in, First Out)
ex1) ' ( ) ( ) '
1. '('를 삽입      2. ')' 가 들어오면 비교하여(peek) '('를 추출한다.(poll)
3. 마지막에 스택 검사(isEmpty -> true)
*/

public class PGS_올바른괄호 {

    static boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') { // 개괄호일 경우 스택에 저장
                stack.push(c);
            }
            else if(c == ')'){ // 폐괄호일 경우
                if(stack.isEmpty()) { // case10 스택이 비었을 때(첫장부터 밑장빼기), 탐색 종료
                    answer = false;
                    return answer;
                }
                else{   // 개괄호가 있음을 의미 -> 추출해버린다
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()) {
            answer = true;
        }
        else {
            answer = false;
        }

        return answer;
    }


    public static void main(String[] args) {

        String s = "()()";
        System.out.println(solution(s));

        s = "(())()";
        System.out.println(solution(s));

        s = ")()(";
        System.out.println(solution(s));

        s = "(()(";
        System.out.println(solution(s));
    }
}

/*
테스트 1 〉	통과 (0.10ms, 77.1MB)
테스트 2 〉	통과 (0.03ms, 75.9MB)
테스트 3 〉	통과 (0.03ms, 71.8MB)
테스트 4 〉	통과 (0.19ms, 78.3MB)
테스트 5 〉	통과 (0.12ms, 76.6MB)
테스트 6 〉	통과 (0.02ms, 76.3MB)
테스트 7 〉	통과 (0.12ms, 76.5MB)
테스트 8 〉	통과 (0.17ms, 75.9MB)
테스트 9 〉	통과 (0.11ms, 69.3MB)
테스트 10 〉	통과 (0.13ms, 71.9MB)
테스트 11 〉	통과 (0.09ms, 74.5MB)
테스트 12 〉	통과 (0.14ms, 73.1MB)
테스트 13 〉	통과 (0.15ms, 71.7MB)
테스트 14 〉	통과 (0.20ms, 80.6MB)
테스트 15 〉	통과 (0.21ms, 70.6MB)
테스트 16 〉	통과 (0.16ms, 73.2MB)
테스트 17 〉	통과 (0.22ms, 74.3MB)
테스트 18 〉	통과 (0.17ms, 71.3MB)
효율성  테스트
테스트 1 〉	통과 (14.11ms, 52.9MB)
테스트 2 〉	통과 (13.84ms, 52.6MB)
채점 결과
정확성: 69.5
효율성: 30.5
합계: 100.0 / 100.0
*/