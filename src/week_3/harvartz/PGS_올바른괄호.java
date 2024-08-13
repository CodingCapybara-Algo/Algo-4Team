package week_3.harvartz;
import java.util.*;
public class PGS_올바른괄호 {
    // 괄호의 짝을 잘 맞추는 문제
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int y = 0; y<s.length(); y++){
            // 열린 괄호가 들어온다면 stack에 넣기
            if(s.charAt(y) == '(') {
                stack.push('(');
            }else if(s.charAt(y) == ')'){ // 닫힌 괄호가 검색되었다면
                if(stack.isEmpty()){ // 만약 stack에 아무것도 없으면 짝이 맞지 않음!
                    return false;
                }
                stack.pop(); //그렇지 않은 경우는 열린 괄호가 있다는 뜻이기 때문에 열린괄호를 pop!
            }
        }
        return stack.isEmpty(); // 비어있으면 true, 아니면 false!
    }
}
