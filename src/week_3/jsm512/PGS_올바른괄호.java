package week_3.jsm512;


import java.util.*;

public class PGS_올바른괄호 {
    static class Solution {
        /*
        (가 들어오면 push )가 들어오고 peek()가 (면 pop
        */
        boolean solution(String s) {
            boolean answer = true;

            ArrayDeque<Character> q = new ArrayDeque<>();
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(ch == '('){
                    q.push(ch);
                }
                else if(ch == ')'){
                    if(q.isEmpty()) return false;
                    q.pop();
                }
                // System.out.println(q.peek());
            }
            if(!q.isEmpty()) answer = false;

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String k = "()()";
        System.out.println(s.solution(k));

        k = "(())()";
        System.out.println(s.solution(k));

        k = ")()(";
        System.out.println(s.solution(k));

        k = "(()(";
        System.out.println(s.solution(k));
    }
}
