package week_2.harvartz;
import java.util.*;
public class PGS_소수찾기 {
        // 내가 생각한 풀이가 틀린 건가?
        // 큰 틀은 맞으나 구현이 아주 엉망진창이다.
        // 내가 생각한 구현 방법과 유사한 블로그 : https://dding9code.tistory.com/18
        static boolean[] visited;
        static int size;
        static Set<Integer> set = new HashSet<>();

        public int solution(String numbers) {
            size = numbers.length();
            visited = new boolean[size];
            String temp = "";
            dfs(0, numbers, temp);

            int answer = 0;
            for(int s : set){
                if(isPrime(s)){
                    answer++;
                }
            }
            return answer;
        }

        public void dfs(int level, String numbers, String s){
            if(level == size) return;

            for(int i = 0; i < size; i++){
                if(!visited[i]){
                    visited[i] = true;
                    set.add(Integer.parseInt(s + numbers.charAt(i)));
                    dfs(level + 1, numbers, s + numbers.charAt(i));
                    visited[i] = false;
                }
            }
        }

        public static boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }
            // 에라토스테네스 체
            // 왜 Math.sqrt(n) 인지 알아야 한다 : https://st-lab.tistory.com/81
            for (int i = 2; i <= (int) Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
}
